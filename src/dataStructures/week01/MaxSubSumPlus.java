package dataStructures.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * Class for buffered reading int and double values
 * 	
 */
 class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream 调用此方法为InputStream初始化reader*/
	 static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	 static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			// TODO add check for eof if necessary
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	 static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	 static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
/*
 * 给定数组
 * 求子串最大和，并打印出子串首位的值
 * 
 */
public class MaxSubSumPlus {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		Reader.init(System.in);
		// 确定数组大小
		int size = Reader.nextInt();
		int[] arr = new int[size];

		// 确定数组元素值
		for (int i = 0; i < size; i++) {
			arr[i] = Reader.nextInt();
		}
		long maxSum = 0, thisSum = 0;
		int start = arr[0], tem = arr[0], end = arr[size - 1];

		for (int i = 0; i < size; i++) {
			// 从0开始加和
			thisSum += arr[i];

			// 若结果出现负值重置结果，往下一个继续计算
			if (thisSum < 0) {
				thisSum = 0;
				if (i != size - 1)
					tem = arr[i + 1]; // 记录运算子串的第一个值

			}

			// 如果当前值大于最大值，更新，并记录子串的首尾
			if (thisSum > maxSum) {
				maxSum = thisSum;
				start = tem;
				end = arr[i];
			}
		}
		if ((start == -1 && end == -1) || (start == 0 && end == 0)) {
			System.out.println(maxSum + " " + 0 + " " + (size-1));
		} else {
			System.out.println(maxSum + " " + start + " " + end);
		}
	}

}
