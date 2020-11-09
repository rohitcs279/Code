package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;

public class ConnectionDao<LoanCategories> {
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	public  Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	
	public   List<LoanInfo> getAllLoans() throws SQLException{
		this.connect();
		String strSql = "select * from LoanCategories";
		
		Statement stmt = this.connect().createStatement();
		ResultSet rs = stmt.executeQuery(strSql);
		
		List<LoanInfo> loaninfo =  new ArrayList<LoanInfo>();
		while (rs.next())
		{
			LoanInfo loan = new LoanInfo(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			loaninfo.add(loan);
		}
		rs.close();
		stmt.close();
		this.disconnect();
		return loaninfo;
				
	}
	
	public   List<User> getUsers() throws SQLException{
		this.connect();
		String strSql = "select * from Users where uname=? and pswd=?";
		
		Statement stmt = this.connect().createStatement();
		ResultSet rs = stmt.executeQuery(strSql);
		
		List<User> users =  new ArrayList<User>();
		while (rs.next())
		{
			//LoanInfo loan = new LoanInfo(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			User user = new User(rs.getString("uname"),rs.getString("pswd"));
			users.add(user);
		}
		rs.close();
		stmt.close();
		this.disconnect();
		return users;
				
	}
	
	public boolean check(String strUser,String strPswd)
	{
		
		
		return false;
	}
	
	public   List<ApprovedLoan> getApprvdLoan() throws SQLException{
		this.connect();
		String strSql = "select * from ApprovedLoan";
		
		Statement stmt = this.connect().createStatement();
		ResultSet rs = stmt.executeQuery(strSql);
		
		List<ApprovedLoan> appdloan =  new ArrayList<ApprovedLoan>();
		while (rs.next())
		{
			ApprovedLoan apdloan = new ApprovedLoan(rs.getString("AmtSanctioned"),rs.getInt("AppInfo"),rs.getInt("Emi"),rs.getString("Lcd"),rs.getString("LoanStmt"),rs.getInt("Psd"));
			
			appdloan.add(apdloan);
		}
		rs.close();
		stmt.close();
		this.disconnect();
		return appdloan;
				
	}
	
}
	
	// put the relevant DAO methods here..
	/*public int registerUser(User user,HttpServlet request,HttpServlet response) throws ClassNotFoundException
	{
		String INSERT_USER_SQL =  "INSERT INTO User"+"(email_id, name, password, mobile_no, address, pan_no, adhar_no, gender, dob) values (?,?,?,?,?,?,?,?,?)";
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try {Connection connect = DriverManager.getConnection("jdbc:mysql://localhost::3306/mysql_database?useSSL=false","root","root");
		
				PreparedStatement ps = connect.prepareStatement(INSERT_USER_SQL);
                ps.setString(1, emailId);
                ps.setString(2, name);
                ps.setString(3, password);
                ps.setString(4, mobileno);
                ps.setString(5, address);
                ps.setString(6, panno);
                ps.setString(7, adharno);
                ps.setString(8, gender);
                ps.setDate(9, dob);		
				
				
	)
		return 0;
		
	}catch (SQLException e) {
        System.out.println(e.getMessage());
       
    }
}*/
