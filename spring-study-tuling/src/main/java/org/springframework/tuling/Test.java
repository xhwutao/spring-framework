package org.springframework.tuling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.tuling.service.UserService;

/**
 * Description: TODO
 *
 * @author wxy
 * @version 1.0
 * @date 2022/7/4 17:13
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		userService.test();
	}
}
