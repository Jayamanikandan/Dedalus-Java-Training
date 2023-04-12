package com.dal.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.dal.EmployeeInterface;
import com.dal.dao.EmployeeDao;
import com.dal.model.Employee;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	ArrayList<Employee> oCol = new ArrayList<Employee>();
	
	public void AddEmployee() {
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Eid");
		emp.setEid(sc.nextInt());
		System.out.println("Enter Ename");
		emp.setEname(sc.next());
		
		oCol.add(emp);
		
		//JDBC code
		EmployeeDao _dao = new EmployeeDao();
		_dao.insertEmployee(emp);
	}
	
	public void ViewEmployee() {		
		//System.out.println(oCol);
		/*
		Iterator<Employee> i=oCol.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		*/
		//oCol.forEach(itm->System.out.println(itm));
		//
		//oCol.forEach(System.out::println);
		//JDBC code
		EmployeeDao _dao = new EmployeeDao();
		_dao.showEmployee();
	}
	
	public void SerializeEmpList() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("emplist.txt");
		ObjectOutputStream oi = new ObjectOutputStream(fos);		
		
		oi.writeObject(oCol);
		
		System.out.println("Emp list serialised to file ");
		oi.close();
		fos.close();
	}
	
	public void DeserializeEmpList() throws IOException
	{
		try
		{
			FileInputStream fis = new FileInputStream("emplist.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ArrayList<Employee> empList = (ArrayList<Employee>)ois.readObject();
					
			System.out.println("Emp deserialised from file ");
			System.out.println(empList);		
			
			ois.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
