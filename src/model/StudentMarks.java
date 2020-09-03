package model;

public class StudentMarks {
	String sID, classID, hash, english, maths, science, studentName, standard, division, examType, term, year;

	@Override
	public String toString() {
		return "StudentMarks [sID=" + sID + ", classID=" + classID + ", hash=" + hash + ", english=" + english
				+ ", maths=" + maths + ", science=" + science + ", studentName=" + studentName + ", standard="
				+ standard + ", division=" + division + ", examType=" + examType + ", term=" + term + ", year=" + year
				+ "]";
	}

	public String getLog() {
		return sID + "!" + studentName + "!" + english + "!" + maths + "!" + science + "!" + examType + "!" + term + "!"
				+ year + "!" + standard + "!" + division + "!" + classID + "!" + hash;
	}

	public StudentMarks(String sID, String classID, String hash, String english, String maths, String science,
			String studentName, String standard, String division, String examType, String term, String year) {
		super();
		this.sID = sID;
		this.classID = classID;
		this.hash = hash;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.studentName = studentName;
		this.standard = standard;
		this.division = division;
		this.examType = examType;
		this.term = term;
		this.year = year;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
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

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getMaths() {
		return maths;
	}

	public void setMaths(String maths) {
		this.maths = maths;
	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
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

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
