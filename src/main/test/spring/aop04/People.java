package spring.aop04;

public class People implements Mother{
	
	public People() {

	}


	@Override
	public void raise() {
		System.out.println("我是一个母亲");
	}

	
	
}
