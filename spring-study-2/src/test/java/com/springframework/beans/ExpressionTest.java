package com.springframework.beans;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Description: ExpressionTest
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/21 23:20
 */
public class ExpressionTest {
	public static void main(String[] args) {
		SpelExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("new String('hello').toUpperCase()");
		String message = exp.getValue(String.class);
		System.out.println(message);
	}
}
