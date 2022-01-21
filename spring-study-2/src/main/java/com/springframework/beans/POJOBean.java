package com.springframework.beans;

import java.util.Date;

/**
 * Description: POJOBean
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/20 19:45
 */
public class POJOBean {
	private int age;
	private String name;
	private Date birthday;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "POJOBean{" +
				"age=" + age +
				", name='" + name + '\'' +
				", birthday=" + birthday +
				'}';
	}
}
