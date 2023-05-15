package com.mph.props;

import com.mph.props.Employee;

public interface EmployeeDao {
	
	public void insertEmployee(Employee emp);	
	public void showEmployee();
	public void deleteEmployee(int empid);	
	public void updateEmployee(Employee emp);
	public void showEmployee(int id);
}
