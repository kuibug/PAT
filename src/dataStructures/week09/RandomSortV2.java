package dataStructures.week09;

import java.io.IOException;
import java.util.Arrays;

/**
 * 冒泡法
 * 
 * @author craftsman
 * @date 2019年5月23日
 */
public class RandomSortV2 {
	public static void main(String[] args) throws IOException {
		//Reader.init(System.in);
		//int size = Reader.nextInt();
		//int data[] = new int[size];
		//for (int i = 0; i < size; i++) {
		//	data[i] = Reader.nextInt();
		//}
		int size = 1000000;
		
		long start = System.currentTimeMillis();
		int data[] = AgeSort.random(size);
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (data[j] > data[j + 1]) {
					int tem = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tem;
				}
			}
		}
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
 0	 答案正确	 79 ms 	9452 KB 
 1	 答案正确	 77 ms	9392 KB 
 2	 答案正确 	108 ms 	9976 KB 
 3	 答案正确 	395 ms  12560 KB 
 4	 运行超时 	-- 		0 KB 
 5	 答案正确	3535 ms 28700 KB 
 6	 答案正确 	9431 ms 29332 KB 
 7	 运行超时 	-- 		0 KB 
 8	 运行超时 	-- 		0 KB
 本机运行10^5  13.2s（13200ms……）放大100倍
 */
