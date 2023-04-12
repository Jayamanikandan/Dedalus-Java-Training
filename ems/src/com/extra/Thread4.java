package com.extra;

public class Thread4{
	public static void main(String[] args)
	{
		System.out.println("main fn started");
		ThreadEg2 objRunnable = new ThreadEg2();
		Thread th2 = new Thread(objRunnable);		
		th2.start();
		System.out.println("main fn ended");
	}
}

class ThreadEg2 implements Runnable
{
	public void run() {
		System.out.println("Method started");
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("i=" + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Method ended");
	} 
}
