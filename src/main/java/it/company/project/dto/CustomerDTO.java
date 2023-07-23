package it.company.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
	
	private UUID id;
	private String name;
	private String email;
	private List<ProductDTO> products;
	
}
