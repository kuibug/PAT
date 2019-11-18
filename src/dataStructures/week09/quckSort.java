package dataStructures.week09;

import java.util.Arrays;

public class quckSort {
	public static void main(String[] args) {
		int arr[] = {49, 38, 65, 97, 76, 13, 27};
		quickSort(arr,0,6);
		//System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			// 生成一个随机数
			double random = Math.random();
			// 在L至R位置随机选取一个数与最右边的数交换
			System.out.println(arr[L + (int) (random * (R - L + 1))] + "……" +arr[R]);
			swap(arr, L + (int) (random * (R - L + 1)), R);
			// 此数组长度永远为2,p[0]为等于区的左边界，p[1]为等于区的右边界
			int[] p = partition(arr, L, R);
			// 将分出来的小于区重复上面的动作
			
			System.out.println(Arrays.toString(arr));

			
			quickSort(arr, L, p[0] - 1);
			// 将分出来的大于区重复上面的动作
			quickSort(arr, p[1] + 1, R);
		}

	}

	public static int[] partition(int[] arr, int L, int R) {
		// 声明一个小于区的索引
		int less = L - 1;
		// 声明一个大于区的索引
		int more = R;
		// 声明一个起始索引指针
		int index = L;
		// 划分原则：
		/*
		 * 1 如果arr(index)<arr(R) 1.1 拿index位置的数与小于区右边第一个数进行交换 1.2 小于区向右扩大一位 1.3
		 * index索引向右移动一位 2 如果arr(index)==arr(R) 2.1 index索引向右移动一位 3 如果arr(index)>arr(R)
		 * 3.1 拿index位置的数与大于区左边第一个数进行交换 3.2 大于区向左扩大一位 3.3 index索引位置不动
		 */
		while (index < more) {
			if (arr[index] < arr[R]) {
				// 一行代码完成划分原则的1.1, 1.2, 1.3功能
				swap(arr, index++, ++less);
			} else if (arr[index] == arr[R]) {
				index++;
			} else {
				// 一行代码完成划分原则的3.1, 3.2, 3.3功能
				swap(arr, index, --more);
			}
		}
		// 如果index索引与more相遇，则退出循环，并且R位置数与more位置数交换
		swap(arr, more, R);
		// 用来记录等于区的左边界和右边界对应的索引
		return new int[] { less + 1, more };
	}

	// 将数组中索引i和j的数进行交换
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
