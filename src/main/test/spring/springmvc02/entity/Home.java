package spring.springmvc02.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Home {
	
	private Long id;
	private Date time;
	private String message;
	private Double latitude;  //纬度
	private Double longitude; //经度

	
	public Home(Date time, String message) {
		this(time,message,null,null);
	}
	
	
	public Home(Date time, String message, Double latitude, Double longitude) {
		this.id = null;
		this.time = time;
		this.message = message;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","time");
	}


	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "id","time");
	}
	
	
}
