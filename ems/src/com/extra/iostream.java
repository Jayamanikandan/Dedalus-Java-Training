package com.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iostream {
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bsr = new BufferedReader(isr);
		
		try {
			int x=0,y=0,z=0;
			System.out.println("Enter X: ");
			x = Integer.parseInt(bsr.readLine());
			System.out.println("Enter Y: ");
			y = Integer.parseInt(bsr.readLine());
			z=x+y;
			System.out.println("Z: "+ z);
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Number format exception! Please enter valid number.");
		}
		catch(Exception ex)
		{
			System.out.println("Generic exception!");
			ex.printStackTrace();
		}
		finally
		{
			System.out.println("Executing finally.");
			bsr.close();
			isr.close();			
		}
	}
}
