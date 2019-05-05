package dataStructures.week03;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

class BinTreeNode {
	int left;
	int right;
}

public class EachTree {
	static int NULL = -1;
	static int YES = 1; // 有父节点
	static int NO = 0; // 没有父节点

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 节点数量
		int size = sc.nextInt();
		if (size == 1) {
			System.out.println(0);
		} else {
			BinTreeNode[] list = new BinTreeNode[size];
			int[] check = new int[size];

			int root = buildTree(sc, size, list, check);
			eachTree(list, root);
		}
	}

	/**
	 * 层次遍历二叉树
	 * 
	 * @param list
	 * @param root
	 */
	private static void eachTree(BinTreeNode[] list, int root) {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
		StringBuilder build = new StringBuilder();
		while (root != NULL) {

			// 左节点入队
			if (list[root].left != NULL) {
				queue.offer(list[root].left);
			}
			if (list[root].right != NULL) {
				queue.offer(list[root].right);
			}
			// 队列顶弹出来
			if (!queue.isEmpty()) {
				root = queue.poll();
				if (list[root].left == NULL && list[root].right == NULL) {
					build.append(root + " ");
				}
			} else {
				root = NULL;
			}
		}
		build.delete(build.length() - 1, build.length());
		System.out.println(build);
	}

	/**
	 * 创建二叉树
	 * 
	 * @param sc
	 * @param size  节点数
	 * @param list  二叉树
	 * @param check 检查数组
	 * @return
	 */
	private static int buildTree(Scanner sc, int size, BinTreeNode[] list, int[] check) {
		for (int i = 0; i < size; i++) {
			BinTreeNode node = new BinTreeNode();
			String left = sc.next();
			String right = sc.next();

			// 左子树
			if (left.equals("-")) {
				node.left = NULL;
			} else {
				node.left = Integer.parseInt(left);
				check[Integer.parseInt(left)] = YES;
			}

			// 右子树
			if (right.equals("-")) {
				node.right = NULL;
			} else {
				node.right = Integer.parseInt(right);
				check[Integer.parseInt(right)] = YES;
			}
			list[i] = node;
		}

		// 检查根节点
		int root = NULL;
		for (int i = 0; i < size; i++) {
			if (check[i] == NO) {
				root = i;
			}
		}
		return root;
	}
}
