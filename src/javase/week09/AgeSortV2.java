package javase.week09;

import java.util.Scanner;

public class AgeSortV2 {
	public static void main(String[] args) {

		int[] age = new int[51];

		// Scanner sc = new Scanner(System.in);
		// int size = sc.nextInt();
		// long start = System.currentTimeMillis();
		// for (int i = 0; i < size; i++) {
		// int data = sc.nextInt();
		// age[data]++;
		// }

		int[] arr = zeroArray();
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			int tem = arr[i];
			age[tem]++;
		}

		// System.out.println(Arrays.toString(age));

		int count = 0;
		for (int i = 0; i < 51; i++) {
			if (age[i] != 0 && count <= 100000) {
				System.out.println(i + ":" + age[i]);
				count += age[i];
			}
		}
		 long end = System.currentTimeMillis();
		 System.out.println(end - start + "ms");
	}

	static int[] random() {
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		return arr;
	}

	static int[] zeroArray() {
		return new int[100000];
	}

}
