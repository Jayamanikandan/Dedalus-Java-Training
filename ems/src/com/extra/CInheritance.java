package com.extra;

import java.io.Serializable;

public class CInheritance {
	public static void main(String[] args) {
		Employee oEmp = new Employee(101,"Tester-1");
		System.out.println(oEmp.getDetails());
		
		Manager oMgr = new Manager(102,"Tester-2","Dev");
		System.out.println(oMgr.getDetails());
	}
}

class Employee
{
	private int ID;
	private String Name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int _ID, String _Name) {
		this.ID = _ID;
		this.Name = _Name;
	}
	
	public String getDetails()
	{
		return "Emp ID: " + this.ID + ", Name: " + this.Name;
	}
}

class Manager extends Employee
{
	String Dept;
	public Manager()
	{
		super();
		this.Dept="Dev";
	}
	
	public Manager(int _id, String _name, String _dept)
	{
		super(_id,_name);
		this.Dept=_dept;
	}
	
	public String getDetails()
	{
		return super.getDetails() + ", Dept: " + this.Dept;
	}
}