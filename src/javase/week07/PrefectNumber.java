package javase.week07;

import java.util.ArrayList;
import java.util.Scanner;

public class PrefectNumber {
	public static void main(String[] args) {
		// 先接受到两个数再说
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int num = start; num <= end; num++) {
			// 判断是否是完数
			if (num != 1 && isPrefect(num)) {
				result.add(num);
			}
		}

		// 输出
		int size = result.size() - 1;//这里的size-1是为了后面方便
		if (size == 0) {
			System.out.println();
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.print(result.get(size));
		}
		sc.close();
	}

	private static boolean isPrefect(int num) {
		boolean isPrefect = false;
		int tem = num;

		// 先算因子，存到数组里
		// int[] str = new int[30];
		// int index = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < num; i++) {
			// 从最小的指数开始÷，直到它本身
			if (num % i == 0) {
				list.add(i);
			}
		}
		// System.out.println(list);
		// 再看因子和
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		if (sum == tem) {
			isPrefect = true;
		}
		return isPrefect;
	}
}
