package com.extra;

public class CVolatileMain {
	private final static int noOfThreads = 2;

	public static void main(String[] args) throws InterruptedException {
		CVolatileData _volatileData = new CVolatileData();
		Thread[] threads = new Thread[noOfThreads];
		for (int i = 0; i < noOfThreads; ++i)
			threads[i] = new CVolatileThread(_volatileData);
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].start();
		for (int i = 0; i < noOfThreads; ++i)
			threads[i].join();
	}
}
