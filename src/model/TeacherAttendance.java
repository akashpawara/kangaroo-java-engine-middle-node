package model;

public class TeacherAttendance {
	boolean tIsPresent;
	String teacherName, tTimeStamp, tID, hash;

	public TeacherAttendance(boolean tIsPresent, String teacherName, String tTimeStamp, String tID, String hash) {
		super();
		this.tIsPresent = tIsPresent;
		this.teacherName = teacherName;
		this.tTimeStamp = tTimeStamp;
		this.tID = tID;
		this.hash = hash;
	}

	public String getLog() {
		return tTimeStamp + "!" + Boolean.toString(tIsPresent) + "!" + teacherName + "!" + tID + "!" + hash;
	}

	public boolean istIsPresent() {
		return tIsPresent;
	}

	public void settIsPresent(boolean tIsPresent) {
		this.tIsPresent = tIsPresent;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String gettTimeStamp() {
		return tTimeStamp;
	}

	public void settTimeStamp(String tTimeStamp) {
		this.tTimeStamp = tTimeStamp;
	}

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
		this.tID = tID;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "TeacherAttendance [tIsPresent=" + tIsPresent + ", teacherName=" + teacherName + ", tTimeStamp="
				+ tTimeStamp + ", tID=" + tID + ", hash=" + hash + "]";
	}
}
