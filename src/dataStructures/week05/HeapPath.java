package dataStructures.week05;

import java.util.Arrays;
import java.util.Scanner;

public class HeapPath {
	final static int NULL = 10001;
	// 采用完全二叉树实现最小堆，数组顺序结构存储
	// 完全二叉树，data left right data下标*2+1为左子树的下标
	// 插入到树的最后一个节点，与父节点比较换位

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 先接受数据
		int nodeNum = sc.nextInt();// 节点数量
		int Number = sc.nextInt();// 打印的路径数量

		// 建立一个空的最小堆
		int[] minHeap = new int[nodeNum + 1];
		Arrays.fill(minHeap, NULL);	//fill 太耗时，保证数据正确的情况下尽量少用
		minHeap[0] = -10001; // 哨兵节点

		// 循环插入数据
		for (int i = 1; i <= nodeNum; i++) {
			int insertData = sc.nextInt();// 插入的节点数据
			insert(minHeap, insertData, 1);
		}

		// 循环打印路径
		for (int i = 0; i < Number; i++) {
			printPath(minHeap, sc.nextInt());
			if(i<Number-1) {
				System.out.println();
			}
		}

		sc.close();
	}

	// 根据下标打印路径
	private static void printPath(int[] minHeap, int index) {
		// 传入下标-1再➗2是父节点的下标
		while (index > 0) {
			System.out.print(minHeap[index]);
			if(index>1) {
				System.out.print(" ");
			}
			index = index / 2;
		}
	}

	/**
	 * 建树,其实总是往树的最后一个插入，就是在数组的下一个进行插入
	 * 
	 * @param minHeap 最终建成的树
	 * @param node    插入的数据创造的节点
	 * @param index   节点数量
	 */
	private static void insert(int[] minHeap, int node, int index) {
		if (minHeap[index] == NULL) {
			minHeap[index] = node;
			fix(minHeap, index);
		} else {
			index += 1;
			insert(minHeap, node, index);
		}
	}

	/**
	 * 调整路径
	 * 
	 * @param minHeap
	 * @param index
	 */
	private static void fix(int[] minHeap, int index) {
		// 若是插入的数字比父节点小和父节点交换位置
		while (minHeap[index] < minHeap[index / 2]) {
			int tem = minHeap[index];
			minHeap[index] = minHeap[index / 2];
			minHeap[index / 2] = tem;
			//交换位置完成后往上检查
			index  = index/ 2;
		}
	}
}
