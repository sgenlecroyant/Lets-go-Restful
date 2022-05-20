package com.sgenlecroyant.gorestful.generic;

public class PropertyGen<T> {
	
	private String valueType;
	
	public PropertyGen(String valueType) {
		this.valueType = valueType;
	}
	
	public String getValueType() {
		return valueType;
	}
	
}
