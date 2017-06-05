package spring.ioc11;

import javax.management.MXBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//相当于配置文件里面的<beans>
@Configuration
@PropertySource(value="classpath:ioc10.properties")
public class JavaConfig {
	
	@Autowired
	private Environment environment;
	
	
	@Bean
	public Pan javapan() {
		Pan pan = new Pan();
		pan.setResource(environment.getProperty("mothed"));
		return pan;
	}

}
