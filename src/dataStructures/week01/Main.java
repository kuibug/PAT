package dataStructures.week01;

import java.util.Scanner;

/*
 * 给定数组
 * 求子串最大和，并打印出子串首位的值
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			// 确定数组大小
			int size = sc.nextInt();
			int[] arr = new int[size];

			// 确定数组元素值
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			sc.close();
			long maxSum = 0, thisSum = 0;
			int start = arr[0], tem = arr[0], end = arr[size - 1];

			for (int i = 0; i < size; i++) {
				// 从0开始加和
				thisSum += arr[i];

				// 若结果出现负值重置结果，往下一个继续计算
				if (thisSum < 0) {
					thisSum = 0;
					if (i != size - 1)
						tem = arr[i + 1]; // 记录运算子串的第一个值

				}

				// 如果当前值大于最大值，更新，并记录子串的首尾
				if (thisSum > maxSum) {
					maxSum = thisSum;
					start = tem;
					end = arr[i];
				}
			}
			System.out.println(maxSum + " " + start + " " + end);

		}

	}
}
