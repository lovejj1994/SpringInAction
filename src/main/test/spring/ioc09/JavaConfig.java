package spring.ioc09;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//相当于配置文件里面的<beans>
@Configuration
public class JavaConfig {

	@Bean
	@Qualifier("pan")         //在配置类中，@Qualifier("pan") 表示定义一个id为pan的实例
	@java					  //如果其他类也定义了一个@Qualifier("pan")，可以通过第二层创建一个自定义限定符注解。
	public Pan javapan() {
		Pan pan = new Pan();
		pan.setResource("java自定义限定符注解");
		return pan;
	}

	@Bean
	@Qualifier("pan")
	@xml
	public Pan xmlpan() {
		Pan pan = new Pan();
		pan.setResource("xml自定义限定符注解");
		return pan;
	}

}
