package com.extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dal.model.Employee;

public class serialize {
	public static void main(String[] args) throws IOException
	{		
		deSerialize1();
	}
	
	public static void serialize1() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("emps.txt");
		ObjectOutputStream oi = new ObjectOutputStream(fos);
		
		Employee emp = new Employee(101,"Tester");
		oi.writeObject(emp);
		
		System.out.println("Emp serialised to file ");
		oi.close();
		fos.close();
	}
	
	public static void deSerialize1() throws IOException
	{
		try
		{
			FileInputStream fis = new FileInputStream("emps.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Employee emp = (Employee)ois.readObject();
					
			System.out.println("Emp deserialised from file ");
			System.out.println("Emp ID: "+emp.getEid());
			System.out.println("Emp Name: "+emp.getEname());
			
			ois.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
