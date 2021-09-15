package org.springframework.lagou.ioc.demo.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author 应癫
 * @create 2019/12/3 11:46
 */
public class LagouBean implements InitializingBean {
	/**
	 * 构造函数
	 */
	public LagouBean() {
		System.out.println("LagouBean 构造器...");
	}

	/**
	 * InitializingBean 接⼝实现
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LagouBean afterPropertiesSet...");
	}

	public void print() {
		System.out.println("print方法业务逻辑执行");
	}
}