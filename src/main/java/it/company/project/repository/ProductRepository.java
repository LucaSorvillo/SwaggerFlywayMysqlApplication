package it.company.project.repository;

import it.company.project.entity.Customer;
import it.company.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	List<Product> findByCustomer(@NonNull Customer customer);
	List<Product> findByCustomer_Id(@NonNull UUID id);
}