package com.kiuwan.client.utils;

import java.lang.reflect.Field;

public class ClassToStringConverter {

	public static String toString(String prefix, Object instance){
		StringBuilder stringRepresentation = new StringBuilder(prefix+" [");
		Field[] declaredFields = instance.getClass().getDeclaredFields();
		String separator = null;
		for (Field field : declaredFields) {
			String fieldName = field.getName();
			Object value = null;
			try {
				field.setAccessible(true);
				value = field.get(instance);
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
			finally{
				field.setAccessible(false);
			}
			if(value != null){
				if(separator == null){
					stringRepresentation.append(fieldName+"="+value);
					separator = ", ";
				}
				else{
					stringRepresentation.append(separator+fieldName+"="+value);
				}
			}
		}
		stringRepresentation.append("]");
		
		return stringRepresentation.toString();
	}
	
}
