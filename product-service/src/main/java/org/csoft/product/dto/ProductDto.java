package org.csoft.product.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDto implements Serializable {
	private int id;
	private String name;
	private float price;
	private String coupenCode;
	private String city;
	private String state;
}