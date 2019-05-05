package javase.week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {
	// 该预置序列最大支持10001的数满足快速希尔排序的要求
	final static int[] SHELL_SEQUS = { 5000, 2500, 1250, 625, 312, 156, 78, 39, 19, 9, 4, 2, 1, 0 };
	final static int[] HIBBARD_SEQUS = { 8191, 4095, 2047, 1023, 255, 127, 31, 15, 7, 3, 1, 0 };
	final static int[] SEDGEWICK_SEQUS = { 8929, 2500, 3905, 2161, 929, 209, 109, 41, 19, 5, 1, 0 };

	public static void main(String[] args) {
		int[] arr = randomArray(10, 100);
		int[] tem = Arrays.copyOf(arr, 10);
		System.out.println("原数组：" + Arrays.toString(arr));

		arr = Arrays.copyOf(tem, 10);
		int count = bubble_sort(arr);
		System.out.println("冒泡经历" + count + "次交换");

		arr = Arrays.copyOf(tem, 10);
		count = insertion_sort(arr);
		System.out.println("插入经历" + count + "次交换");

		arr = Arrays.copyOf(tem, 10);
		count = shell_sort(arr, SEDGEWICK_SEQUS);
		System.out.println("希尔经历" + count + "次交换");

		// Shell_sequ(10001);
		// Hibbard_sequ(10001);
		// Sedgewick_sequ(10001);
	}

	/**
	 * 创建一个指定长的数组
	 * 
	 * @param len 数组长度
	 * @param max 数组最大值
	 * @return
	 */
	private static int[] randomArray(int len, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			int tem = (int) (Math.random() * max);
			arr[i] = tem;
		}
		return arr;
	}

	/**
	 * 希尔排序 -完整版
	 * 
	 * @param arr
	 * @param sequ
	 * @return
	 */
	private static int shell_sort(int[] arr, int[] sequence) {
		int len = arr.length;
		int count = 0;

		int si_index; // 递增序列的索引
		int si_data; // 实际排序时候的递增序列的值

		// 初始的增量sequence[Si]不能超过待排序列长度
		for (si_index = 0; sequence[si_index] >= len; si_index++)
			;

		for (si_data = sequence[si_index]; si_data > 0; si_data = sequence[++si_index]) {
			// 插入排序
			int P, i, Tmp;
			for (P = si_data; P < len; P++) {
				Tmp = arr[P];
				for (i = P; i >= si_data && arr[i - si_data] > Tmp; i -= si_data) {
					arr[i] = arr[i - si_data];
					count++;
				}
				arr[i] = Tmp;
			}
		}

		System.out.println("希尔排序：" + Arrays.toString(arr));
		return count;
	}

	/**
	 * 插入排序
	 * 
	 * @param arr
	 * @return
	 */
	private static int insertion_sort(int[] arr) {
		int len = arr.length;
		int count = 0;
		for (int i = 1; i < len; i++) {
			int tem = arr[i];
			int j;
			// 先把空位挪够
			for (j = i; j > 0 && arr[j - 1] > tem; j--) {
				arr[j] = arr[j - 1];
				count++;
			}
			// 插入
			arr[j] = tem;
		}
		System.out.println("插入排序：" + Arrays.toString(arr));
		return count;
	}

	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 * @return count 排序次数
	 */
	private static int bubble_sort(int[] arr) {
		int len = arr.length;
		int count = 0;
		for (int i = len; i >= 0; i--) {
			boolean flag = true;
			for (int j = 1; j < i; j++) {
				if (arr[j - 1] > arr[j]) {
					int tem = arr[j]; // 先把arr[j]空出来
					arr[j] = arr[j - 1];// 把大的数放在后面
					arr[j - 1] = tem;// 再把小的数放回去

					flag = false;
					count++;
				}
			}
			// 当检测到全部排完序后就不要再扫描了
			if (flag)
				break;
		}
		System.out.println("冒泡排序：" + Arrays.toString(arr));
		return count;
	}

	/************************************************************
	 * 后面是产生序列的算法，无用，但是保留**********************************
	 ***********************************************************/

	/**
	 * 产生Sedgewick_sequ算法，无用，但是保留
	 * 
	 * @param len
	 * @return
	 */
	static int[] Sedgewick_sequ(int len) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// TODO 待定
		int i = 1;
		int result = 0;
		while (result < len) {
			result = (int) Math.pow(4, i) - 3 * (int) Math.pow(2, i) + 1;
			list.add(result);
			result = 9 * (int) Math.pow(4, i) - 9 * (int) Math.pow(2, i) + 1;
			list.add(result);
			i++;
		}
		Collections.sort(list);
		int[] sequ = listToSequ(list);
		System.out.println("Sedgewick_sequ" + list);
		return sequ;
	}

	/**
	 * 产生Hibbard_sequ算法，无用，但是保留
	 * 
	 * @param len
	 * @return
	 */
	static int[] Hibbard_sequ(int len) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		// TODO 待定
		int i = 1;
		int result = 0;
		while (len > result) {
			result = (int) Math.pow(2, i) - 1;
			list.add(len);
			i++;
		}
		System.out.println("Hibbard_sequ" + list);
		int[] sequ = listToSequ(list);
		return sequ;
	}

	/**
	 * 产生一个Shell原始序列算法，无用，但是保留
	 * 
	 * @param i
	 * @return
	 */
	static int[] Shell_sequ(int len) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (len > 0) {
			len /= 2;
			list.add(len);
		}
		// 将list转为数组
		int[] sequ = listToSequ(list);
		System.out.println(Arrays.toString(sequ));

		return sequ;
	}

	/**
	 * 将list序列转为int数组算法，无用，但是保留
	 * 
	 * @param list
	 * @return
	 */
	public static int[] listToSequ(ArrayList<Integer> list) {
		int size = list.size();
		int[] sequ = new int[size];
		for (int i = 0; i < size; i++) {
			sequ[i] = list.get(i);
		}
		return sequ;
	}

}
