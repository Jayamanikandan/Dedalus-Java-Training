package com.dal.lambda;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncEg {
	public static void main(String[] args)
	{		
		chainOfCallbackMethods();		
	}
	
	private static void chainOfCallbackMethods()
	{
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			try
			{
				TimeUnit.SECONDS.sleep(1);				
			}
			catch(InterruptedException ex)
			{
				throw new IllegalStateException();
			}
			return "Deeps";
		}				
		).thenApply(value -> "Hello from "+value + "!!!")
		.thenApply(msg -> msg + ", Deeps welcomes you all")
		.thenAccept(System.out::println);
	}
}
