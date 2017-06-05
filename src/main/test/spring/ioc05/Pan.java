package spring.ioc05;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Pan {
	
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
