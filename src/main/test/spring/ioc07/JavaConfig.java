package spring.ioc07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//相当于配置文件里面的<beans>
@Configuration
public class JavaConfig {

	//相当于配置文件里面的<bean>,id为javapan,别人调用这个方法spring会先拦截
	//然后会从spring上下文中获取实体。
	@Bean
	public Pan javapan(){
		Pan pan = new Pan();
		pan.setResource("java配置类");
		return pan;
	}


}
