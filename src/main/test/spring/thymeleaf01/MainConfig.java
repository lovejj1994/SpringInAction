package spring.thymeleaf01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.thymeleaf.TemplateEngine;


//可以导入其他java配置类，MainConfig为主配置类
@Import({JavaConfig.class})
public class MainConfig {

}
