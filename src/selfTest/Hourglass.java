package selfTest;

import java.io.IOException;
import java.util.Arrays;

import utils.Reader;

/***
 * 题目： 把给定的符号打印成沙漏的形状
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 *
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 输入格式: 输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。
 *
 * 输出格式: 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 *
 * 规律： 1 1+3*2 1+3*2+5*2 1+3*2+5*2+7*2
 * 
 * 思路一：使用循环判断该数是否小于于目前标志点，不小于往前走，
 */
public class Hourglass {

	public static void main(String[] args) throws IOException {
//    	
//        int sum = 1;
//        for (int i = 3; i < 46; i++) {
//            if (i % 2 != 0) {
//                sum += i * 2;
//                System.out.println(sum);
//            }
//
//        }
		// 先接收数字和符号
		Reader.init(System.in);
		int N = Reader.nextInt();
		String symbol = Reader.next();

		// 判断应该画多少行
		int[] line = calLine(N);
		System.out.println("out:line" + Arrays.toString(line));

		// 打印图形
		printHourglass(line[0], symbol);

	}

	private static void printHourglass(int line, String symbol) {

		// 先打印上沙漏
		for (int i = line; i > 0; i--) {
			int length = line;
		}

		// 再打印下沙漏
		int len = 3;
		for (int i = 1; i < line; i++) {
			for (int j = len; j > 0; j--) {
				System.out.print(symbol);
				len += 2;
			}
			System.out.println();
		}
	}

	private static int[] calLine(int n) {
		int line = 0;

		// 特殊处理第一行
		if (n > 0) {
			n--;
			line++;
		}

		// 使用递减的思维，直到减完未知
		int i = 3;
		while (n > i * 2) {
			n -= i * 2;
			line++;
			i += 2;
		}
		return new int[] { line, n };
	}
}
