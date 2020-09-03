package repository;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.StudentMarks;

public class StudentMarksRepository extends DatabaseHelper {
	String table = "institute_student_marks";
	Statement stmnt = null;

	public StudentMarksRepository() throws Exception {
		super("institute-nr01");
		stmnt = this.connection.createStatement();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getRows(List<String> hashes) {
		try {
			List<StudentMarks> listOfResults = new ArrayList<StudentMarks>();
			hashes.forEach((var) -> {
				listOfResults.add(getRow(var));
			});

			return listOfResults;
		} catch (Exception e) {
			return null;
		}
	}

	public StudentMarks getRow(String hash) {
		try {
			String sql = "select * from " + this.database + " where ( hash=" + hash + ");";
			ResultSet rs = stmnt.executeQuery(sql);

			return new StudentMarks(rs.getString("sID"), rs.getString("classID"), rs.getString("hash"),
					rs.getString("english"), rs.getString("maths"), rs.getString("science"),
					rs.getString("studentName"), rs.getString("standard"), rs.getString("division"),
					rs.getString("examType"), rs.getString("term"), rs.getString("year"));

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
						+ " (`sID`, `studentName`, `english`, `maths`, `science`, `examType`, `term`, `year`, `standard`, `division`, `classID`, `hash`)"
						+ "values ('" + arrOfStr[0] + "', '" + arrOfStr[1] + "', '" + arrOfStr[2] + "', '" + arrOfStr[3]
						+ "', '" + arrOfStr[4] + "', '" + arrOfStr[5] + "', '" + arrOfStr[6] + "', '" + arrOfStr[7]
						+ "', '" + arrOfStr[8] + "', '" + arrOfStr[9] + "', '" + arrOfStr[10] + "', '" + arrOfStr[11]
						+ "')\n";
			}
			scanner.close();
			stmnt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
