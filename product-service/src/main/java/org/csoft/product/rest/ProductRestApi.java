package org.csoft.product.rest;

import java.util.List;

import org.csoft.product.dto.ProductDto;
import org.csoft.product.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductRestApi {
	
	@Autowired
	private ProductsService productsService;
	
	
	@GetMapping(value = "/healthstatus")
	public ResponseEntity<?> healthStatus() {
		return new ResponseEntity<String>("Up & Running", HttpStatus.OK);
	}

	@GetMapping(value = "/getallproducts")
	public ResponseEntity<?> getAllProducts() {
		
		List<ProductDto> obj = productsService.fetchAllProducts();
		
		return new ResponseEntity<List<ProductDto>>(obj, HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveproducts", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
		
		productDto = productsService.saveProduct(productDto);
		
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
	}
}
