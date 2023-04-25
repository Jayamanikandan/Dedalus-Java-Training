package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.dal.helper.MyDBConnection;
import com.dal.model.Employee;

public class EmployeeDao implements iEmployeeDao {

	@Override
	public void insertEmployee(Employee emp) {
		try {
			Connection con = MyDBConnection.GetConnection();
			PreparedStatement ps= con.prepareStatement("insert into EMPLOYEE values(?,?)");
			
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			
			int noOfRowsAffected = ps.executeUpdate();
			System.out.println(noOfRowsAffected + " row has been inserted!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			Connection con = MyDBConnection.GetConnection();
			PreparedStatement ps= con.prepareStatement("update EMPLOYEE set name=? where id=?");
			
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getEid());
			
			int noOfRowsAffected = ps.executeUpdate();
			System.out.println(noOfRowsAffected + " row has been Updated!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		try {
			Connection con = MyDBConnection.GetConnection();
			PreparedStatement ps= con.prepareStatement("delete EMPLOYEE where id="+empid);
						
			//ps.setInt(1, empid);
			
			int noOfRowsAffected = ps.executeUpdate();
			System.out.println(noOfRowsAffected + " row has been Deleted!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void showEmployee() {
		try {
			Connection con = MyDBConnection.GetConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from EMPLOYEE");
			while(rs.next())
			{
				System.out.println("Employee ID: "+rs.getInt(1) + " -- Name: "+rs.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

}
