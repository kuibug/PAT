package dataStructures.week03;

import java.util.Arrays;
import java.util.Scanner;

class TreeNode {
	String val;
	int left;
	int right;
}

public class BinTree {
	static int NULL = -1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 记录第一个树的信息
		int T = scan.nextInt();
		TreeNode[] T1 = new TreeNode[T];
		int[] check = new int[T];

		int root = buildTree(scan, T, T1, check);

		// 记录第二个数的信息
		int lastT = T;
		T = scan.nextInt();
		
		//若节点数不一样拜拜
		if (T != lastT) {
			System.out.println("No");
		}else {
			//如果一样，创建第二个树，并重置根节点检查数组
			TreeNode[] T2 = new TreeNode[T];
			Arrays.fill(check, 0);
			int root1 = buildTree(scan, T, T2, check);

			System.out.println(an(root, root1, T1, T2) ? "Yes" : "No");
		}
	}

	private static int buildTree(Scanner scan, int T, TreeNode[] Trees, int[] check) {
		for (int i = 0; i < T; i++) {
			
			Trees[i] = new TreeNode();
			Trees[i].val = scan.next();
			String left = scan.next();
			String right = scan.next();

			if (left.equals("-")) {
				Trees[i].left = NULL;
			} else {
				Trees[i].left = Integer.parseInt(left);
				check[Integer.parseInt(left)] = 1;
			}

			if (right.equals("-")) {
				Trees[i].right = NULL;
			} else {
				Trees[i].right = Integer.parseInt(right);
				check[Integer.parseInt(right)] = 1;
			}
		}

		// 检查根节点，若没有找到返回-2（-1被没有子节点占用，防止混淆）
		int root = NULL;
		for (int i = 0; i < T; i++) {
			if (check[i] == 0) {
				root = i;
			}
		}

		return root;
	}

	// 检查
	public static boolean an(int root1, int root2, TreeNode[] T1, TreeNode[] T2) {
		//两空树，呵呵哒
		if (root1 == NULL && root2 == NULL) {
			return true;
		}
		//一个空树一个非空树，或者根节点不一样，同同样呵呵哒
		if ((root1 == NULL && root2 != NULL) || (root1 != NULL && root2 == NULL) || (!T1[root1].val.equals(T2[root2].val))) {
			return false;
		}
		//左子树都空的时候
		if (T1[root1].left == NULL && T2[root2].left == NULL) {
			return an(T1[root1].right, T2[root2].right, T1, T2);
		}
		//左子树都不空的，且根节点相同
		if ((T1[root1].left != NULL && T2[root2].left != NULL) && T1[T1[root1].left].val.equals(T2[T2[root2].left].val)) {
			return (an(T1[root1].left, T2[root2].left, T1, T2) && an(T1[root1].right, T2[root2].right, T1, T2));
		} else {
			return (an(T1[root1].left, T2[root2].right, T1, T2) && an(T1[root1].right, T2[root2].left, T1, T2));
		}
	}
}
