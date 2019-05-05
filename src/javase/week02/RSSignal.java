package javase.week02;

import java.util.Scanner;

public class RSSignal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			// 接收信号
			int RS = sc.nextInt();
			// 不在11-59内的数字直接干掉
			if (RS < 11 || RS > 59) {
				continue;
			}
			// 取出信号
			int R = RS / 10;
			int S = RS % 10;
			String rStr = "";
			String sStr = "";

			// R信号解释
			switch (R) {
			case 1:
				rStr = "unreadable.";
				break;
			case 2:
				rStr = "barely readable, occasional words distinguishable.";
				break;
			case 3:
				rStr = "readable with considerable difficulty.";
				break;
			case 4:
				rStr = "readable with practically no difficulty.";
				break;
			case 5:
				rStr = "perfectly readable.";
				break;
			default:
				break;
			}

			// S信号解释
			switch (S) {
			case 1:
				sStr = "Faint signals, barely perceptible, ";
				break;
			case 2:
				sStr = "Very weak signals, ";
				break;
			case 3:
				sStr = "Weak signals, ";
				break;
			case 4:
				sStr = "Fair signals, ";
				break;
			case 5:
				sStr = "Fairly good signals, ";
				break;
			case 6:
				sStr = "Good signals, ";
				break;
			case 7:
				sStr = "Moderately strong signals, ";
				break;
			case 8:
				sStr = "Strong signals, ";
				break;
			case 9:
				sStr = "Extremely strong signals, ";
				break;
			default:
				break;
			}
			System.out.println(sStr + rStr);
		}

		sc.close();
	}
}
