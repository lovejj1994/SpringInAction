package spring.aop05;

import org.springframework.stereotype.Component;

@Component
public class People {
	
	public People() {

	}


	public void eat() {
		System.out.println("该吃饭了...");
	}

	
	
}
