package org.csoft.product.util;

import java.util.List;

import org.csoft.product.dto.ProductDto;
import org.csoft.product.model.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;

public interface MapperTransform {
	ModelMapper mapper = new ModelMapper();
    
	default <T> List<T> transformModelToDto(List<?> model, Class<T> targetClass) {
		TypeMap<ProductEntity, ProductDto> propMapper = mapper.typeMap(ProductEntity.class, ProductDto.class);
		propMapper.addMapping(src -> src.getLocation().getCity(), ProductDto::setCity);
		propMapper.addMapping(src -> src.getLocation().getState(), ProductDto::setState);
		Type destinationType = new TypeToken<List<ProductDto>>() {}.getType();
		/*return Optional.ofNullable(model).orElse(Collections.emptyList())
				.stream().map(obj -> mapper.map(obj, targetClass)).collect(Collectors.toList());*/
		return mapper.map(model, destinationType);
	}
	
	default <T> T transformDtoToModel(Object dto, Class<T> targetClass) {
		TypeMap<ProductDto, ProductEntity> propMapper = mapper.typeMap(ProductDto.class, ProductEntity.class);
		propMapper.addMappings(
		map ->  map.<String>map(ProductDto::getCity, (dest, v) -> dest.getLocation().setCity(v)));
		
		propMapper.addMappings(
				map -> map.<String>map(ProductDto::getState, (dest, v) -> dest.getLocation().setState(v)));
		
		return mapper.map(dto, targetClass);
	}
	
	default <T> T transformModelToDto(Object dto, Class<T> targetClass) {
		TypeMap<ProductEntity, ProductDto> propMapper = mapper.typeMap(ProductEntity.class, ProductDto.class);
		propMapper.addMapping(src -> src.getLocation().getCity(), ProductDto::setCity);
		return mapper.map(dto, targetClass);
	}
}
