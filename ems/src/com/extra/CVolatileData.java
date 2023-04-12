package com.extra;

public class CVolatileData {
	private volatile int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void increaseCounter() {
		++counter;
	}
}
