package spring.springmvc01.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * spring通用配置文件
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SpringConfig.class };
	}

	/**
	 * 主要是springmvc的配置文件
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { SpringMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" }; // 将DispatcherServlet(springmvc所有的请求都会通过DispatcherServlet分发到具体的controller)映射到“/”
	}

}
