package com.extra;

//functional interface - should have only one method declaration.
interface Addition
{
	public int add(int no1,int no2);
}

public class LambdaExp {
	public static void main(String[] args)
	{
		Addition sum = (int a, int b)->{
			return a+b;
		};
		System.out.println(sum.add(10,20));
	}
}
