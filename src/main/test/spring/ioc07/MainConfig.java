package spring.ioc07;

import javax.annotation.Resources;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


//可以导入其他java配置类，MainConfig为主配置类
@Import({JavaConfig.class})
@ImportResource("classpath:ioc07.xml")
public class MainConfig {

}
