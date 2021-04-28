package edu.miu.cs.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("springconfig.xml");

		Greeting gService = context.getBean("greetingService", Greeting.class);
		
		gService.sayHello();
		
	}
}