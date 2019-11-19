package selfTest;

import utils.Reader;

import java.io.IOException;

/**
 * 一个数组A中存有N（>0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（≥0）个位置，（最后M个数循环移至最前面的M个位置）。
 * 如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 * <p>
 * 输入格式:
 * 每个输入包含一个测试用例，第1行输入N（1≤N≤100）和M（≥0）；第2行输入N个整数，之间用空格分隔。
 * <p>
 * 输出格式:
 * 在一行中输出循环右移M位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。
 * <p>
 * 题目解读：
 * 1.限制在O(1)的控件复杂度下尽可能的达到时间最优
 * 2.输入规模很大，所以不能使用Scanner
 */
public class ArrayRightShift {
    public static void main(String[] args) throws IOException {
        //接收参数
        Reader.init(System.in);

        int N = Reader.nextInt();//数组大小
        int M = Reader.nextInt();//右移大小
        M = M % N;//这里防止M比N大后面GG

        //存取数组
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Reader.nextInt();
        }

        //逆序前M个
        exchange(arr, 0, N - M - 1);
        //逆序后半部分
        exchange(arr, N - M, N - 1);
        //整体逆序
        exchange(arr, 0, N - 1);

        //输出结果
        for (int i = 0; i < N; i++) {
            if (i == 0)
                System.out.print(arr[i]);
            else
                System.out.print(" " + arr[i]);
        }
    }

    private static void exchange(int[] arr, int start, int end) {
        int half = (end - start + 1) / 2;
        for (int i = 0; i < half; i++) {
            int tmp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = tmp;
        }
    }
}
/*
算法分析：
    最简单粗暴:保存末尾值，循环M次依次右归。时间复杂度O(n^2)……
    优化：分段逆序，前后分别逆序，再整体逆序正好是我们想要的结果，时间复杂度O(n)

 */