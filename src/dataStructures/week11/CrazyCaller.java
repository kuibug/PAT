package dataStructures.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Class for buffered reading int and double values 缓冲读取int和double值的类
 */
class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/**
	 * call this method to initialize reader for InputStream
	 * 调用此方法为InputStream初始化reader
	 */
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

class Record {
	public String phone;
	public int count;

	public Record(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "record [" + phone + ":" + count + "]";
	}

}

public class CrazyCaller {

	static Record[] list;

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int size = Reader.nextInt();
		// size = size >> 1;
		size <<= 1;
		// 建立一个数组来储存童话记录
		list = new Record[size << 1];
		// 循环读取通话记录(数据量是size的两倍)
		for (int i = 0; i < size; i++) {
			String phone = Reader.next();
			//先查找在不在
			boolean exist = calIndex(phone);
			//在count++
			if(exist) {
				
			}else {
			//不在插入
				
			}
			
			//查找最大值中的最小值，和总数
			
		}
	}

	private static boolean calIndex(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
