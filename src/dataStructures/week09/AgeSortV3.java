package dataStructures.week09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AgeSortV3 {
	public static void main(String[] args) throws Exception{

		int[] age = new int[51];

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(sc.readLine());
		long start = System.currentTimeMillis();
		String data = sc.readLine();
		sc.close();
		String[] D= data.split("\\s");
		for (int i = 0; i < size; i++) {
			int index = Integer.parseInt(D[i]);
			age[index]++;
		}

		// int[] arr = zeroArray();
		// long start = System.currentTimeMillis();

		// for (int i = 0; i < 100000; i++) {
		// int tem = arr[i];
		// age[tem]++;
		// }

		// System.out.println(Arrays.toString(age));

		int count = 0;
		for (int i = 0; i < 51; i++) {
			if (age[i] != 0 && count <= 100000) {
				System.out.println(i + ":" + age[i]);
				count += age[i];
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}

	static int[] random() {
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		return arr;
	}

	static int[] zeroArray() {
		return new int[100000];
	}
/**
	0	sample 有人数为0的段	答案正确	83 ms	9460 KB
	1	最大N，工龄全0			答案正确	335 ms	20404 KB
	2	最大N，按递减顺序给出		答案正确	327 ms	21032 KB
 */
}
