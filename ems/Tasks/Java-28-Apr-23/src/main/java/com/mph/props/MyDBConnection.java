package com.mph.props;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import oracle.jdbc.driver.OracleDriver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.dal.model.Employee;

public class MyDBConnection {

	
	    public static void main(String args[])
	    {
	        
	    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dbconn.xml");	      	        
	        myDBconEg je = (myDBconEg) applicationContext.getBean("jdbc");
	        je.connect();
	        /*to try using input
	       // Employee emp;
//	        List<Employee> emplist = new ArrayList<Employee>();
//	        Scanner sc = new Scanner(System.in);
//			String Choice = null;
//			InputStreamReader isr = new InputStreamReader(System.in);
//			BufferedReader bsr = new BufferedReader(isr);
//			do {
//				System.out.println("enter your choice");
//				System.out.println(("1. Add Employee"));
//				System.out.println(("2. View Employee"));
//				myDBconEg econtol = new myDBconEg();
//				int ch = sc.nextInt();
//				switch (ch) {
//				case 1: {
//					emp = new Employee();
//					//Scanner sc = new Scanner(System.in);
//					System.out.println("Enter Eid");
//					int eid= sc.nextInt();
//					emp.setEid(eid);
//					
//					System.out.println("Enter Ename");
//					String ename= sc.next();
//					emp.setEname(ename);
//					emplist.add(emp);
//					econtol.insertEmployee(emp);
//					break;
//				}
//
//				case 2: {
//					econtol.showEmployee();
//					break;
//				}
//			
//				default: {
//					System.out.println(("enter your choice"));
//					break;
//				}
//				
//				}
//				System.out.println("Do u wanna continue? Y or n");
//				Choice = sc.next();
//
//			} while (Choice.equals("Y") || Choice.equals("y"));
//			System.out.println("Exited");
//			System.exit(0);*/
	    }
	}
	

