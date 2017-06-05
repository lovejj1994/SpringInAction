package spring.thymeleaf01;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.google.common.collect.Maps;

//使用spring-test测试模块，junit启动时自动加载上下文
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring上下文的配置信息，有两个配置类，选择MainConfig.java主配置类
@ContextConfiguration(classes = spring.thymeleaf01.MainConfig.class)
public class Test {


	@Autowired(required = false)
	public SpringTemplateEngine templateEngine;	
	@Autowired(required = false)
	public ThymeleafViewResolver viewResolver;	
	@Autowired(required = false)
	public FileTemplateResolver templateResolver;	

	@org.junit.Test
	public void test() throws FileNotFoundException {
		if (!ObjectUtils.isEmpty(templateEngine)){
			System.out.println("templateEngine初始化成功");
			Map<String, Object> maps = Maps.newHashMap();
			maps.put("message", "thymeleaf模板测试");
			Context context = new Context(Locale.SIMPLIFIED_CHINESE, maps);
			Writer writer = new StringWriter();
			templateEngine.process("registerForm", context,writer);
			System.out.println(writer.toString());
		}
		if (!ObjectUtils.isEmpty(viewResolver)){
			System.out.println("viewResolver初始化成功");
		}
		if (!ObjectUtils.isEmpty(templateResolver)){
			System.out.println("templateResolver初始化成功");
		}
	}

}
