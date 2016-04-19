package cuke;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class Hive {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	private Connection con;
	private ResultSet set;
	
	private void connect() {
		try {
			Class.forName(driverName);
		}
		catch (ClassNotFoundException e) {
			// do nothing for now
		}
		try {
			con = DriverManager.getConnection("jdbc:hive2://130.211.177.225:10000/edw_db_shared_dim", "edw", "123@gcc");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// constructor
	public Hive() {
		connect();
	}
	
	public int RowCount() {
		int count = 0;
		try {
			while (set.next()) {
				 System.out.println(set.getString(1));
				 count++;
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		return count;
	}

	public void executeSQL (String statement){
		Statement sql = null;
		try {
			sql = con.createStatement();
			set = sql.executeQuery(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
