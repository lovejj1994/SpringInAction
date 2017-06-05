package spring.thymeleaf01;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

@Configuration
public class JavaConfig {
	//Thymeleaf视图解析器
	@Bean
	public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	//模板引擎
	@Bean
	public SpringTemplateEngine templateEngine(FileTemplateResolver templateResolver) {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(templateResolver);
		return springTemplateEngine;
	}
	//模板解析器
	@Bean
	public FileTemplateResolver templateResolver() throws IOException {
		FileTemplateResolver templateResolver = new FileTemplateResolver();
		String file = JavaConfig.class.getResource("/thymeleaf01/").getFile();
		//String path = JavaConfig.class.getResource("/WEB-INF/views/thymeleaf01").getPath();
		//Path path = Paths.get("c:", "eclipseMars2","workspace","SpringInAction","src","main","webapp","WEB-INF","views","\\");
		templateResolver.setPrefix(file.substring(1, file.length()).toString());
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		return templateResolver;
	}

}
