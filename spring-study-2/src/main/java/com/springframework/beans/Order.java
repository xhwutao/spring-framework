package com.springframework.beans;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Description: Order
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/20 17:30
 */
public class Order {
	private LocalDate date;
	private BigDecimal price;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order{" +
				"date=" + date +
				", price=" + price +
				'}';
	}
}
