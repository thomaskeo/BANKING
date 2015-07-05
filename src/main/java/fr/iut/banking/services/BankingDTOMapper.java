package fr.iut.banking.services;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.stereotype.Component;

@Component
public class BankingDTOMapper {

	private MapperFacade mapper;
	
	public BankingDTOMapper() {
		MapperFactory factory = new DefaultMapperFactory.Builder().build();
//		factory.registerClassMap(factory.classMap(Order.class,OrderDTO.class)
//		  .field("product.state.type.label", "stateLabel")
//		  .field("product.name", "productName").toClassMap());
		        
		this.mapper = factory.getMapperFacade();
	}
	
	public <TDto,TEntity> List<TDto> mapAsList(List<TEntity> src, Class<TDto> clss) {
		return mapper.mapAsList(src, clss);
	}
	
	public <TDto,TEntity> TDto map(TEntity src, Class<TDto> clss) {
		return mapper.map(src, clss);
	}
	
}
