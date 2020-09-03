package repository;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.TeacherAttendance;

public class TeacherAttendanceRepository extends DatabaseHelper {
	String table = "institute_teacher_details";
	Statement stmnt = null;

	public TeacherAttendanceRepository() throws Exception {
		super("institute-nr01");
		stmnt = this.connection.createStatement();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getRows(List<String> hashes) {
		try {
			List<TeacherAttendance> listOfResults = new ArrayList<TeacherAttendance>();
			hashes.forEach((var) -> {
				listOfResults.add(getRow(var));
			});

			return listOfResults;
		} catch (Exception e) {
			return null;
		}
	}

	public TeacherAttendance getRow(String hash) {
		try {
			String sql = "select * from " + this.database + " where ( hash=" + hash + ");";
			ResultSet rs = stmnt.executeQuery(sql);

			return new TeacherAttendance(rs.getBoolean("tIsPresent"), rs.getString("teacherName"),
					rs.getString("tTimeStamp"), rs.getString("tID"), rs.getString("hash"));
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
				sql += "insert into " + this.table + " (`tTimeStamp`, `tIsPresent`, `teacherName`, `tID`, `hash`)"
						+ "values ('" + arrOfStr[0] + "', '" + arrOfStr[1] + "', '" + arrOfStr[2] + "', '" + arrOfStr[3]
						+ "', '" + arrOfStr[4] + "')\n";
			}
			scanner.close();
			stmnt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
