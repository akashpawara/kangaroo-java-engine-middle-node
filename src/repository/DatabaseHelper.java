package repository;

import java.io.File;
import java.sql.*;
import java.util.List;

public abstract class DatabaseHelper {
	Connection connection = null;
	String database = null;

	public DatabaseHelper(String database) throws Exception {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + "institute-nr01", "root", "");
		this.database = "institute-nr01";
	}

	public void closeConnection() throws Exception {
		this.connection.close();
		this.connection = null;
		this.database = null;
	}

	@SuppressWarnings("rawtypes")
	public abstract List getRows(List<String> hashes);
	
	public abstract void insertRowsFromHashFile(File file);
}
