package com.springframework.beans;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Collection;

/**
 * Description: ConversionServiceExample
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/21 18:07
 */
public class ConversionServiceExample {
	public static void main(String[] args) {
		DefaultConversionService service = new DefaultConversionService();
		System.out.println(service);

		Collection<String> list = service.convert("Deb,Mike,Kim,Kim", Collection.class);
		//LinkedHashSet
		System.out.println(list);
	}
}
