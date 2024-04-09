package org.springframework.lagou.ioc.demo.lifecycle;

public class LogUtils {

	public void beforeMethod() {
		System.out.println("前置通知");
	}
}