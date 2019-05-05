package dataStructures.week01;

import java.util.Scanner;

/**
 * /使用复杂度为1的算法完成最大子串和,结果为负数时返回0
 * 
 * @author craftsman
 * @date 2019年3月7日
 */
public class MaxSubSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 定义长度
			int size = sc.nextInt();
			int[] arr1 = new int[size];
			// 输入内容
			for (int i = 0; i < size; i++) {
				arr1[i] = sc.nextInt();
			}
			System.out.println(max(arr1));
		}
		// 关闭资源并打印结果
		sc.close();
	}

	// 1.创建变量储存最大值，循环遍历数组
	// 2.从第一位开始加和，若出现加和为0则重新计数
	private static long max(int[] arr) {
		if (arr == null)
			System.exit(1);
		long maxSum = 0, thisSum = 0;
		for (int i : arr) {
			// 相加和
			thisSum += i;

			// 若结果为负数就直接重置状态
			if (thisSum < 0) {
				thisSum = 0;
			}

			// 若结果为比原来储存值大则更新
			if (thisSum > maxSum) {
				maxSum = thisSum;
			}
		}

		return maxSum;
	}

}
