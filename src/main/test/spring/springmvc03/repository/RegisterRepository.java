package spring.springmvc03.repository;

import spring.springmvc03.entity.Home;

public interface RegisterRepository {

	Home save(Home home);

	Home findHomeByUserName(String username);
}
