package spring.aop06;

import org.springframework.stereotype.Component;

@Component
public class People {
	
	public People() {
	}


	public void eat(String food) {
		System.out.println("该吃" + food + "了...");
	}

	
	
}
