package spring.springmvc01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"spring.springmvc01"},
		excludeFilters={
			//不扫描@EnableWebMvc注解的组件
			@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
		})
public class SpringConfig {

}
