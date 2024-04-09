package org.springframework.test;

import org.springframework.beans.HelloBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringTest01 {
	public static void main(String[] args) {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		HelloBean helloWorld = (HelloBean) beanFactory.getBean("helloWorld");
		System.out.println(helloWorld.getHelloWorld());

		//过时了 使用defaultListableBeanFactory
		DefaultListableBeanFactory beanFactory2 = new DefaultListableBeanFactory();
		Resource resource = new ClassPathResource("beans.xml");
		new XmlBeanDefinitionReader(beanFactory2).loadBeanDefinitions(resource);
		HelloBean helloWorld2 = (HelloBean) beanFactory2.getBean("helloWorld");
		System.out.println(helloWorld2.getHelloWorld());
	}
}
