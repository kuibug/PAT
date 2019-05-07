package dataStructures.week06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 邻接矩阵版本
 * @author craftsman
 * @date 2019年5月7日
 */
public class ListConnectedSetsV2 {

	static int N, E;
	static int[][] node;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 顶点数
		E = sc.nextInt(); // 边数
		node = new int[N][N];// 建立一个邻接矩阵图

		// 建立边数据
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			node[a][b] = 1;
			node[b][a] = 1;
		}

		sc.close();
		print("DFS");
		print("BFS");

	}

	private static void print(String str) {
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				System.out.print("{ ");
				if (str.equals("DFS")) {
					DFS(i);
				} else {
					BFS(i);
				}
				System.out.println("}");
			}
		}
	}

	/**
	 * 当树遍历，层序遍历
	 * 先入队并标记，弹出队列的时候遍历就好
	 * @param V
	 */
	private static void BFS(int V) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(V); // 先把行入队
		System.out.print(V + " ");
		visited[V] = true;
		while (!qu.isEmpty()) {
			int Vertex = qu.poll();// 队列一个一个弹出来，并遍历该列所在行
			for (int i = Vertex; i < N; i++) {// 还是只要遍历一半的矩阵就好
				if (node[Vertex][i] != 0 && visited[i] == false) {
					qu.add(i);
					System.out.print(i + " ");
					visited[i] = true;
				}
			}
		}
	}

	/**
	 * DFS算法 一条路走到黑的递归 每一行中mark为1的数都是相互连通的 所以递归检查每行元素（列）的元素并打印出行的名字就好
	 * 
	 * 每一次DFS 就是一个联通的集合 所以调用的时候请 遍历行 调用DFS 但是检查一半的矩阵就好了，矩阵是对称的
	 * 
	 * @param X行
	 * @param y列
	 */
	private static void DFS(int X) {
		visited[X] = true;// 标记改行是否没遍历过，遍历过就是和别的行联通了
		System.out.print(X + " ");
		for (int y = X; y < N; y++) {
			if (node[X][y] != 0 && visited[y] == false) {
				DFS(y);
			}
		}
	}

}