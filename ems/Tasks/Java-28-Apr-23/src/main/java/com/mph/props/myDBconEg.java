package com.mph.props;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dal.helper.MyDBConnection;
import com.dal.model.Employee;

//import com.dal.helper.MyDBConnection;

//import com.dal.helper.MyDBConnection;

public class myDBconEg implements EmployeeDao{

	private  String url;
	private  String username;
	private  String password;
	Connection connection = null;
	//public static Connection connection;
	static PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	public myDBconEg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public myDBconEg(String url, String username, String password) {
		super();
		System.out.println("hi entered myDBconEg");
		this.url = url;
		this.username = username;
		this.password = password;
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public  void connect()
    {
        try
        {
        	Employee emp;
        	System.out.println("hello entered connect");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
				connection = DriverManager.getConnection(url,username,password );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("connected");           
                       
             ps = connection.prepareStatement("select ename from emp");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }
            
           			
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
            return;
        }
    }

	public void insertEmployee(Employee emp) {
		

		try {
		//	con  = MyDBConnection.getDbConnection();
//			System.out.println("Hello i am insert");
//			ps=connection.prepareStatement("insert into emp values(?,?)");
//			
//			ps.setInt(1, emp.getEid());
//			ps.setString(2, emp.getEname());
//			int noofrows = ps.executeUpdate();
//			System.out.println(noofrows  + " got inserted... ");
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
	}
	
	public void showEmployee() {
		try {
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            try {
//				connection = DriverManager.getConnection(url,username,password );
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            System.out.println("connected");
//			stmt= connection.createStatement();
//			rs = stmt.executeQuery("select * from dalemp");
//			while(rs.next()) {
//				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
//				
//			}
//			
//			
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
		
	}
	public void deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		
	}
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}
	public void showEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
