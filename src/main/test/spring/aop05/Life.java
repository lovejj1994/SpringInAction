package spring.aop05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Life {
	
	//	一开始以为@Pointcut是放在构造函数上，原来是要放在一个没有实际用途的方法上
	//	，供@Pointcut注解依附	
	@Pointcut("execution(* *.eat())")
	public void life() {
	}
	@Before("life()")
	public void getUp() {
		System.out.println("起床。。。。。");
	}
	@After("life()")
	public void work() {
		System.out.println("工作。。。。。");
	}

}
