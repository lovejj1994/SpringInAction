package spring.ioc05;

import org.springframework.beans.factory.annotation.Qualifier;

public class Piano implements Instruments {
	
	private String a;
	
	@Override
	public void play() {
		System.out.print("钢琴 ");
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	
}
