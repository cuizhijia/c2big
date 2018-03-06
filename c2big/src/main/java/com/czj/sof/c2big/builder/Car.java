package com.czj.sof.c2big.builder;

import com.czj.sof.c2big.builder.impl.BMWDoor;

public class Car {

	
	public final Wheel wheel;
	
	public final Body body;
	
	public final Door door;

	private Car(Builder builder) {
		super();
		this.wheel = builder.wheel;
		this.body = builder.body;
		this.door = builder.door;
	}
	
	
	  public static class Builder {
		
		private Wheel wheel;
		
		private Body body;
		
		private Door door;
		
		public Builder(Door door) {
			this.door = door;
		}
		
		public Builder wheel(Wheel wheel) {
			this.wheel = wheel;
			return this;
		}
		
		public Builder body(Body body) {
			this.body = body;
			return this;
		}
		
		public Car Build() {
			return new Car(this);
		}
		
		
	}
	
	  
	 public void carDetial() {
			
		this.door.detial();
			
	}
	  
	  public static void main(String[] args) {
		  
		  Car car = new Car.Builder(new BMWDoor() {
			
			@Override
			public void detial() {
				System.out.println("excutor");
			}
		}).Build();
		  
		car.carDetial();
		  
	}
	  
	  
	  
}
