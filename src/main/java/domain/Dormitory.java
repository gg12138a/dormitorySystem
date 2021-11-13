package domain;

import java.math.BigDecimal;

public class Dormitory {
	private String location;
	private Integer num;
	private BigDecimal charge;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public BigDecimal getCharge() {
		return charge;
	}
	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}
	
	public Dormitory() {};
	public Dormitory(String location, Integer num, BigDecimal charge) {
		super();
		this.location = location;
		this.num = num;
		this.charge = charge;
	}
	
	@Override
	public String toString() {
		return "Dormitory [location=" + location + ", num=" + num + ", charge=" + charge + "]";
	}
	
	
}
