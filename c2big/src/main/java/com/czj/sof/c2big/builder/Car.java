package com.czj.sof.c2big.builder;

import com.czj.sof.c2big.builder.impl.BMWDoor;

public class Car {

	
	public final Wheel wheel;
	
	public final Body body;
	
	public final Door door;

	private Car(BuilderCar builder) {
		super();
		this.wheel = builder.wheel;
		this.body = builder.body;
		this.door = builder.door;
	}
	
	
	  public static class BuilderCar implements Builder<Car>{
		
		private Wheel wheel;
		
		private Body body;
		
		private Door door;
		
		public BuilderCar(Door door) {
			this.door = door;
		}
		
		public BuilderCar wheel(Wheel wheel) {
			this.wheel = wheel;
			return this;
		}
		
		public BuilderCar body(Body body) {
			this.body = body;
			return this;
		}
		
		@Override
		public Car build() {
			return new Car(this);
		}
		
		
	}
	
	  
	 public void carDetial() {
			
		this.door.detial();
			
	}
	  
	  public static void main(String[] args) {
		  
		  Car car = new Car.BuilderCar(new BMWDoor() {
			
			@Override
			public void detial() {
				System.out.println("excutor");
			}
		}).build();
		  
//		car.carDetial();
		
		System.out.println(car);
		
		
		 Car car1 = new Car.BuilderCar(new BMWDoor() {
				
				@Override
				public void detial() {
					System.out.println("excutor");
				}
			}).build();
		

			System.out.println(car1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				 Car car = new Car.BuilderCar(new BMWDoor() {
						
						@Override
						public void detial() {
							System.out.println("excutor");
						}
					}).build();
				System.out.println(car);	  
				
			}
		}).start();
		  
	}
	  
	  
	  
}
