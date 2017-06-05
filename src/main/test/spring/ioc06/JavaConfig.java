package spring.ioc06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//相当于配置文件里面的<beans>
@Configuration
@ComponentScan(basePackages="spring.ioc06")
public class JavaConfig {

	//相当于配置文件里面的<bean>,id为getPiano,别人调用这个方法spring会先拦截
	//然后会从spring上下文中获取实体。
	@Bean
	public Instruments getPiano(){
		return new Piano();
	}


}
