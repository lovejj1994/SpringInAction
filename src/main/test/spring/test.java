package spring;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop01.People;
import spring.ioc01.Pan;
import spring.ioc02.OneInstance;

public class test {

	/**
	 * aop01 aop的简单实践
	 */
	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop01.xml");

		People people = (People) context.getBean("people");
		people.eat();
	}

	/**
	 * ioc01 xml使用构造方法
	 */
	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ioc01.xml");

		Pan pan = (Pan) context.getBean("pan");
		pan.perform();
	}

	/**
	 * ioc02 <bean> 中使用factory-method属性 完成没构造函数情况下的实例化（单例）
	 */
	@Test
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ioc02.xml");

		OneInstance instance = (OneInstance) context.getBean("oneInstance");
		instance.finish();
	}

	/**
	 * ioc03 装配List,map,set
	 */
	@Test
	public void test4() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ioc03.xml");

		// List
		spring.ioc03.Pan pan = (spring.ioc03.Pan) context.getBean("pan");
		pan.performance();
	}

	/**
	 * spring.SpEL01 学习SpEL表达式
	 */
	@Test
	public void test5() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpEL01.xml");

		spring.SpEL01.UUID uuid = (spring.SpEL01.UUID) context
				.getBean("myuuid");
		// 去掉横杠后的UUID
		spring.SpEL01.NewUUID newUUID = (spring.SpEL01.NewUUID) context
				.getBean("newUuid");
		uuid.show();
		newUUID.show();
	}

	/**
	 * spring.ioc04 autowire减少xml配置
	 */
	@Test
	public void test6() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ioc04.xml");
		spring.ioc04.Pan pan = (spring.ioc04.Pan) context.getBean("pan");
		pan.performance();
	}

	/**
	 * spring.ioc05 <context:component-scan>的应用
	 */
	@Test
	public void test7() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ioc05.xml");

		spring.ioc05.Cello cello = (spring.ioc05.Cello) context
				.getBean("cello");

		spring.ioc05.Pan pan = (spring.ioc05.Pan) context.getBean("pan");
		pan.performance();
	}

	/**
	 * spring.ioc06
	 * 通过java代码装配bean
	 * @bean @Configuration的应用
	 */
	@Test
	public void test8() {
		ApplicationContext context = new AnnotationConfigApplicationContext(spring.ioc06.JavaConfig.class);
		spring.ioc06.Instruments instrument = (spring.ioc06.Instruments) context
				.getBean("getPiano");
		instrument.play();
	}

	/**
	 * spring.aop02 环绕通知aop
	 */
	@Test
	public void test9() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop02.xml");
		spring.aop02.People people = (spring.aop02.People) context
				.getBean("people");
		people.eat();
	}

	/**
	 * spring.aop03 aop传入参数
	 */
	@Test
	public void test10() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop03.xml");
		spring.aop03.People people = (spring.aop03.People) context
				.getBean("people");
		people.eat("馒头");
	}
	
	/**
	 * spring.aop04 <aop:declare-parents>的应用
	 */
	@Test
	public void test11() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop04.xml");
		spring.aop04.Mother mother = (spring.aop04.Mother) context
				.getBean("mother");
		mother.raise();
		((spring.aop04.Teacher)mother).teach();
	}

	/**
	 * spring.aop05 注解切面的应用（1）
	 */
	@Test
	public void test12() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop05.xml");
		spring.aop05.People people = (spring.aop05.People) context
				.getBean("people");
		people.eat();
	}
	
	/**
	 * spring.aop06 注解切面的应用（2）--传入参数
	 */
	@Test
	public void test13() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop06.xml");
		spring.aop06.People people = (spring.aop06.People) context
				.getBean("people");
		people.eat("馒头");
	}
	
	/**
	 * spring.aop07 <aop:declare-parents>的注解用法
	 */
	@Test
	public void test14() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop07.xml");
		spring.aop07.Mother mother = (spring.aop07.Mother) context
				.getBean("people");
		mother.raise();
		((spring.aop07.Teacher)mother).teach();
	}
}
