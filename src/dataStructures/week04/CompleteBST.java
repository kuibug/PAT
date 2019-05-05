package dataStructures.week04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 分析：传入节点数N，根据H = log2(N+1),计算出满树层数，计算左子树规模，开始递归建树
 * 
 * @author craftsman
 * @date 2019年4月18日
 */
public class CompleteBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 传进来的数据存在数组里备用
		int N = sc.nextInt();
		int[] in_data = new int[N];
		for (int i = 0; i < N; i++) {
			in_data[i] = sc.nextInt();
		}

		// 排序
		// System.out.println("输入数据：" + Arrays.toString(in_data));
		Arrays.sort(in_data);
		// System.out.println("输入排序：" + Arrays.toString(in_data));

		// 新建一个数组开始添加进树
		int[] CBST = new int[N];
		build(CBST, in_data, 0, N - 1, 0);

		// 遍历树（就是遍历数组）
		// System.out.println(Arrays.toString(CBST));
		for (int i = 0; i < N; i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(CBST[i]);

		}
		sc.close();
	}

	private static void build(int[] CBST, int[] in_data, int start, int end, int root) {
		int n = end - start + 1;
		if (n == 0)
			return;
		// 计算左子树大小
		int leftSize = leftSize(n);

		// 先将root节点填位置，root比左子树大小+1，数组坐标刚好对应
		CBST[root] = in_data[start + leftSize];
		// System.out.print(in_data[start + leftSize] + ",");
		int leftRoot = root * 2 + 1;
		int rightRoot = leftRoot + 1;
		// 左子树递归
		build(CBST, in_data, start, start + leftSize - 1, leftRoot);
		// 右子树递归
		build(CBST, in_data, start + leftSize + 1, end, rightRoot);
	}

	/**
	 * 计算完全二叉树的左子树规模
	 * 
	 * @param n
	 * @return
	 */
	private static int leftSize(int n) {
		// 满树的层数
		int H = (int) (Math.log(n + 1) / Math.log(2));
		// 最后一层的节点数 = N - (2^H - 1)
		int X = (int) (n - (Math.pow(2, H) - 1));
		// 若最后一层的节点数超过一半，那么左子树只占一半
		int half = (int) Math.pow(2, H - 1);
		if (X > half) {
			X = half;
		}
		// 左子树的节点数量 = 满树一半 + 最后一层的X
		int size = (int) (Math.pow(2, H) - 1) / 2 + X;
		// System.out.println("满树高度：" + H + " 左子树大小:" + size);
		return size;
	}

}
