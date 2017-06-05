package spring.ioc07;

import org.springframework.stereotype.Component;

@Component
public class Pan {
	
	private String resource;
	
	void show() {
		System.out.println("测试 Spring-test,来自" + resource);
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	
}
