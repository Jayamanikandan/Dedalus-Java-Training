package com.dal.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;

public class LambdaEg {
	public static void main(String[] args) {
		//Java 7 - Syntax 1 (Without Thread)
		Task t = new Task();
		t.connect();

		//Java 7 - Syntax 2
		Runnable r = new MyTaskThread();
		Thread _thread = new Thread(r);
		_thread.start();
		
		//Java 7 - Syntax 3
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Task t = new Task();
				t.connect();
			}
		};
		Thread t1 = new Thread(r2);
		t1.start();
		
		//Java 8 - Syntax 1		
		Runnable r3 = () -> {
			Task t3 = new Task();
			t3.connect();
		};
		Thread t2 = new Thread(r2);
		t2.start();	
		
		//Java 8 - Syntax 2
		Thread th3 = new Thread(() ->{
			Task t4 = new Task();
			t4.connect();
		});		
		th3.start();
		
		//Java 8 - Syntax 3
		new Thread(() ->{
			new Task().connect();
		}).start();	
		
		//Java 8 - Syntax 4
		//new Thread(new Task()::connect).start();
		
		//Iterator - Syntax 1
		User u1 = new User(11, "user1", "user1@hotmail.com");
		User u2 = new User(12, "user2", "user2@yahoo.com");
		User u3 = new User(13, "user3", "user3@gmail.com");
		
		List<User> li1 = new ArrayList<>();
		li1.add(u1);
		li1.add(u2);
		li1.add(u3);
		Iterator<User> it1 = li1.iterator();
		/*
		while(it1.hasNext())
		{
			System.out.println(it1.next());
		}
		*/
		
		//Iterator - Syntax 2
		li1.forEach(itm->System.out.println(itm));
		
		//Iterator - Syntax 3
		li1.forEach(System.out::println);
		
		//BiPredicate - ex1
		BiPredicate<String,String> bp3 = (un,pwd)->{return un.equals(pwd);};
		System.out.println("bp3.test(\"sriraam\", \"sriraam\"): "+ bp3.test("sriraam", "sriraam"));
		
		if(bp3.test("adhithya", "adhithya"))
		{
			System.out.println("Welcome Adhithya!");
		}
		else
		{
			System.out.println("Welcome Guest!!");
		}
		
		//BiPredicate - ex2
		BiPredicate<Integer,Integer> bp1 = (x,y)->{return x>y;};
		BiPredicate<Integer,Integer> bp2 = (x,y)->{return x==y;};
		
		System.out.println("bp1.or(bp2).test(101,101): "+bp1.or(bp2).test(101,101));
		
	}
}
