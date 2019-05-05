package dataStructures.week05;

import java.util.Scanner;

public class FileTransfer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 新建一个数组存储集合
		int size = sc.nextInt();
		int[] coll = new int[size + 1];
		for (int i = 0; i < size + 1; i++) {
			coll[i] = -i;
		}

		// 接收操作符
		while (true) {
			String opt = sc.next();
			if (opt.equals("S")) {
				stop(coll, size);
				break;
			}
			int index1 = sc.nextInt();
			int index2 = sc.nextInt();

			switch (opt) {
			case "C":
				check(coll, index1, index2);
				break;
			case "I":
				connect(coll, index1, index2);
				break;
			default:
				break;
			}
		}
		sc.close();
	}

	private static void stop(int[] coll, int size) {
		int count = 0;
		for (int i : coll) {
			if (i < 0) {
				count++;
			}
		}
		if(count==1) {
			System.out.println("The network is connected.");
		}else {
			System.out.println("There are " + count + " components.");
		}
	}

	/**
	 * 合并集合
	 * 
	 * @param coll
	 * 
	 * @param index1
	 * @param index2
	 */
	private static void connect(int[] coll, int index1, int index2) {
		coll[index2] = index1;
	}

	/**
	 * 检查是否联通
	 * 
	 * @param coll
	 * @param index1
	 * @param index2
	 */
	private static void check(int[] coll, int index1, int index2) {
		int a = check(coll, index1);
		int b = check(coll, index2);

		if (a == b) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	// 检查所属集合
	private static int check(int[] coll, int index) {
		while (index > 0) {
			index = coll[index];
		}
		return index;
	}
}
