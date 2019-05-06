package dataStructures.week09;

import java.io.IOException;
import dataStructures.utils.Reader;

public class AgeSortV4 {
	public static void main(String[] args) throws IOException {

		int[] age = new int[51];
		
		Reader.init(System.in);
		int size = Reader.nextInt();
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			int data = Reader.nextInt();
			age[data]++;
		}

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

}
