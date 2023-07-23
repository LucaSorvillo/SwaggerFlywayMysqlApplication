package it.company.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductRequest {
	
	private String name;
	private Long price;
	
}