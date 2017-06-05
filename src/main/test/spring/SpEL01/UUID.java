package spring.SpEL01;

public class UUID {
	private String uuid;



	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void show() {
		System.out.println("uuid: " + this.uuid);
	}

	public void replace() {
		this.uuid.replace("-", "");
	}
}
