package javase.week07;

import java.util.Scanner;

public class Resolve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n;// 做一个为备份，输出时候使用
		int flag = 0;// 质因数的个数

		// 将质因数存到一个数组里面
		int[] str = new int[100];
		for (int i = 2; i <= n; i++) {
			// 将合数从最小的指数开始÷，直到它本身
			if (n % i == 0) {
				str[flag] = i;
				flag++;
				n = n / i;
				i--;// 控制i递增,防止出现多个相同的质因数
			}
		}
		
		//输出
		if (flag < 2)
			System.out.println(m + "=" + m);
		else {
			System.out.print(m + "=" + str[0]);
			for (int k = 1; k < flag; k++) {
				System.out.print("x" + str[k]);
			}
		}
		sc.close();
	}
}