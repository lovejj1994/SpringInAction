package spring.ioc03;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pan {
	private List<Instruments> instrumentsList;
	private Map<String, Instruments> instrumentsMap;
	private Set<Instruments> instrumentsSet;

	public void performance() {
		
		System.out.print("list我会 ");
		for (Instruments instrument : instrumentsList)
			instrument.play();
		System.out.println();
		
		System.out.print("map我会 ");
		for (Instruments instrument : instrumentsMap.values())
			instrument.play();
		System.out.println();
		
		
		System.out.print("set我会 ");
		for (Instruments instrument : instrumentsSet)
			instrument.play();
	}

	public List<Instruments> getInstrumentsList() {
		return instrumentsList;
	}

	public void setInstrumentsList(List<Instruments> instrumentsList) {
		this.instrumentsList = instrumentsList;
	}

	public Map<String, Instruments> getInstrumentsMap() {
		return instrumentsMap;
	}

	public void setInstrumentsMap(Map<String, Instruments> instrumentsMap) {
		this.instrumentsMap = instrumentsMap;
	}

	public Set<Instruments> getInstrumentsSet() {
		return instrumentsSet;
	}

	public void setInstrumentsSet(Set<Instruments> instrumentsSet) {
		this.instrumentsSet = instrumentsSet;
	}

}
