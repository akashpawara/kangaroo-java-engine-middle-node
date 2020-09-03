package repository;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.StudentAttendance;

public class StudentAttendanceRepository extends DatabaseHelper {
	String table = "institute_student_attendance";
	Statement stmnt = null;

	public StudentAttendanceRepository() throws Exception {
		super("institute-nr01");
		this.stmnt = this.connection.createStatement();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getRows(List<String> hashes) {
		try {
			List<StudentAttendance> listOfResults = new ArrayList<StudentAttendance>();
			hashes.forEach((var) -> {
				listOfResults.add(getRow(var));
			});

			return listOfResults;
		} catch (Exception e) {
			return null;
		}
	}

	public StudentAttendance getRow(String hash) {
		try {
			System.out.println(this.table);
			String sql = "select * from " + this.table + " where hash='" + hash + "'";
			ResultSet rs = stmnt.executeQuery(sql);
			rs.next();
//			System.out.println(rs.getString(1));
//			System.out.println(rs.getString("studentName"));
			return new StudentAttendance(rs.getString("studentName"), rs.getString("standard"),
					rs.getString("division"), rs.getString("sID"), rs.getString("sTimeStamp"), rs.getString("classID"),
					rs.getString("hash"), rs.getBoolean("sIsPresent"));
//			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insertRowsFromHashFile(File file) {
		try {
			Scanner scanner = new Scanner(file);
			String sql = "";
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] arrOfStr = data.split("!");
				sql += "insert into " + this.table
						+ " (`sIsPresent`, `sID`, `studentName`, `sTimeStamp`, `classID`, `division`, `standard`, `hash`)"
						+ "values ('" + arrOfStr[0] + "', '" + arrOfStr[1] + "', '" + arrOfStr[2] + "', '" + arrOfStr[3]
						+ "', '" + arrOfStr[4] + "', '" + arrOfStr[5] + "', '" + arrOfStr[6] + "', '" + arrOfStr[7]
						+ "')\n";
			}
			scanner.close();
			stmnt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws Exception{
		StudentAttendanceRepository sar = new StudentAttendanceRepository();
//		System.out.println("here");
		System.out.println(sar.getRow("e319dec2-2fec-43ea-aa55-8134251ba532").getLog());
		sar.closeConnection();
	}

}
