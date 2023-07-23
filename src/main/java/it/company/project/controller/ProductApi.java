package it.company.project.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import it.company.project.dto.ErrorDTO;
import it.company.project.dto.ProductDTO;
import it.company.project.dto.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@OpenAPIDefinition(servers = {@Server(url = "{url}", variables = {@ServerVariable(name = "url", defaultValue = "../")})})
//@SecurityScheme(name = "Bearer Authentication", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public interface ProductApi {
	
	@Operation(summary = "List Products",
			description = "List Products",
			tags = "products")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	List<ProductDTO> getProducts();
	
	@Operation(summary = "Get Product",
			description = "Get Product",
			tags = "products")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDTO getProductById(
			@PathVariable UUID id);
	
	@Operation(summary = "Create Product",
			description = "Create Product",
			tags = "products")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDTO saveProduct(
			@Valid @RequestBody ProductRequest request);
	
	@Operation(summary = "Edit Product",
			description = "Edit Product",
			tags = "products")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDTO editProduct(
			@PathVariable UUID id,
			@Valid @RequestBody ProductRequest request);
	
	@Operation(summary = "Delete Product",
			description = "Delete Product",
			tags = "products")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@DeleteMapping(value = "/{id}")
	void deleteProduct(
			@PathVariable UUID id);
	
}
