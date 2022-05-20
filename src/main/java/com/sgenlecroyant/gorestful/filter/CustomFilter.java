package com.sgenlecroyant.gorestful.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service(value = "customFilter")
public class CustomFilter {

	private PropertyFilter getPropsFilter(String... props) {
		PropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(props);
		return propertyFilter;
	}

	private SimpleFilterProvider getFilterProvider(String filterId, String... props) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(filterId, this.getPropsFilter(props));
		return filterProvider;
	}

	public <T> MappingJacksonValue mapValues(T values, String filterId, String... props) {
//		if(values.getClass().isInstance(List.class)) {
		SimpleFilterProvider filterProvider = this.getFilterProvider(filterId, props);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(values);
		mappingJacksonValue.setFilters(filterProvider);
//		}
		return mappingJacksonValue;
	}

}
