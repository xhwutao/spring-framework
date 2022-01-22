package com.springframework.test;

import com.springframework.beans.HelloBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Description: XmlBeanFactoryTest
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/18 14:11
 */
public class XmlBeanFactoryTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
		//reader.loadBeanDefinitions("classpath:com/springframework/beans/beans.xml");
		reader.loadBeanDefinitions("classpath:beans.xml");
		BeanFactory container = (BeanFactory) beanRegistry;
		HelloBean hello = (HelloBean) container.getBean("helloWorld");
		System.out.println(hello.getHelloWorld());
	}
}
