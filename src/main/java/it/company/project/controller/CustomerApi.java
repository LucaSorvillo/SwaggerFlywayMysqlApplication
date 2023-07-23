package it.company.project.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import it.company.project.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@OpenAPIDefinition(servers = {@Server(url = "{url}", variables = {@ServerVariable(name = "url", defaultValue = "../")})})
//@SecurityScheme(name = "Bearer Authentication", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public interface CustomerApi {
	
	@Operation(summary = "List Customers",
			description = "List Customers",
			tags = "customers")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	List<CustomerDTO> getCustomers();
	
	@Operation(summary = "Get Customer",
			description = "Get Customer",
			tags = "customers")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	CustomerDTO getCustomerById(
			@PathVariable UUID id);
	
	@Operation(summary = "Create Customer",
			description = "Create Customer",
			tags = "customers")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	CustomerDTO saveCustomer(
			@Valid @RequestBody CustomerRequest request);
	
	@Operation(summary = "Edit Customer",
			description = "Edit Customer",
			tags = "customers")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	CustomerDTO editCustomer(
			@PathVariable UUID id,
			@Valid @RequestBody CustomerRequest request);
	
	@Operation(summary = "Delete Customer",
			description = "Delete Customer",
			tags = "customers")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@DeleteMapping(value = "/{id}")
	void deleteCustomer(
			@PathVariable UUID id);
	
	// ------------------------------------------------------------------------
	
	@Operation(summary = "Get Products",
			description = "Get Products",
			tags = "customers")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@GetMapping(value = "/{id}/products", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ProductDTO> getCustomerProducts(
			@PathVariable UUID id);
	
	@Operation(summary = "Create Product",
			description = "Create Product",
			tags = "customers")
	@ApiResponse(responseCode = "200")
	@ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = ErrorDTO.class))})
	@PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDTO saveCustomerProduct(
			@PathVariable UUID id,
			@Valid @RequestBody ProductRequest request);
	
}
