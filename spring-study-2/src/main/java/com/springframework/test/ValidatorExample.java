package com.springframework.test;

import com.springframework.beans.Order;
import com.springframework.beans.OrderValidator;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Description: ValidatorExample
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/20 17:36
 */
public class ValidatorExample {
	public static void main(String[] args) {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("ValidationMessages");

		Order order = new Order();
		order.setPrice(BigDecimal.ZERO);
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(order, "order");
		ValidationUtils.invokeValidator(new OrderValidator(), order, result);
		for (ObjectError e : result.getAllErrors()) {
			System.out.println(messageSource.getMessage(e, Locale.US));
		}
	}
}
