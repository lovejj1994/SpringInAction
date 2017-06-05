package spring.aop07;

import org.springframework.stereotype.Component;

@Component
public class People2 implements Teacher {

	
	public People2() {
	}

	@Override
	public void teach() {
		System.out.println("我也是个教师");
	}

}
