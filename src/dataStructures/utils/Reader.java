package dataStructures.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * Class for buffered reading int and double values
 * 	缓冲读取int和double值的类
 */
public class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream 调用此方法为InputStream初始化reader*/
	public static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	public static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			// TODO add check for eof if necessary
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}