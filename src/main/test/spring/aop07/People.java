package spring.aop07;

import org.springframework.stereotype.Component;

@Component
public class People implements Mother{
	
	public People() {
	}


	@Override
	public void raise() {
		System.out.println("我是一个母亲");
	}

	
	
}
