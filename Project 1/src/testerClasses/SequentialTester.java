package testerClasses;

import java.util.Scanner;

import Aproaches.SequentialFD;
import experimentClasses.CreateFile;

public class SequentialTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SequentialFD<Integer> intList = new SequentialFD<Integer>();
		SequentialFD<String> stringList = new SequentialFD<String>();
		CreateFile file = new CreateFile();
// Integers
		file.openFile("int");
		file.readFile("int");
		file.closeFile();
		
// Strings		
		file.openFile("string");
		file.readFile("string");
		file.closeFile();

	}
}
