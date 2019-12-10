package Advent2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Fuel required to launch a given module is based on its mass. 
 * Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
 * 
 * 
 */
public class Day1P1 {
	
	File file = new File("src/Advent2019/Day1P1.txt");
	BufferedReader br = null;
	
	public Day1P1(){
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public int calculate(){
		if(br == null){
			System.err.println("File not found");
			return -1;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String str = null;
		try {
			 str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(str != null){
			//calculate
			int temp = Integer.parseInt(str);
			int divide3 = temp = Math.floorDiv(temp, 3);
			int sub2 = divide3-2;
			list.add(sub2);
			
			//read next line
			try {
				 str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int sum = 0;
		for(int i=0; i<list.size(); i++){
			int x = list.get(i).intValue();
			sum += x;
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
	
	public int calculateWithFuel(){
		if(br == null){
			System.err.println("File not found");
			return -1;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String str = null;
		try {
			 str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(str != null){
			//calculate how much fuel needed for this
			int temp = Integer.parseInt(str);
			int divide3 = temp = Math.floorDiv(temp, 3);
			int sub2 = divide3-2;
			
			int extraFuel = Math.max((Math.floorDiv(sub2, 3)-2), 0);
			int totalFuel = sub2;
			
			while(extraFuel != 0){
				totalFuel += extraFuel;
				extraFuel = Math.max((Math.floorDiv(extraFuel, 3)-2), 0);
			}
			
			
			
			
			list.add(totalFuel);
			
			//read next line
			try {
				 str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int sum = 0;
		for(int i=0; i<list.size(); i++){
			int x = list.get(i).intValue();
			sum += x;
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
	

}
