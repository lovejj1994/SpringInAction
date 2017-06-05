package spring.aop04;

public class People2 implements Teacher {

	@Override
	public void teach() {
		System.out.println("我也是个教师");
	}

}
