package dataStructures.week09;

import java.util.Arrays;
import java.util.Scanner;

public class AgeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		long start = System.currentTimeMillis();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		// long start = System.currentTimeMillis();
		// int[] arr1 = zeroArray();
		//int[] arr1 = { 10, 2, 0, 5, 7, 2, 5, 2 };
		//long start = System.currentTimeMillis();
		// System.out.println(Arrays.toString(arr1));
		Arrays.sort(arr);
		long end = System.currentTimeMillis();
		// System.out.println(Arrays.toString(arr1));
		System.out.println("sort:" + (end - start));

		print(arr);
		long end1 = System.currentTimeMillis();
		System.out.println("each:" + (end1 - end));
		sc.close();
	}

	private static void print(int[] arr1) {
		int len = arr1.length;
		if (arr1[0] == arr1[len - 1]) {
			System.out.println(arr1[0] + ":" + len);
			return;
		}
		int[] arr = Arrays.copyOf(arr1, len + 1);
		int e = arr[0];
		int count = 0;
		for (int i : arr) {
			if (i == e) {
				count++;
			} else {
				System.out.println(e + ":" + count);
				e = i;
				count = 0;
				count++;
			}
		}
	}

	static int[] zeroArray() {
		return new int[100000];
	}

	static int[] random() {
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		return arr;
	}

	static int[] reverse() {
		int[] arr = new int[100000];
		int e = 100000;
		for (int i = 0; i < 100000; i++) {
			arr[i] = e--;
		}
		return arr;
	}
}
