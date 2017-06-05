package spring.aop08;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

//使用spring-test测试模块，junit启动时自动加载上下文
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring上下文的配置信息，有两个配置类，选择MainConfig.java主配置类
@ContextConfiguration(classes = spring.aop08.JavaConfig.class)
//测试使用@ PropertySource 注解 和 Environment读取文本文件
public class Test {

	@Autowired(required = false)
	@Qualifier("people")
	public Man man;
	
	@Autowired(required = false)
	public People people;	

	@org.junit.Test
	public void test() {
		if (!ObjectUtils.isEmpty(people))
			people.eat("馒头");
		if (!ObjectUtils.isEmpty(man))
			man.eat("馒头");
	}

}
