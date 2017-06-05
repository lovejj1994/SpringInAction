package spring.ioc04;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;

public class Pan {
	//默认@Autowired是必须有装配对象的，没有的话会报错，如果想远离失败，null也可以接受的话，可以设定required=false
	@Autowired(required=false)
	//根据xml中的bean ID查找，缩小自动装配的范围
	@Qualifier("piano")
	private Instruments instrument;

	public void performance() {

		System.out.print("我会 ");
		instrument.play();

	}

	public Instruments getInstrument() {
		return instrument;
	}

	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}

}
