package javase.week04;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		int sum = 0;
		int count = 0;
		int temp = 2;
		//先计算从0到m的素数
		while (count < m) {
			boolean flag = isPrime(temp);
			if (flag) {
				arr[count] = temp;
				count++;
			}
			temp++;
		}
		//再取出n-m个进行加和
		while (n <= m) {
			//当有0时特殊处理
			if(n == 0) {
				n++;
				continue;
			}
			sum += arr[n - 1];
			n++;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
		sc.close();
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}