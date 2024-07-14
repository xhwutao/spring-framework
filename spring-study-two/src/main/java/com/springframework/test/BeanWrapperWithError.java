package com.springframework.test;

import com.springframework.beans.POJOBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;

import java.util.Date;

/**
 * Description: TODO
 *
 * @author wxy
 * @version 1.0
 * @date 2022/1/20 19:47
 */
public class BeanWrapperWithError {
	public static void main(String[] args) {
		MutablePropertyValues mpv = new MutablePropertyValues();
		mpv.add("name","davidwang456");
		mpv.add("age","10");
		mpv.add("birthday", new Date());

		BeanWrapper bw = new BeanWrapperImpl(new POJOBean());
		bw.setPropertyValues(mpv);
		System.out.println(bw.getWrappedInstance());
	}
}
