package dataStructures.week05;

import java.util.Scanner;

/**
 * 检查编码是否是最优编码 1.输入样样例 2.根据输入的样例建立哈夫曼树进行检查
 * 
 * @author craftsman
 * @date 2019年5月4日
 */
class coder {
	String str;
	String code;

	public coder(String str, String code) {
		super();
		this.str = str;
		this.code = code;
	}
}

public class HumanCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int codeNum = sc.nextInt(); // 要编码的字符数量
		String[] data = new String[codeNum];// 字符数组
		int[] rate = new int[codeNum];// 字符频率数组

		// 接收字符样本
		for (int i = 0; i < codeNum; i++) {
			data[i] = sc.next();
			rate[i] = sc.nextInt();
		}

		// 接收编码样本
		int checkSize = sc.nextInt();// 要检查的样本数量
		coder[] input = checkInput(sc, checkSize, codeNum);

		//检输入样本
		for(int i = 0;i<checkSize;i++) {
			check(input[i]);
		}
	}

	/**
	 * 检查样本是否符合最优编码
	 * @param coder
	 */
	private static void check(coder coder) {
		// TODO Auto-generated method stub
	}

	/**
	 * 用来输入样本
	 * @param sc
	 * @param checkSize
	 * @param codeNum
	 * @return
	 */
	public static coder[] checkInput(Scanner sc, int checkSize, int codeNum) {
		coder[] input = new coder[checkSize];
		for (int i = 0; i < codeNum; i++) {
			String str = sc.next();
			String code = sc.next();
			input[i] = new coder(str, code);
		}
		return input;
	}
}
