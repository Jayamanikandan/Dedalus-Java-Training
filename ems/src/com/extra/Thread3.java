package com.extra;

public class Thread3  {
	public static void main(String[] args)
	{
		System.out.println("main fn started");
		ThreadEg1 objThread = new ThreadEg1();
		objThread.start();
		System.out.println("main fn ended");
	}
}

class ThreadEg1 extends Thread
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
