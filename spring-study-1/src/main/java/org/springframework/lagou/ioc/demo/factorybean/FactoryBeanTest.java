package org.springframework.lagou.ioc.demo.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Description: TODO
 *
 * @author wxy
 * @version 1.0
 * @date 2021/8/2 22:45
 */
public class FactoryBeanTest {
	@Bean("companyBean")
	public CompanyFactoryBean getCompanyFactoryBean() {
		String companyInfo = "拉勾,中关村,500";
		CompanyFactoryBean companyFactoryBean = new CompanyFactoryBean();
		companyFactoryBean.setCompanyInfo(companyInfo);
		return companyFactoryBean;
	}


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(FactoryBeanTest.class);
		context.refresh();

		Object companyBean = context.getBean("companyBean");
		System.out.println(companyBean);

		Object companyBean2 = context.getBean("companyBean");
		assert companyBean == companyBean2;

		Object companyBean3 = context.getBean("&companyBean");
		System.out.println(companyBean3);

		context.close();
	}
}
