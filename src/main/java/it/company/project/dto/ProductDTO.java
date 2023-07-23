package it.company.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
	
	private UUID id;
	private String name;
	private Long price;
	private LocalDateTime publishDate;
	
}
