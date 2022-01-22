package com.springframework.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Description: LogAspect
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/22 10:30
 */
@Aspect
public class LogAspect {
	@Before("execution(* sayHello(..))")
	public void beforeHello(){
		System.out.println("how are you");
		throw new NullPointerException();
	}
}
