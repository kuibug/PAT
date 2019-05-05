package dataStructures.week04;

import java.util.Arrays;
import java.util.Scanner;

class SearchTree {
	int node;
	int left;
	int right;

	@Override
	public boolean equals(Object obj) {
		SearchTree tree = (SearchTree) obj;
		boolean result = false;
		if (this.node == tree.node && this.left == tree.left && this.right == tree.right) {
			return true;
		}
		return result;
	}
}

public class SameTree {
	static int NULL = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			int node = sc.nextInt(); // 节点数
			if (node == 0) {
				// continue;
				System.exit(0);
			}
			int nummber = sc.nextInt(); // 测试数据数量

			int[][] data = scannerData(node, nummber, sc);

			// 建树
			SearchTree[] firstTree = builderTree(data[0], node);
			//
			for (int i = 1; i <= nummber; i++) {
				SearchTree[] checkTree = builderTree(data[i], node);
				// check(firstTree,checkTree);
				String flag = Arrays.equals(firstTree, checkTree) ? "Yes" : "No";
				System.out.println(flag);
			}
		}
		sc.close();
	}

	/**
	 * 利用数据建树
	 * 
	 * @param is
	 * @return
	 */
	private static SearchTree[] builderTree(int[] is, int node) {
		SearchTree[] list = new SearchTree[node + 1];
		// 遍历原始数据is
		SearchTree tree = new SearchTree();
		tree.node = is[0];
		tree.left = NULL;
		tree.right = NULL;
		list[0] = tree;
		for (int i = 1; i < node; i++) {
			insert(list, 0, is[i]);
		}
		return list;
	}

	private static void insert(SearchTree[] list, int index, int i) {
		// 进左子树
		if (i < list[index].node) {
			// 若不为空继续往深处走
			if (list[index].left != NULL) {
				index = list[index].left;
				insert(list, index, i);
			} else {
				// 若为空就新增一个节点插进去
				SearchTree tree = new SearchTree();
				tree.node = i;
				tree.left = NULL;
				tree.right = NULL;
				list[i] = tree;
				list[index].left = i;
			}
		}
		if (i > list[index].node) {
			if (list[index].right != NULL) {
				index = list[index].right;
				insert(list, index, i);
			} else {
				SearchTree tree = new SearchTree();
				tree.node = i;
				tree.left = NULL;
				tree.right = NULL;
				list[i] = tree;
				list[index].right = i;
			}
		}
	}

	/**
	 * 准备测试数据
	 * 
	 * @param node
	 * @param nummber
	 * @param sc
	 * @return
	 */
	private static int[][] scannerData(int node, int nummber, Scanner sc) {
		int[][] data = new int[nummber + 1][node];
		// 将原始数据逐个扫描进入数组，第一组是原始数据，往后依次是测试数据
		for (int i = 0; i <= nummber; i++) {
			for (int j = 0; j < node; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		return data;
	}
}
