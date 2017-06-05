package spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;

public class Life {
	
	public Life() {
	}
	
	public void round(ProceedingJoinPoint point) throws Throwable{
		getUp();
		
		point.proceed();
		
		work();
	}
	
	public void getUp(){
		System.out.println("起床。。。。。");
	}
	
	public void work(){
		System.out.println("工作。。。。。");
	}
}
