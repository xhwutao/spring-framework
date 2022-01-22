package com.springframework.test;

import com.springframework.aop.HelloService;
import com.springframework.aop.LogAspect;
import org.apache.commons.logging.Log;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * Description: AspectTest
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/22 10:31
 */
public class AspectTest {
	public static void main(String[] args) {
		HelloService target = new HelloService();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		factory.setTarget(target);
		factory.addAspect(LogAspect.class);
		HelloService proxy = factory.getProxy();
		proxy.sayHello("一只羊");
	}
}
