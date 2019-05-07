package dataStructures.week06;

import java.util.Scanner;
import java.util.Stack;

/**
 * 	列出连通集，邻接表版本(selfVision)
 *	 注意：不满足PTA 按编号递增的顺序访问邻接点 的要求，若要满足要求请对TablePoint进行排序
 * @author craftsman
 * @date 2019年5月6日
 */
class TablePoint {

	int p;
	TablePoint netxpoint;

	public TablePoint(int point) {
		this.p = point;
	}

	@Override
	public String toString() {
		return "Point [p=" + p + " n=" + netxpoint + "]";
	}
}

public class ListConnectedSets {
	static int N, E;
	static TablePoint[] table;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 第一行顶点和边的数量
		N = sc.nextInt();
		E = sc.nextInt();

		// 串接邻接表,下标代表顶点
		table = new TablePoint[N];

		// 具体的边
		for (int i = 0; i < E; i++) {
			int pointA = sc.nextInt();
			int pointB = sc.nextInt();
			addLine(table[pointA], table[pointB], pointA, pointB);
		}
		sc.close();

		for (TablePoint tablePoint : table) {
			System.out.println(tablePoint);
		}
		System.out.println("========================");

		print("DFS");
		print("BFS");

	}

	private static void print(String str) {
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				System.out.print("{ ");
				if (str.equals("DFS")) {
					DFS(i, table[i]);
				} else {
					BFS(i, table[i]);
				}
				System.out.println("}");
			}
		}
	}

	/**
	 * DFS算法
	 * @param rows
	 * @param point
	 */
	private static void DFS(int rows, TablePoint point) {
		// 进来还是先标记为已读
		visited[rows] = true;
		// 打印节点头
		System.out.print(rows + " ");
		// 建立队列 并把该行数据全部入队
		Stack<Integer> stack = new Stack<Integer>();
		while (point != null) {
			if (visited[point.p] == false) {
				stack.push(point.p);
				visited[point.p] = true;// 入队时候也mark 一下防止递归时候重复入队
			}
			point = point.netxpoint;
		}
		// 出队的时候递归调用BFS
		while (!stack.isEmpty()) {
			int p = stack.pop();
			BFS(p, table[p]);
		}
	}

	/**
	 * BFS算法 终于简洁了
	 * @param rows
	 * @param point
	 */
	private static void BFS(int rows, TablePoint point) {
		// 进来先标记为已读
		visited[rows] = true;
		// 打印节点头
		System.out.print(rows + " ");
		// 遍历该行数据
		point = table[rows];
		while (point != null) {
			// 这里拆开判断,防止已经访问的数据后面还有没有访问的数据
			if (visited[point.p] == false) {
				BFS(point.p, table[point.p]);
			}
			point = point.netxpoint;// 往后递归就好了
		}
	}

	private static void addLine(TablePoint pointA, TablePoint pointB, int A, int B) {
		table[A] = addLine(pointA, A, B);
		table[B] = addLine(pointB, B, A);
	}

	private static TablePoint addLine(TablePoint point, int a, int b) {
		if (point == null) {
			point = new TablePoint(b);
		} else if (point.netxpoint == null) {
			point.netxpoint = new TablePoint(b);
		} else {
			addLine(point.netxpoint, a, b);
		}
		return point;
	}
}
