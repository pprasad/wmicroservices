package org.csoft.product.services;

import java.util.List;

import org.csoft.product.dto.ProductDto;

public interface ProductsService {

	public List<ProductDto> fetchAllProducts();
	
	public ProductDto saveProduct(ProductDto productDto);
}
