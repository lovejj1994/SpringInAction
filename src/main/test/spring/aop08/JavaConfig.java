package spring.aop08;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configuration
//使用javaconfig使用aop
public class JavaConfig {
	
	
	@Bean
	public People people(){
		People people = new People();
		return people;
	}
	
	//within表示限制切点在某个包下，bean表示限制切点为指定的bean
	@Pointcut("execution(* *.eat(String)) && args(food) && within(spring.aop08.*)")
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
