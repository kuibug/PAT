package javase.week01;

import java.util.Scanner;

public class kToC {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 输入一个华氏温标
		int hua = scanner.nextInt();
		// 公式处理
		int she = (int) ((hua - 32) * (5 / 9.0));
		// 输入摄氏温标
		System.out.println(she);
		scanner.close();
	}

}