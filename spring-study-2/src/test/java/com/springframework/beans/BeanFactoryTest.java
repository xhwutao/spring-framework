package com.springframework.beans;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanFactoryTest {
	public static void main(String[] args) {
		//设置属性
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		//设置bean定义
		propertyValues.addPropertyValue("helloWorld","Hello!wxy!");
		//注册bean定义
		RootBeanDefinition definition = new RootBeanDefinition(HelloBean.class, null, propertyValues);
		DefaultListableBeanFactory reg = new DefaultListableBeanFactory();
		reg.registerBeanDefinition("helloBean",definition);
		BeanFactory factory = (BeanFactory)reg;
		HelloBean hello = (HelloBean) factory.getBean("helloBean");
		System.out.println(hello.getHelloWorld());
	}
}