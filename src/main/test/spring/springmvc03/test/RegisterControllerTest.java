package spring.springmvc03.test;


import static org.mockito.Mockito.atLeastOnce;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.google.common.collect.Lists;

import spring.springmvc03.entity.Home;
import spring.springmvc03.repository.RegisterRepository;
import spring.springmvc03.controller.RegisterController;

public class RegisterControllerTest {

	@Test
	/**
	 * 测试表单提交
	 * @throws Exception
	 */
	public void test() throws Exception {
		
		Home unsave = new Home("pan","qian","lovejj1994","123456");
		Home save = new Home("1","pan","qian","lovejj1994","123456");
		
		RegisterRepository registerRepository = Mockito.mock(RegisterRepository.class);
		//设置方法调用的返回值（设置模拟数据）
		Mockito.when(registerRepository.save(unsave)).thenReturn(save);
		
		RegisterController registerController = new RegisterController(registerRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(registerController)
				.build();
		//测试get请求
		mockMvc.perform(MockMvcRequestBuilders.get("/register"))
				//andExpect增加断言期待的值，如果不是这个值，就会报错
				.andExpect(MockMvcResultMatchers.view().name("registerForm"));
		
		//测试Post请求
		mockMvc.perform(MockMvcRequestBuilders.post("/register")
				.param("firstName", "pan")
				.param("lastName", "qian")
				.param("userName", "love")
				.param("password", "123456"))
				//andExpect增加断言期待的值，如果不是这个值，就会报错
				.andExpect(MockMvcResultMatchers.redirectedUrl("/lovejj1994"));
		//Mockito曾经做过的交互会全部记录下来，可以用verify()来选择性的核实 这些交互行为
		Mockito.verify(registerRepository,atLeastOnce()).save(unsave);
	}


}
