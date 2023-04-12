package com.extra;

public class SyncThread {
	public static void main(String[] args) {
		System.out.println("main fn started");
		Thread3 objT1 = new Thread3();
		
		Thread objT2_1 = new Thread1(objT1);
		Thread objT2_2 = new Thread2(objT1);
		objT2_1.start();
		objT2_2.start();
		System.out.println("main fn ended");
	}
}

//Try running this code
//- with synchronized
//- without synchronized
class Thread1 {
	public void print1()
	{
		System.out.println("Method started");
		synchronized (this) {

			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("i=" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Method ended");
	}
}

class Thread2 extends Thread
{
	Thread3 t1;
	public Thread2(Thread3 _t1) {
		// TODO Auto-generated constructor stub
		this.t1 = _t1;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		t1.print1();
	}
}