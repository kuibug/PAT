package dataStructures.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Tree {
	int node;
	int left;
	int right;
}

public class TraversalsAgain {
	static int NULL = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt(); // 节点数量
		sc.nextLine(); // 先换行不然会数组第一个会存入空字符串

		Tree[] treeList = new Tree[line + 1];
		String[] operate = new String[line * 2];
		for (int i = 0; i < line * 2; i++) {
			operate[i] = sc.nextLine();
		}

		System.out.println(Arrays.toString(operate));
		buidTree(operate, treeList, line);
		sc.close();
	}

	private static void buildLast(ArrayList<Integer> qian, ArrayList<Integer> zhong, int line) {
		//ArrayList转成array
		int[] a = new int[line];
		int[] b = new int[line];
		for (int i = 0; i < line; i++) {
			a[i] = qian.get(i);
			b[i] = zhong.get(i);
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		//开始二分
		//先处理左边
		int root = a[0];
		int rootIndex = Arrays.binarySearch(b, root);
		int[] b1 = new int[rootIndex+1];
		int[] b2 = new int[line-rootIndex];
		for(int i = 0;i<b.length;i++) {
			if(i<rootIndex)
				b1[i] = b[i];
			else
				b2[i] = b[i];
		}
	}

	private static void buidTree(String[] operate, Tree[] treeList, int line) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> qian = new ArrayList<Integer>(line);
		ArrayList<Integer> zhong = new ArrayList<Integer>(line);

		// 遍历操作集合
		for (String str : operate) {
			// 检测pop操作
			if (!stack.isEmpty() && str.equals("Pop")) {
				int pop = stack.pop();
				zhong.add(pop);
			} else { // push操作
				int index = Integer.parseInt(str.charAt(5) + "");
				stack.push(index);
				qian.add(index);
			}
		}

		buildLast(qian, zhong, line);
	}
}
