package Advent2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

	
	File file = new File("src/Advent2019/Day2P1.txt");
	BufferedReader br = null;
	
	public Day2(){
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	//op1 adds, op2 multiplies, 99 ends
	
	public int calculate(){
		if(br == null){
			System.err.println("File not found");
			return -1;
		}
		
		//read our line
		String str = "";
		String read = null;
		try {
			 read = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(read != null){
			str += read;
			try {
				 read = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(str.equals("")){
			System.err.println("ERROR reading file");
			return -1;
		}
		//get a opcode list
		String[] strList = str.split(",");
		int[] intList = new int[strList.length];
		for(int i=0; i<strList.length; i++){
			intList[i] = Integer.parseInt(strList[i]);
		}
		
		
		intList[1] = 12;
		intList[2] = 2;
		
		for(int i=0; i<intList.length; i+=4){
			if(intList[i] == 99){
				System.out.println("Encountered opcode 99");
				return intList[0];
			}
			System.out.println(intList[i] + "," + intList[i+1] + "," + intList[i+2] + "," + intList[i+3]);
			if(intList[i] == 1){
				intList[intList[i+3]] = intList[intList[i+1]] + intList[intList[i+2]];
				//System.out.println((i+3) + " set to: " + (intList[i+1] + intList[i+2]));
			}
			else if(intList[i] == 2){
				intList[intList[i+3]] = intList[intList[i+1]] * intList[intList[i+2]];
				//System.out.println((i+3) + " set to: " + (intList[i+1] + intList[i+2]));
			}
			else{
				System.err.println("UNEXPECTED OPCODE");
				return -1;
			}
		}
		
		
		return intList[0];
	}
}
