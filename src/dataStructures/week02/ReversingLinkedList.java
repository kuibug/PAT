package dataStructures.week02;

import java.util.Scanner;

class ArrayNode {
	int data;
	int next;

	public ArrayNode() {
	}
}

public class ReversingLinkedList {
	/**
	 * 改变输出数字格式 在不够五位数的前面补0
	 */
	public static String change(int val) {
		if (val == -1) {
			return val + "";
		}
		String s = "00000";
		String first = val + "";
		int length = first.length();
		s = s.substring(length) + first;
		return s;
	}

	/**
	 * 打印数组中的静态链表
	 */
	public static int display(int head, ArrayNode[] arr, int N) {
		int num = 0;
		while (head != -1) {
			String head1 = change(head);
			String next1 = change(arr[head].next);
			System.out.println(head1 + " " + arr[head].data + " " + next1);
			head = arr[head].next;
			num++;
		}
		return num;
	}

	// 返回数组中有效的节点个数
	public static int number(int head, ArrayNode arr[]) {
		int num = 0;
		while (head != -1) {
			head = arr[head].next;
			num++;
		}
		return num;
	}

	// 以K为分界线对单向链表进行逆转
	public static int reverse(int head, ArrayNode[] arr, int N, int K) {
		int num = 1;
		int reverse = 1;
		int remain = head;
		int old_head = arr[head].next;
		int new_head = head;
		int temp;
		int remain2 = head;
		while (reverse <= N / K) {
			while (num < K) {
				temp = arr[old_head].next;
				int a = arr[old_head].data;

				// 注意这里需要给数组该位置创建一个结点，不能直接用“arr[old_head].next= new_head”会影响old_head的值；
				arr[old_head] = new ArrayNode();
				arr[old_head].data = a;
				// 将链表方向逆转
				arr[old_head].next = new_head;
				new_head = old_head;
				old_head = temp;
				num++;
			}
			// 第一次逆转时，找到头节点，并将逆转之后的节点与还没逆转的节点相连
			if (reverse == 1) {
				head = new_head;
				arr[remain].next = old_head;
			} else
			// 第i(i>1)次的逆转，都直接把逆转之后的节点与第i+1次逆转之后的节点连接起来
			{
				arr[remain].next = new_head;
				remain = remain2;
			}
			// 当链表逆转结束时，将尾节点的下一个指向-1
			if (old_head == -1) {
				arr[remain2].next = -1;
			} else
			// 如果一轮逆转之后链表还没结束，则还需要再进行一轮逆转，所以把所有的节点都往后移一位
			{
				new_head = old_head;
				old_head = arr[old_head].next;
				remain2 = new_head;
			}
			num = 1;
			reverse++;
		}
		return head;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 读取数据存入数组
			ArrayNode[] array = new ArrayNode[100000];

			int head = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			int current = 0;
			int a = head;
			for (int i = 0; i < N; i++) {
				current = sc.nextInt();
				array[current] = new ArrayNode();
				array[current].data = sc.nextInt();
				array[current].next = sc.nextInt();
			}

			// 返回数组中有效的节点个数，为了防止数组中有多余的节点
			N = number(head, array);

			// 逆转单向链表
			if (K > 1) {
				a = reverse(head, array, N, K);
			}
			// 打印逆转后的链表
			display(a, array, N);
		}

		sc.close();
	}

}