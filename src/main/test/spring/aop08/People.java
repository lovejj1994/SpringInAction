package spring.aop08;

public class People implements Man{
	
	public People() {
	}

	@Override
	public void eat(String food) {
		System.out.println("该吃" + food + "了...");
	}

	
	
}
