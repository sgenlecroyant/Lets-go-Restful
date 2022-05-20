package com.sgenlecroyant.gorestful.filter;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service(value = "customFilter")
public class CustomFilter {
	
	
	private PropertyFilter getPropsFilter(String...props) {
		PropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(props);
		return propertyFilter;
	}
	
	public SimpleFilterProvider getFilterProvider(String filterId, String ...props) {
		
		SimpleFilterProvider filterProvider = 
				new SimpleFilterProvider();
		filterProvider.addFilter(filterId, this.getPropsFilter(props));
		return filterProvider;
	}
	
	public <T> MappingJacksonValue mapValues(List<T> values, String filterId , String ...props) {
		MappingJacksonValue mappingJacksonValue = 
				new MappingJacksonValue(values);
		mappingJacksonValue.setFilters(this.getFilterProvider(filterId, props));
		return mappingJacksonValue;
	}
	
}
