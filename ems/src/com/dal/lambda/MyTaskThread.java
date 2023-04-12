package com.dal.lambda;

public class MyTaskThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Task t = new Task();
		t.connect();
	}
}
