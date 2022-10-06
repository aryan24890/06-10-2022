package com.filehandling.test;

import java.io.*;

public class CarList {
	private String fileName;
	
	//Single parameter constructor
	public CarList (String fileName) {
		this.fileName = fileName;
	}
	
	public int countNewCars() throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		int count = 0;
		Car c = Car.read(br);
		while (c != null) {
			if (c.getKm() == 0)
				count++;
			c = Car.read(br);
		}
		br.close();
		
		return count;
	}
	
	public Car mostExpensiveCar() throws IOException {
		// this is the second alternative for opening a file for reading
		FileInputStream is = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		double max = 0;
		Car cmax = null;
		Car c = Car.read(br);
		while (c != null) {
			if (c.getPrice() > max) {
				max = c.getPrice();
				cmax = c;
			}
			c = Car.read(br);
		}
		br.close();
		return cmax;
	}
	
	public void addCar(Car c) throws IOException {
		FileWriter fw = new FileWriter(fileName, true); 
		PrintWriter pw = new PrintWriter(fw);
		pw.println(c.getModel());
		pw.println(c.getYear());
		pw.println(c.getKm());
		pw.println(c.getPrice());
		pw.close();
	}
	
	//remove Car
	public void removeCar(Car c) throws IOException {
		File f = new File(fileName);
		FileInputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		
		File ftemp = new File("mycar.txt");
		FileOutputStream os = new FileOutputStream(ftemp);
		PrintWriter pw = new PrintWriter(os);
		Car curr = Car.read(br);
		while (curr != null) {
			if (!curr.equalTo(c)) {
				pw.println(curr.getModel());
				pw.println(curr.getYear());
				pw.println(curr.getKm());
				pw.println(curr.getPrice());
			}
			curr = Car.read(br);
		}
		br.close();
		pw.close();
		ftemp.renameTo(f);
	}
}