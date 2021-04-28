package edu.miu.cs.cs544;

public class Greeting {

	private String greeting;

	public Greeting() {}

	public Greeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(greeting);
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
