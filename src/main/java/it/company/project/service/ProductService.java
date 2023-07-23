package it.company.project.service;

import it.company.project.dto.ProductDTO;
import it.company.project.dto.ProductRequest;
import it.company.project.entity.Customer;
import it.company.project.entity.Product;
import it.company.project.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends BaseService<Product, UUID, ProductRepository, ProductDTO> {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository repository, ModelMapper modelMapper, ProductRepository productRepository) {
		super(Product.class, repository, ProductDTO.class, modelMapper);
		this.productRepository = productRepository;
	}
	
	public List<ProductDTO> getProducts() {
		return toDtoList(getAll());
	}
	
	public ProductDTO getProductById(UUID id) {
		return toDto(getById(id));
	}
	
	@Transactional
	public ProductDTO saveProduct(ProductRequest request) {
		Product product = modelMapper.map(request, Product.class);
		return toDto(save(product));
	}
	
	@Transactional
	public ProductDTO editProduct(UUID id, ProductRequest request) {
		Product product = getById(id);
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		return toDto(save(product));
	}
	
	@Transactional
	public void deleteProduct(UUID id) {
		delete(getById(id));
	}
	
	// ------------------------------------------------------------------------
	
	public List<ProductDTO> getCustomerProducts(Customer customer) {
		return toDtoList(productRepository.findByCustomer(customer));
	}
	
	@Transactional
	public ProductDTO saveCustomerProduct(Customer customer, ProductRequest request) {
		Product product = modelMapper.map(request, Product.class);
		product.setCustomer(customer);
		return toDto(save(product));
	}
	
}
