package org.csoft.product.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class LocationEntity {
  
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
}
