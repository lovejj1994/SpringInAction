package spring.test02;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;



public class Test {
	@Rule
	//拦截System.out的输出语句
	public final SystemOutRule log = new SystemOutRule().enableLog();
	
	@org.junit.Test
	public void test(){
		//junit的静态方法，以这个举例，如果两句话不相等，就抛出异常。
		//assertEquals("i like you", "i like you ");
		System.out.print("i love you ");
		assertEquals("i love you", log.getLog());
	}
}
