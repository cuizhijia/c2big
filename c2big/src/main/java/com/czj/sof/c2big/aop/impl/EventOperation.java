package com.czj.sof.c2big.aop.impl;

import java.lang.reflect.Method;

public class EventOperation extends AbstractEventOperatio{

	@Override
	public void start(Method method) {
		System.out.println(method.getName()+"   start");
		
	}
	@Override
	public void end(Method method) {
		System.out.println(method.getName()+"   end");
	}

	public EventOperation workerNeight() {
		
		System.out.println( "don't know");
		return this;
		
	}
	
	
	public static void main(String[] args) {
		
		EventOperation eventOperation = new EventOperation() {
			
			public EventOperation workerNeight() {
				System.out.println(" I know l");
				return new EventOperation();
			}
			
		}.workerNeight();
		
		eventOperation.workerNeight();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(" I run");
			}
		}).start();
		
	}
	
	
}
