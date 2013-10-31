package nl.plaatsmarkt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAO {
	private Connection conn;
	private Statement stmt;
	
	public void open() {
		try {
			if(this.conn==null || !this.conn.isValid(0)){
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				this.conn = DriverManager.getConnection("jdbc:oracle:thin:@145.89.21.30:8521:cursus01","stud1632540", "stud1632540");
			}
		} 
		catch (SQLException e) { e.printStackTrace(); }
	}

	public void close() {
		try {
			if(this.conn!=null && this.conn.isValid(0))
				this.getCon().close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	public Connection getCon(){
		return conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
	public void createStmt(){
		try {
			stmt = this.getCon().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeStmt(){
		try {
			this.getStmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getRows(String TableName){
		int I = 0;
		try {
			this.open();
			this.createStmt();
			String query = "SELECT COUNT(*) AS count FROM " + TableName;
			PreparedStatement counter = conn.prepareStatement(query);
			ResultSet res = counter.executeQuery();
			res.next();
			I = res.getInt("count");
			
			counter.close();
			this.closeStmt();
			this.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return I;
	}

}
