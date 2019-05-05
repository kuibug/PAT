package dataStructures.week05;

import java.util.Scanner;

class CollNode {
	int data;// 数据
	int root;// 集合名字，默认以-data
	int size;// 默认1

	public CollNode(int data) {
		this(data, -data, 1);
	}

	public CollNode(int data, int coll, int size) {
		this.data = data;
		this.root = coll;
		this.size = size;
	}

	@Override
	public String toString() {
		return "CollNode [data=" + data + ", root=" + root + ", size=" + size + "]";
	}

}

public class FileTransferV2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 新建一个数组存储集合
		int size = sc.nextInt();
		CollNode[] coll = new CollNode[size + 1];
		// 初始化容量
		for (int i = 1; i <= size; i++) {
			coll[i] = new CollNode(i);
		}
		String opt;
		// 接收操作符
		do {
			opt = sc.next();

			switch (opt) {
			case "C":
				check(coll, sc);
				break;
			case "I":
				connect(coll, sc);
				break;
			case "S":
				stop(coll, size);
				break;
			}
		} while (!opt.equals("S"));
	}

	private static void stop(CollNode[] coll, int size) {
		int count = 0;
		for (int i = 1; i <= size; i++) {
			if (coll[i].root < 0) {
				count++;
			}
		}
		if (count == 1) {
			System.out.println("The network is connected.");
		} else {
			System.out.println("There are " + count + " components.");
		}
	}

	private static void connect(CollNode[] coll, Scanner sc) {
		int data1 = sc.nextInt();
		int data2 = sc.nextInt();
		CollNode root1 = find(coll, data1);
		CollNode root2 = find(coll, data2);
		if (root1 == root2) {
			return;
		}
		if (root1.size < root2.size) {
			coll[root1.data].root = coll[root2.data].data;
			//root1.root = root2.data;
			root2.size++;
		}else {
			coll[root2.data].root = coll[root1.data].data;
			//root1.root = root2.data;
			coll[root1.data].size++;
		}
	}

	private static CollNode find(CollNode[] coll, int data) {
		// 查集合名字
		while (data > 0) {
			data = coll[data].root;
		}
		return coll[-data];
	}

	private static void check(CollNode[] coll, Scanner sc) {
		int data1 = sc.nextInt();
		int data2 = sc.nextInt();
		CollNode root1 = find(coll, data1);
		CollNode root2 = find(coll, data2);
		if (root1.root == root2.root) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
