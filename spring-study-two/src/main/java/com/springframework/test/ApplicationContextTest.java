package com.springframework.test;

import com.springframework.beans.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: ApplicationContextTest
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/18 14:41
 */
public class ApplicationContextTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		Employee emp = (Employee) context.getBean("bean1");
		System.out.println(emp.getAge());
	}
}
