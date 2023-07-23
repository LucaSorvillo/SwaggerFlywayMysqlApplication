package it.company.project.controller;

import it.company.project.dto.*;
import it.company.project.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController implements CustomerApi {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public List<CustomerDTO> getCustomers() {
		return customerService.getCustomers();
	}
	
	@Override
	public CustomerDTO getCustomerById(UUID id) {
		return customerService.getCustomerById(id);
	}
	
	@Override
	public CustomerDTO saveCustomer(CustomerRequest request) {
		return customerService.saveCustomer(request);
	}
	
	@Override
	public CustomerDTO editCustomer(UUID id, CustomerRequest request) {
		return customerService.editCustomer(id, request);
	}
	
	@Override
	public void deleteCustomer(UUID id) {
		customerService.deleteCustomer(id);
	}
	
	// ------------------------------------------------------------------------
	
	public List<ProductDTO> getCustomerProducts(UUID id) {
		return customerService.getCustomerProducts(id);
	}
	
	public ProductDTO saveCustomerProduct(UUID id, ProductRequest request) {
		return customerService.saveCustomerProduct(id, request);
	}

}
