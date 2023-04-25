package com.dal.model;

import java.io.Serializable;

public class Employee implements Serializable{
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}

	private int eid;
	private String ename;
	
	public int getEid()
	{
		return this.eid;
	}
	
	public void setEid(int _eid)
	{
		this.eid = _eid;
	}
	
	public String getEname()
	{
		return this.ename;
	}
	
	public void setEname(String _ename) {
		this.ename = _ename;
	}
	
	public Employee()
	{
		System.out.println("From default constructor!!");
	}
	
	public Employee(int _id)
	{
		this("Hello... ");
		this.eid = _id;
		System.out.println("From the constructor Employee(id)!");
	}
	
	public Employee(String _name)
	{
		this.ename = "Hello";
		System.out.println("From the constructor Employee(name)!");
	}
	public Employee(int _id, String _name)
	{
		this.eid = _id;
		this.ename = _name;
	}
	
}
