package spring.ioc11;

import org.springframework.context.annotation.Import;


//可以导入其他java配置类，MainConfig为主配置类
@Import({JavaConfig.class})
public class MainConfig {

}
