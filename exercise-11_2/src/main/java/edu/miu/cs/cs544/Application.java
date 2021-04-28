package edu.miu.cs.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("springconfig.xml");

		IProductService productService = context.getBean("productService", IProductService.class);

		System.out.println(productService.getProduct(423));
		System.out.println(productService.getProduct(239));

		System.out.println(
				"we have " + productService.getNumberInStock(423) + " product(s) with productNumber 423 in stock");
		System.out.println(
				"we have " + productService.getNumberInStock(239) + " product(s) with productNumber 239 in stock");

	}
}