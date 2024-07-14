package com.springframework.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Description: OrderValidator
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/20 17:31
 */
public class OrderValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Order.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "date", "date.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.empty");
		Order order = (Order) target;
		if (order.getPrice() != null && order.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
			errors.rejectValue("price", "price.invalid");
		}
	}
}
