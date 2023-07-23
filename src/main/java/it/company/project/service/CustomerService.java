package it.company.project.service;

import it.company.project.dto.*;
import it.company.project.entity.Customer;
import it.company.project.entity.Product;
import it.company.project.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<Customer, UUID, CustomerRepository, CustomerDTO> {
	
	private final ProductService productService;
	
	public CustomerService(CustomerRepository repository, ModelMapper modelMapper, ProductService productService) {
		super(Customer.class, repository, CustomerDTO.class, modelMapper);
		this.productService = productService;
	}
	
	public List<CustomerDTO> getCustomers() {
		return toDtoList(getAll());
	}
	
	public CustomerDTO getCustomerById(UUID id) {
		return toDto(getById(id));
	}
	
	@Transactional
	public CustomerDTO saveCustomer(CustomerRequest request) {
		Customer customer = modelMapper.map(request, Customer.class);
		return toDto(save(customer));
	}
	
	@Transactional
	public CustomerDTO editCustomer(UUID id, CustomerRequest request) {
		Customer customer = getById(id);
		customer.setName(request.getName());
		customer.setEmail(request.getEmail());
		return toDto(save(customer));
	}
	
	@Transactional
	public void deleteCustomer(UUID id) {
		delete(getById(id));
	}
	
	// ------------------------------------------------------------------------
	
	public List<ProductDTO> getCustomerProducts(UUID id) {
		return productService.getCustomerProducts(getById(id));
	}
	
	@Transactional
	public ProductDTO saveCustomerProduct(UUID id, ProductRequest productRequest) {
		return productService.saveCustomerProduct(getById(id), productRequest);
	}
}
