package dataStructures.week02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求设计函数分别求两个一元多项式的乘积与和。 1.输入函数，储存为数组 2.取出两个数组进行加法 3.取出两个数组进行乘法 4.遍历数组打印
 * 
 * @author craftsman
 * @date 2019年3月14日
 */
public class Poly {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 将输入转换二维数组储存。 输入格式： [个数] [系数1] [指数1] [系数2] [指数2] ……(指数降幂)
	 * 
	 * @return list 输入储存的二维数组
	 */
	public static int[][] input() {
		// Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		// 指定长度
		int[][] list = new int[count][2];

		// 输入元素
		for (int i = 0; count > 0; count--, i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
		}
		// sc.close();
		printResultTest(list);
		return list;
	}

	// 计算两个多项式的和
	public static int[][] add(int[][] a, int[][] b) {
		// 初始化
		int lenA = a.length;
		int lenB = b.length;
		int[][] result = new int[lenA + lenB][2];

		int ah = 0; // a数组标记
		int bh = 0; // b数组标记

		for (int i = 0; i < result.length; i++) {
			// 两个计算数组都未遍历完成时候
			if (ah < lenA && bh < lenB) {
				// a的次幂大于b的次幂，则将a的节点存进结果数组
				if (a[ah][1] > b[bh][1]) {
					result[i] = a[ah];
					ah++;
				} else
				// a的次幂小于b的次幂，则将b的节点存进结果数组
				if (a[ah][1] < b[bh][1]) {
					result[i] = b[bh];
					bh++;
				} else
				// 次幂相等的状况
				{
					result[i][0] = a[ah][0] + b[bh][0];
					result[i][1] = a[ah][1];
					ah++;
					bh++;
				}
			} else
			// 当a遍历完成后,将b存入结果
			if (ah == lenA) {
				while (bh < lenB) {
					result[i] = b[bh];
					bh++;
				}
			} else
			// 当b遍历完成后,将a存入结果
			if (bh == lenB) {
				while (ah < lenA) {
					result[i] = a[ah];
					ah++;
				}
			}
		}

		return result;
	}

	/**
	 * 调试使用的print
	 * 
	 * @param result
	 */
	public static void printResultTest(int[][] result) {
		for (int[] is : result) {
			if (is[0] != 0) {
				System.out.print(Arrays.toString(is) + " ");
			}
		}
		System.out.println();
	}

	/**
	 * 正式的打印语句（一会不要删错了）
	 * 
	 * @param args
	 */
	public static void printResult(int[][] result) {
		boolean tag = false;
		StringBuilder builder = new StringBuilder();

		// 遍历
		for (int[] is : result) {
			if (is[0] != 0) {
				tag = true;
				builder.append(is[0] + " " + is[1] + " ");
			}
		}
		builder.delete(builder.length() - 1, builder.length());

		// 打印 若标志位false数组全是0
		if (tag) {
			System.out.println(builder);
		} else {
			System.out.println("0 0");
		}
	}

	public static int[][] mutl(int[][] a, int[][] b) {
		// 初始化
		int lenA = a.length;
		int lenB = b.length;
		int[][] result = new int[lenA * lenB][2];
		int lenR = result.length;

		int rh = 0;

		// 先挨个乘积
		while (rh < lenR) {
			for (int[] is : a) {
				for (int[] is2 : b) {
					result[rh][0] = is[0] * is2[0];
					result[rh][1] = is[1] + is2[1];
					rh++;
				}
			}
		}
		printResultTest(result);
		// 在排序
		for (int i = 1; i < lenR; i++) {
			for (int j = 0; j < lenR - i; j++) {
				if (result[j][1] < result[j + 1][1]) {
					int[] temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}else if(result[j][1] == result[j + 1][1]) {
					result[j][0] = result[j+1][0]+result[j][0];
					result[j+1][0] = 0;
					result[j+1][1] = 0;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		// 4 3 4 -5 2 6 1 -2 0
		// 3 5 20 -7 4 3 1
		System.out.println("输入第一个数组");
		int[][] a = input();
		System.out.println("输入第二数字");
		int[][] b = input();

		int[][] result = add(a, b);
		printResultTest(result);

		int[][] re = mutl(a, b);
		printResultTest(re);

	}
}
