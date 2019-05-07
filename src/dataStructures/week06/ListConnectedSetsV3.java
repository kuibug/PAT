package dataStructures.week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 邻接表版本，arraylist实现 实际上是V1的升级版本，V1要实现排序操作复杂（和树排序一样，要借用堆栈排序），并且数组中储存一个递归类很浪费空间
 * 
 * @author craftsman
 * @date 2019年5月7日
 */

public class ListConnectedSetsV3 {
	static int N, E;
	// static ArrayList<Integer>[] table;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 顶点数
		E = sc.nextInt(); // 边数

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] table = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			table[i] = new ArrayList<Integer>();
		}
		// 建立边数据
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			table[a].add(b);
			table[b].add(a);
		}
		// System.out.println(Arrays.toString(table));
		sc.close();

		// 排序,以满足PTA递增遍历的变(tou)态(lan)要求
		for (int i = 0; i < N; i++) {
			Collections.sort(table[i]);
		}
		print("DFS", table);
		print("BFS", table);

	}

	/**
	 * 打印函数，此处因为ArrayList数组的特殊机制，目前只能手动传参
	 * 
	 * @param str
	 * @param table
	 */
	private static void print(String str, ArrayList<Integer>[] table) {
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				System.out.print("{ ");
				if (str.equals("DFS")) {
					DFS(i, table);
				} else {
					BFS(i, table);
				}
				System.out.println("}");
			}
		}
	}

	/**
	 * BFS算法 同样队列实现
	 * 
	 * @param i
	 * @param table
	 */
	private static void BFS(int i, ArrayList<Integer>[] table) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(i); // 先把行入队
		System.out.print(i + " ");
		visited[i] = true;
		while (!qu.isEmpty()) {
			int Vertex = qu.poll();// 队列一个一个弹出来，并遍历该列所在行
			for (Integer integer : table[Vertex]) {
				if (visited[integer] == false) {
					qu.add(integer);
					System.out.print(integer + " ");
					visited[integer] = true;
				}
			}
		}
	}

	/**
	 * DFS算法
	 * 
	 * @param i
	 * @param table[i]
	 */
	private static void DFS(int i, ArrayList<Integer>[] table) {
		// 进来先标记已读并打印
		visited[i] = true;
		System.out.print(i + " ");
		// 遍历并递归
		for (Integer integer : table[i]) {
			if (visited[integer] == false) {
				DFS(integer, table);
			}
		}
	}
}
