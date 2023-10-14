package org.csoft.product.services.Impl;

import java.util.List;

import org.csoft.product.dto.ProductDto;
import org.csoft.product.model.ProductEntity;
import org.csoft.product.repository.ProductRepository;
import org.csoft.product.services.ProductsService;
import org.csoft.product.util.MapperTransform;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.coupen.host}")
	private String hostUrl;
	
	@Value("${api.coupen.path:demo}")
	private String path;
	
	private final MapperTransform transform = new MapperTransform(){}; 

	public List<ProductDto> fetchAllProducts() {
		log.info("Executing fetchAllProducts");
		ModelMapper mapper = new ModelMapper();
		return transform.transformModelToDto(productRepository.findAll(), ProductDto.class);
	}
	
	public ProductDto saveProduct(ProductDto productDto) {
		log.info("Coupen Host Url:{} & path:{}", hostUrl, path);
		String coupenCode = restTemplate.getForObject(hostUrl.concat(path), String.class);
		log.info("Coupen Code:{}", coupenCode);
	    ProductEntity model = transform.transformDtoToModel(productDto, ProductEntity.class); 
	    model.setCoupenCode(coupenCode);
	    model = productRepository.save(model);
	    log.info("model:{}", model.toString());
	    return transform.transformModelToDto(model, ProductDto.class);
	}

}
