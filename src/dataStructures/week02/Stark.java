package dataStructures.week02;

import java.util.Scanner;
import java.util.Stack;

public class Stark {

	// 判断序列是否可能为堆栈弹出序列
	public static boolean check(int[] arr, int M,int N) {
		int in = 1;	//初始化入栈元素右面使用++来完成下一个元素入栈
		int out = 0; // 弹出的个数
		Stack<Integer> s = new Stack<Integer>();
		
		//如果弹出的数量等于N那么判断结束
		while (out != N) {	
			/*
			 * 若是空栈，必须压栈不然没有办法弹栈
			 * 若栈顶元素小于要输出元素，继续压栈
			 * 若栈满了即大于M，不许压栈
			 */
			while (s.empty() || s.peek() < arr[out] && s.size() < M) {
				s.push(in++);
			}
			//若栈顶元素和要输出地元素相同，弹栈
			if (s.peek() == arr[out]) {
				s.pop();
				out++;
			} else
			//若不满足上面的条件证明该栈无法完成操作
			{
				return false;
			}
		}
		return true;
	}

	// 读取数据
	public static int[] read(Scanner sc, int n) {

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//读取第一行限制
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();

		//读取数据
		int[][] arr = new int[K][N];
		for (int i = 0; i < K; i++) {
			arr[i] = read(sc, N);
		}

		//循环判断
		for (int i = 0; i < K; i++) {
			String result = check(arr[i], M,N) ? "YES" : "NO";
			System.out.print(result);
			//最后一行不换行
			if (i < K - 1) {
				System.out.println();
			}

		}
	}
}