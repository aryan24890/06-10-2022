/*
 * 3.	We want to realize a program for handling new and used cars to sell.

For each car to sell, the information about the car is stored on a text file.

Realize a class Car, to handle a single car.
 
Each car is characterized by the following information: 
	model,
	manufacturing year, 
	driven kilometers, 
	and price. 
	
New cars can be distinguished by the fact that the driven kilometers are 0.

The class Car should export the following methods:

• a constructor to construct a car object, given all the data about the car as parameters;

• suitable get-methods to obtain the data about the car;

• a toString method, which does overriding of the toString method inherited from Object, and returns a string containing the data about the car;

• boolean equalTo(Car c) : that returns true if the car coincides with the car c in all of its data, and false otherwise.

• public static Car read(BufferedReader br) throws IOException : that returns a Car object reading from the file.

Realize a class CarList, each of whose objects represents a list of cars to sell. 

A CarList object does not directly store the data about the cars to sell, but maintains the name of a text file in which such data are stored, according to the following format:

model
manufacturing year (year)
driven kilometers (km)
price

The class CarList should export the following methods:

• CarList(String filename) : constructor with a parameter of type String, representing the name of the file in which the data about the cars to sell are stored;

• int countNewCars() : that returns the number of new cars in the list of cars to sell;

• Car mostExpensiveCar() : that returns the Car object corresponding to the most expensive car in the list of cars to sell.

• void addCar(Car c) : that adds the car c to the end of the list of cars to sell.

• void remove(Car c) : that removes from the list of cars to sell the car whose data coincides with that of c, if such a car is present, and leaves the list unchanged otherwise.

 */

package com.filehandling.test;

import java.io.*;

public class TestCar {

	public static void main(String[] args) {
		try {
		Car c1 = new Car("Hyundai011",2020,0, 500000);
		Car c2 = new Car("Suzuki022",2016,0,750000);
		Car c3 = new Car("Hyundai012",2019,0,750000);
		Car c4 = new Car("Tata031",2020,0,750000);
		Car c5 = new Car("Tata032",2021,0, 700000);
		Car c6 = new Car("Suzuki021",2017,1000,600000);
		Car c7 = new Car("Suzuki023",2008,5000,650000);
		Car c8 = new Car("Hyundai013",2019,0,75000);
		Car c9 = new Car("Hyundai014",2021,0,950000);
		Car c10 = new Car("Honda041",2021,0,850000);
		Car c11 = new Car("Tata032",2021,0, 700000);
		
		//Creating the array of Car class
		Car [] cars = new Car[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11};
		
		
		File f = new File("car.txt");
		f.delete();
		
		//Creating the object of CarList
		CarList carList = new CarList("car.txt");
		
		for(Car c : cars) {
			carList.addCar(c);
		}
		
		//print the no. of new car
		System.out.println("New Cars : " + carList.countNewCars());
		
		//print most expensive car.
		System.out.println("Most expensive Car : " +carList.mostExpensiveCar());
		
		//Remove car
		/*carList.removeCar(c11);
		System.out.println("After removing new Cars: " +carList.countNewCars());
		*/
		}
		catch(Exception ex) { // for any Exception
			System.out.println(ex.getMessage());
		}
		
		

	}

}
