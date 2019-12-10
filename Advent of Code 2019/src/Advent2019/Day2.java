package Advent2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
}
