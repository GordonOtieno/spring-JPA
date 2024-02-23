package com.gordon.springjpa.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
@AttributeOverrides({
	
			@AttributeOverride(
					name = "name",
					column = @Column(name="guardian_name")
					),
			@AttributeOverride(
					name = "email",
					column = @Column(name="guardian_email")
					),
			@AttributeOverride(
					name = "mobile",
					column = @Column(name="guardian_mobile")
					)
			
		})

public class Guardian {
	private String name;
	private String email;
	private String mobile;
	
}
