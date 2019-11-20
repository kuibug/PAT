package selfTest;

import java.util.Scanner;
/***
 * 题目： 把给定的符号打印成沙漏的形状
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 *
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 输入格式: 输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。
 *
 * 输出格式: 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 *
 * 规律： 1 1+3*2 1+3*2+5*2 1+3*2+5*2+7*2
 *
 * 思路：
 * 1.先算出第一行有多少符号
 * 2.计算出剩余数量
 * 3.分上下绘制两个倒三角
 */
public class Hourglass {

    public static void main(String[] args) {
        // 先接收数字和符号
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String symbol = sc.nextLine();
        sc.close();

        // 求出第一行应该有几个符号
        int[] line = maxLine(N);

        // 打印图形
        printHourglass(line[1], symbol);

        //输出最后剩余的数量
        System.out.println(line[0]);
    }

    /**
     * 打印沙漏
     *
     * @param max    最大行符号数量
     * @param symbol 打印符号
     */
    private static void printHourglass(int max, String symbol) {
        int space = 0;//前面的空格数量
        int num = max;//符号数量

        // 先打印上沙漏
        while (num >= 1) {
            //绘制
            print(space, num, symbol);

            //更新上面的数量
            num -= 2;
            space++;
        }

        //手动刷新一下
        num += 2;
        space--;

        // 再打印下沙漏
        while (space > 0) {
            //更新数量
            num += 2;
            space--;

            //绘制
            print(space, num, symbol);
        }

    }

    /**
     * 上下沙漏打印复用
     *
     * @param space  空格数量
     * @param num    符号数量
     * @param symbol 符号
     */
    private static void print(int space, int num, String symbol) {
        //打印空格
        int tmp = space;
        while (tmp > 0) {
            System.out.print(" ");
            tmp--;
        }
        //打印符号
        tmp = num;
        while (tmp > 0) {
            System.out.print(symbol);
            tmp--;
        }
        //换行
        System.out.println();
    }

    /**
     * 计算最大行的数量
     *
     * @param n 输入值
     * @return {单行最大数量, 剩余数量}
     */
    private static int[] maxLine(int n) {
        int max = 0;

        // 特殊处理第一行
        if (n > 0) {
            n--;
            max++;
        }

        // 使用递减的思维，直到减完未知
        int i = 3;
        while (n > i * 2) {
            n -= i * 2;
            max = i;
            i += 2;
        }
        return new int[]{n, max};
    }
}
/*
算法复杂度分析：
    时间复杂度：O(n)
        maxLine(): O(n^1/2)
        printHourglass():O(n^1/2)*O(n^1/2) = O(n)
    空间复杂度：O(1)
算法总结：实实在在的规律题，按照规律编写即可
    注意寻找最方便打印的规律
 */