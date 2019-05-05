package javase.week04;

import java.util.Scanner;

public class ReadInteger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String intStr = sc.next();
		int len = intStr.length();
		for (int i = 0; i < len; i++) {
			char temp = intStr.charAt(i);
			String read = read(temp);
			System.out.print(read);
			if (i < len - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
		System.out.println(intStr + ":" + len);
		sc.close();
	}

	private static String read(int i) {
		String read = "";
		switch (i) {
		case '-':
			read = "fu";
			break;
		case '0':
			read = "ling";
			break;
		case '1':
			read = "yi";
			break;
		case '2':
			read = "er";
			break;
		case '3':
			read = "san";
			break;
		case '4':
			read = "si";
			break;
		case '5':
			read = "wu";
			break;
		case '6':
			read = "liu";
			break;
		case '7':
			read = "qi";
			break;
		case '8':
			read = "ba";
			break;
		case '9':
			read = "jiu";
			break;

		default:
			break;
		}
		return read;
	}
}
