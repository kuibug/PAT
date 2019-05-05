package javase.week06;

import java.util.Scanner;

public class StringLenth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(sc.hasNext()) {
			String str = sc.next();
			if(str.endsWith(".")) {
				System.out.print(str.length()-1);
				break;
			}else {
				System.out.print(str.length()+" ");
			}
		}
		sc.close();
	}
}
