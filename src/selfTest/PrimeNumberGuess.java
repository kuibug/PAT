package selfTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 定义dn = Pn+1 - Pn,其中Pi是第i个素数。显然d1 =1，且对于i>1有dn是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
 * 现给定任意正整数N(<10^5)，请计算不超过N的满足猜想的素数对的个数
 *
 * 输入格式:
 * 输入在一行给出正整数N。
 *
 * 输出格式:
 * 在一行中输出不超过N的满足猜想的素数对的个数。
 *
 * 分析：
 * 1.是素数
 * 2.dn是偶数
 * 3.满足dn = Pn+1 - Pn
 */
public class PrimeNumberGuess {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        //先算出所有素数存在数组中
        ArrayList<Integer> p = eachPrime(N);
        System.out.println(p);
        //输出所有Pn+1 - Pn = 2
        int count = 0;
        for (int i = 0; i < p.size() - 1; i++) {
            int a = p.get(i + 1) - p.get(i);
            if (a == 2)
                count++;
        }
        System.out.println(count);
    }

    /**
     * 计算小于n的所有素数
     *
     * @param n n
     * @return List<Integer>
     */
    private static ArrayList<Integer> eachPrime(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            int max = (int) Math.sqrt(i)+1;
            for (int j = 2; j < max; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(i);
        }
        return list;
    }
}
/*
 算法复杂度分析：
     时间复杂度：
     空间复杂度：
 算法总结：
 */
