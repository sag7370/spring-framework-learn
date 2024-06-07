package org.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object myBean = context.getBean("myBean");
		System.out.println(myBean);
	}
}
