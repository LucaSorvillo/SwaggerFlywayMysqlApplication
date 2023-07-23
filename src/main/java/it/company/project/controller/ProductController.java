package it.company.project.controller;

import it.company.project.dto.ProductDTO;
import it.company.project.dto.ProductRequest;
import it.company.project.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController implements ProductApi {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public List<ProductDTO> getProducts() {
		return productService.getProducts();
	}
	
	@Override
	public ProductDTO getProductById(UUID id) {
		return productService.getProductById(id);
	}
	
	@Override
	public ProductDTO saveProduct(ProductRequest request) {
		return productService.saveProduct(request);
	}
	
	@Override
	public ProductDTO editProduct(UUID id, ProductRequest request) {
		return productService.editProduct(id, request);
	}
	
	@Override
	public void deleteProduct(UUID id) {
		productService.deleteProduct(id);
	}

}
