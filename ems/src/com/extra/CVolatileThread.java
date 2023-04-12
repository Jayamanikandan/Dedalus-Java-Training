package com.extra;

public class CVolatileThread extends Thread{
	private final CVolatileData data;

	public CVolatileThread(CVolatileData data)   
	{  
		this.data = data;
	}

	@Override
	public void run() {
		int oldValue = data.getCounter();
		System.out.println("[Thread " + Thread.currentThread().getId() + "]: Old value = " + oldValue);
		data.increaseCounter();
		int newValue = data.getCounter();
		System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);
	}
}
