package spring.springmvc02.test;

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

import spring.springmvc02.controller.HomeController;
import spring.springmvc02.entity.Home;
import spring.springmvc02.repository.HomeRepository;

public class HomeControllerTest {
	@Test
	//测试url传入参数
	public void test() throws Exception {
		List<Home> homes = createHomes();
		HomeRepository homeRepository = Mockito.mock(HomeRepository.class);
		//添加预期 调用findHomes(new Long(23900), 20)会返回lists：homes
		Mockito.when(homeRepository.findHomes(new Long(23900), 20)).thenReturn(homes);
		
		HomeController home = new HomeController(homeRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(home)
				.setSingleView(new InternalResourceView("/WEB-INF/views/home.html"))
				.build();
		//mockMvc.perform如果传入的值不是预期，或者HomeController方法写的有问题，就会报错
		mockMvc.perform(MockMvcRequestBuilders.get("/?max=23900&&count=20"))
				//andExpect增加断言期待的值，如果不是这个值，就会报错
				.andExpect(MockMvcResultMatchers.view().name("home"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("homesList"))
				.andExpect(MockMvcResultMatchers.model().attribute("homesList",CoreMatchers.hasItems(homes.toArray())));
		
		//assertThat  第一项填写 对象，第二项填写"规则",比如 CoreMatchers.hasItems表示assertThat第一项中有包含第二项的内容，有true，没有报错
		Assert.assertThat(Arrays.asList("foo", "bar", "baz"), CoreMatchers.hasItems("baz", "foo"));
	}
	
	
	@Test
	//测试{id}传入参数
	public void test2() throws Exception {
		Home home = new Home(new Date(), "hello");
		HomeRepository homeRepository = Mockito.mock(HomeRepository.class);
		//添加预期 调用findHomes(new Long(23900), 20)会返回lists：homes
		Mockito.when(homeRepository.findOne(new Long(12345))).thenReturn(home);
		
		HomeController homeController = new HomeController(homeRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/home.html"))
				.build();
		//mockMvc.perform如果传入的值不是预期，或者HomeController方法写的有问题，就会报错
		mockMvc.perform(MockMvcRequestBuilders.get("/12345"))
				//andExpect增加断言期待的值，如果不是这个值，就会报错
				.andExpect(MockMvcResultMatchers.view().name("home"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("home"))
				.andExpect(MockMvcResultMatchers.model().attribute("home",home));
	}

	public List<Home> createHomes() {
		List<Home> homes = Lists.newArrayList();

		for (int i = 0; i < 1; i++) {
			homes.add(new Home(new Date(), String.valueOf(i)));
		}
		return homes;
	}

}
