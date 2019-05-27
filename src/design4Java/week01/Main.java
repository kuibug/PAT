package design4Java.week01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Object[] obj1 = {"a","dsad"};
		Object[] obj2 = {1,3,5};
		
		print(obj1);
		print(obj2);
	}

	private static void print(Object[] obj1) {
		for (Object object : obj1) {
			System.out.print(object+"\t");
		}
		System.out.println();
	}

}
