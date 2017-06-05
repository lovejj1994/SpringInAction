package spring.aop06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Life {
	@Pointcut("execution(* *.eat(String)) && args(food)")
	public void life(String food) {
	}
	
	@Before("life(food)")
	public void getUp(String food) {
		System.out.println("起床。。。。。我知道你要吃" + food);
	}
	@After("life(food)")
	public void work(String food) {
		System.out.println("工作。。。。。");
	}

	
}
