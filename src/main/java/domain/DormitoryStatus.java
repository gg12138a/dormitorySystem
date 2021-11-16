package domain;

public class DormitoryStatus {
	private String location;
	private int peopleCounts;
	
	public DormitoryStatus() {}
	
	public DormitoryStatus(String location, int peopleCounts) {
		super();
		this.location = location;
		this.peopleCounts = peopleCounts;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPeopleCounts() {
		return peopleCounts;
	}
	public void setPeopleCounts(int peopleCounts) {
		this.peopleCounts = peopleCounts;
	}

	@Override
	public String toString() {
		return "DormitoryStatus [location=" + location + ", peopleCounts=" + peopleCounts + "]";
	}
	

}
