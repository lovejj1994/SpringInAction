package spring.springmvc02.repository;

import java.util.List;

import spring.springmvc02.entity.Home;

public interface HomeRepository {
	List<Home> findHomes(Long max,int count);
	
	Home findOne(Long max);
}
