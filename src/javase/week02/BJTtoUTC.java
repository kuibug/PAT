package javase.week02;

import java.util.Scanner;

public class BJTtoUTC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int UTC = 0;
		while (sc.hasNext()) {
			int time = sc.nextInt();

			if (time >= 800 && time < 2400) {
				UTC = time - 800;

			} else if (time >= 0 && time < 800) {
				UTC = time - 800 + 2400;

			} else {
				continue;
			}
			System.out.println(UTC);
		}
		sc.close();
	}
}
