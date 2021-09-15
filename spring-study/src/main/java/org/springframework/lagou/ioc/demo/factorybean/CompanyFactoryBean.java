package org.springframework.lagou.ioc.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Description: TODO
 *
 * @author wxy
 * @version 1.0
 * @date 2021/8/2 22:43
 */
public class CompanyFactoryBean implements FactoryBean<Company> {
	private String companyInfo;

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	@Override
	public Company getObject() throws Exception {
		// 模拟创建复杂对象Company
		Company company = new Company();
		String[] strings = companyInfo.split(",");
		company.setName(strings[0]);
		company.setAddress(strings[1]);
		company.setScale(Integer.parseInt(strings[2]));
		return company;
	}

	@Override
	public Class<?> getObjectType() {
		return Company.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
