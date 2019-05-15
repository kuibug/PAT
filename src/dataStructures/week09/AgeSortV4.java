package dataStructures.week09;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
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
