package spring.ioc08;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

//使用spring-test测试模块，junit启动时自动加载上下文
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring上下文的配置信息，有两个配置类，选择MainConfig.java主配置类
@ContextConfiguration(classes = spring.ioc08.MainConfig.class)
//测试@Conditional
public class Test {

	@Autowired(required = false)
	public Pan javapan;

	@Autowired(required = false)
	public Pan xmlpan;	

	@org.junit.Test
	public void test() {
		if (!ObjectUtils.isEmpty(javapan))
			javapan.show();
		if (!ObjectUtils.isEmpty(xmlpan)) {
			xmlpan.show();
		}
	}

}
