package spring.SpEL01;

public class NewUUID {

	private String newUuid;

	public String getNewUuid() {
		return newUuid;
	}

	public void setNewUuid(String newUuid) {
		this.newUuid = newUuid;
	}


	public void show() {
		System.out.println("newUuid:" + this.newUuid);
	}

	public void replace() {
		this.newUuid.replace("-", "");
	}
}
