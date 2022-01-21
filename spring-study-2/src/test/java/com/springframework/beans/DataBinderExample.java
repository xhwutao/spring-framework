package com.springframework.beans;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.util.Date;

/**
 * Description: DataBinderExample
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/21 11:39
 */
public class DataBinderExample {
	public static void main(String[] args) {
		MutablePropertyValues mpv = new MutablePropertyValues();
		mpv.add("name", "davidwang456");
		mpv.add("age", "10");
		mpv.add("birthday", new Date());

		DataBinder db = new DataBinder(new POJOBean());
		db.bind(mpv);

		//添加校验
		db.addValidators(new OrderValidator());
		db.validate();

		db.getBindingResult()
				.getAllErrors()
				.forEach(System.out::println);
	}
}
