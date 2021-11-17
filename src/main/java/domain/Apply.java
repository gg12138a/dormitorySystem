package domain;

public class Apply {
	private int aid;
	private String uid;
	private String fromLoc;
	private String toLoc;
	private boolean reviewed;
	private boolean passed;
	private String generateTime;
	private String reviewedTime;
	private String username;
	
	
	public Apply() {}
	
	
	public Apply(int aid, String uid, String fromLoc, String toLoc, boolean reviewed, boolean passed,
			String generateTime, String reviewedTime) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.fromLoc = fromLoc;
		this.toLoc = toLoc;
		this.reviewed = reviewed;
		this.passed = passed;
		this.generateTime = generateTime;
		this.reviewedTime = reviewedTime;
	}

	

	public Apply(int aid, String uid, String fromLoc, String toLoc, boolean reviewed, boolean passed,
			String generateTime, String reviewedTime, String username) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.fromLoc = fromLoc;
		this.toLoc = toLoc;
		this.reviewed = reviewed;
		this.passed = passed;
		this.generateTime = generateTime;
		this.reviewedTime = reviewedTime;
		this.username = username;
	}


	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFromLoc() {
		return fromLoc;
	}
	public void setFromLoc(String formLoc) {
		this.fromLoc = formLoc;
	}
	public String getToLoc() {
		return toLoc;
	}
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	public boolean isReviewed() {
		return reviewed;
	}
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
	public String getReviewedTime() {
		return reviewedTime;
	}
	public void setReviewedTime(String reviewedTime) {
		this.reviewedTime = reviewedTime;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "Apply [aid=" + aid + ", uid=" + uid + ", fromLoc=" + fromLoc + ", toLoc=" + toLoc + ", reviewed="
				+ reviewed + ", passed=" + passed + ", generateTime=" + generateTime + ", reviewedTime=" + reviewedTime
				+ ", username=" + username + "]";
	}
	

	
	
}
