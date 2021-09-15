package org.springframework.lagou.ioc.demo.factorybean;

/**
 * @author wxy
 */
public class Company {
	private String name;
	private String address;
	private int scale;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "Company{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", scale=" + scale +
				'}';
	}
}