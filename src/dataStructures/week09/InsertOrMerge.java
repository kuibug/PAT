package dataStructures.week09;

import java.util.Scanner;

public class InsertOrMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] original = new int[size];
		int[] sortting = new int[size];
		//原始序列输入
		for (int i = 0; i < size; i++) {
			original[i] = sc.nextInt();
		}
		//部分排序序列
		for (int i = 0; i < size; i++) {
			sortting[i] = sc.nextInt();
		}
		//检查是inset还是merge
		boolean flag = isMerge(original,sortting,size);
		if(!flag) {
			insert(sortting);
		}else {
			Merge(original);
		}
		sc.close();
	}

	private static void Merge(int[] original) {
		// TODO Auto-generated method stub
		
	}

	private static void insert(int[] sortting) {
		// TODO Auto-generated method stub
		
	}

	private static boolean isMerge(int[] original, int[] sortting, int size) {
		// TODO Auto-generated method stub
		return false;
	}
}
