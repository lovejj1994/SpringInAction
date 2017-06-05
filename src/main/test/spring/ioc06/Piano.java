package spring.ioc06;


public class Piano implements Instruments {
	
	private String a;
	
	@Override
	public void play() {
		System.out.print("我会 钢琴 ");
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	
}
