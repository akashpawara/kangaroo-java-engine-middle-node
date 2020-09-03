package model;

public class StudentAttendance {
	String studentName, standard, division, sID, timeStamp, classID, hash;
	boolean isPresent;

	public StudentAttendance(String studentName, String standard, String division, String sID, String timeStamp,
			String classID, String hash, boolean isPresent) {
		super();
		this.studentName = studentName;
		this.standard = standard;
		this.division = division;
		this.sID = sID;
		this.timeStamp = timeStamp;
		this.classID = classID;
		this.hash = hash;
		this.isPresent = isPresent;
	}

	@Override
	public String toString() {
		return "StudentAttendance [studentName=" + studentName + ", standard=" + standard + ", division=" + division
				+ ", sID=" + sID + ", timeStamp=" + timeStamp + ", classID=" + classID + ", hash=" + hash
				+ ", isPresent=" + isPresent + "]";
	}

	public String getLog() {
		return Boolean.toString(isPresent) + "!" + this.sID + "!" + this.studentName + "!" + this.timeStamp + "!"
				+ this.classID + "!" + this.division + "!" + this.standard + "!" + this.hash;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

}
