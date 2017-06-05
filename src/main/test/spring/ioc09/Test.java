package spring.ioc09;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

//使用spring-test测试模块，junit启动时自动加载上下文
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring上下文的配置信息，有两个配置类，选择MainConfig.java主配置类
@ContextConfiguration(classes = spring.ioc09.MainConfig.class)
//测试自定义限定符注解（@Qualifier）
public class Test {

	@Autowired(required = false)
	@Qualifier("pan")           //javapan和xmlpan都拥有@Qualifier("pan")定义,第一层spring无法区分该注入哪个Pan实例
	@java						//通过@java做第二层区分
	public Pan javaOne;

	@Autowired(required = false)
	@Qualifier("pan")			//javapan和xmlpan都拥有@Qualifier("pan")定义,第一层spring无法区分该注入哪个Pan实例
	@xml						//通过@xml做第二层区分
	public Pan javaTwo;	

	@org.junit.Test
	public void test() {
		if (!ObjectUtils.isEmpty(javaOne))
			javaOne.show();
		if (!ObjectUtils.isEmpty(javaTwo)) {
			javaTwo.show();
		}
	}

}
