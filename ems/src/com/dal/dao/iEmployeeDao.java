package com.dal.dao;

import com.dal.model.Employee;

public interface iEmployeeDao {
	public void insertEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int empid);
	public void showEmployee();
}
