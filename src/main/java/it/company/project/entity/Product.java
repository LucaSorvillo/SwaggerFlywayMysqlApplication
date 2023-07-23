package it.company.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 36)
	@JdbcTypeCode(SqlTypes.CHAR)
	private UUID id;
	private String name;
	private Long price;
	@CreationTimestamp
	private LocalDateTime publishDate;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
}