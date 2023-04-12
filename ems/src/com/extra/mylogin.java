package com.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.exception.UserNotFoundException;

public class mylogin{
	public static void main(String[] args) throws IOException
	{
		try
		{
			String uname = null;
			String pwd = null;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter user name: ");
			uname = br.readLine();
			System.out.println("Enter password: ");
			pwd = br.readLine();
			
			if(uname.equals("scott") && pwd.equals("tiger"))
			{
				System.out.println("Authentication successful! Welcome Scott!!");
			}
			else
			{
				throw new UserNotFoundException();
			}
		}
		catch(UserNotFoundException ex)
		{
			System.out.println("UserNotFoundException occurred!!");
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Exception occurred!!");
			ex.printStackTrace();
		}
		finally
		{
			System.out.println("Executing finally");
		}
	}
}
