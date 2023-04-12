package com.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.dal.controller.EmployeeController;
import com.dal.helper.MyDBConnection;
import com.dal.model.Employee;

public class MainClass {
	String name="scott";

	public static void main(String[] args) {
		//Employee obj = new Employee(101);
		ex5();
	}
	
	private static void ex1()
	{
		// all local variable should be initialized;
		int x = 100;
		int y; // it would throw exception while accessing
		System.out.println("welcome");
		System.out.println(x);
		// System.out.println(y);
		
		MainClass obj = new MainClass();
		System.out.println(obj.name);
	}
	
	private static void ex2()
	{
		Employee oEmp = new Employee();
		oEmp.setEid(101);
		oEmp.setEname("Scott");
		System.out.println("Employee ID is: "+oEmp.getEid());
		System.out.println("Employee Name is: "+oEmp.getEname());
	}
	
	private static void ex3()
	{
		Employee ex = new Employee();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Eid");
		ex.setEid(sc.nextInt());
		System.out.println("Enter Ename");
		ex.setEname(sc.next());
		System.out.println("Employee ID is: "+ex.getEid());
		System.out.println("Employee Name is: "+ex.getEname());
		
		//would return "com.dal.model.Employee@31cefde0" toString() in a class
		System.out.println(ex);
		
		sc.close();
	}
	
	private static void ex4()
	{
		EmployeeController ec = new EmployeeController();
		ec.AddEmployee();
		ec.ViewEmployee();
	}
	
	private static void ex5()
	{
		try {
			EmployeeController ec = new EmployeeController();
			Scanner _sc = new Scanner(System.in);
			String choice = "Y";
			do {
				System.out.println("1.Add employee");
				System.out.println("2.View employee");
				System.out.println("3.Serialize emp list");
				System.out.println("4.Deserialize emp list");
				int ch = _sc.nextInt();
				switch (ch) {
				case 1:
					ec.AddEmployee();
					break;
				case 2:
					ec.ViewEmployee();
					break;
				case 3:
					ec.SerializeEmpList();
					break;
				case 4:
					ec.DeserializeEmpList();
					break;
				default:
					System.out.println("Please enter a valid choice (1/2)");
					break;
				}
				System.out.println("Do you want to continue?");
				choice = _sc.next();
			} while (choice.equals("y") || choice.equals("Y"));
		} catch (Exception ex) {
		}
	}
	
	private static void ex6()
	{
		//Set list = new ArrayList();
		Set list = new HashSet();
		list.add(101);
		list.add("Tester-1");
		list.add("Tester-2");
		list.add("Tester-3");
		System.out.println(list);
		
		Map map = new HashMap();
		map.put(2, "Orange");
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(null, "Grapes");
		map.put(3, "Mango");
		System.out.println(map);
	}	
	
	private static void db1()
	{
		try
		{
		Connection con = MyDBConnection.GetConnection();
		System.out.println(con.isValid(100));
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
