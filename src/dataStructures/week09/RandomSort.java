package dataStructures.week09;

import java.util.Arrays;

/**
 * 使用系统类库
 * @author craftsman
 * @date 2019年5月23日
 */
public class RandomSort {
	public static void main(String[] args) throws Exception {
		//Reader.init(System.in);
		//int size = Reader.nextInt();
		//int data[] = new int[size];
		//for (int i = 0; i < size; i++) {
		//	data[i] = Reader.nextInt();
		//}
		int size = 100000;
		long start = System.currentTimeMillis();
		int data[] = AgeSort.random(size);
		Arrays.sort(data);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		print(data, size);
	}

	private static void print(int[] data, int size) {
		StringBuilder str = new StringBuilder();
		str.append(data[0]);
		for (int i = 1; i < size; i++) {
			str.append(" ");
			str.append(data[i]);
		}
		System.out.println(str);
	}
}
/**
0	答案正确	67毫秒	9284 KB
1	答案正确	93毫秒	9360 KB
2	答案正确	83毫秒	9832 KB
3	答案正确	132毫秒	12760 KB
4	答案正确	428毫秒	28216 KB
5	答案正确	274毫秒	28876 KB
6	答案正确	375毫秒	28856 KB
7	答案正确	336毫秒	29384 KB
8	答案正确	324毫秒	25888 KB
本机运行10^5随机16ms
*/