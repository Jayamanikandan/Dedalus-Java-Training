package com.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
	public static void main(String[] args)
	{
		//Generics
		List<Object> l1 = new ArrayList<Object>();
		addNumToList(l1);
		List<Number> l2 = new ArrayList<Number>();
		addNumToList(l2);
		
		List<Integer> a = Arrays.asList(1,2,3);
		sumAllNum(a);
		
		List<Double> b = Arrays.asList(1.1,2.2,3.3);
		sumAllNum(a);
	}
	
	static void addNumToList(List<? super Integer> lst)
	{
		for(int i=0;i<10;i++)
		{
			lst.add(i);
		}
		System.out.println(lst);
	}
	
	static void sumAllNum(List<? extends Number> lstNum)
	{
		double _result=0;
		for(Number n:lstNum)
		{
			_result+=n.doubleValue();
		}
		System.out.println(_result);			
	}
}
