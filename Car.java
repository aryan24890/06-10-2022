package com.filehandling.test;

import java.io.BufferedReader;
import java.io.IOException;

public class Car {
	private String model;
	private int year;
	private int km;
	private double price;
	
	public Car(String model, int year, int km, double price) {
		this.model = model;
		this.year = year;
		this.km = km;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getKm() {
		return km;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Car model: " + model +", year: " + year +", KM: "+ km +",Price: "+ price;
	}
	
	public boolean equalTo(Car c) {		//Compare to given data by exist car list
		return this.model.equals(c.model) && 
				this.year == c.year &&
				this.km == c.km &&
				this.price == c.price;
	}
	
	public static Car read(BufferedReader br) throws IOException{
		String str = br.readLine();
		
		if(str == null) {	//return null, if Any car not available
			return null;
		}
		else {	//return new Car
			return new Car(str, Integer.parseInt(br.readLine()),
							Integer.parseInt(br.readLine()),
							Double.parseDouble(br.readLine()));
		}
	}
}
