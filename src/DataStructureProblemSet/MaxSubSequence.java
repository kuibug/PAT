package DataStructureProblemSet;

import utils.IOUtil;

import java.io.IOException;

/**
 * 给定K个整数组成的序列{ N​1​​ , N​2​​ , ..., N​K}，“连续子列”被定义为{ N​i​​ , N​i+1​​ , ..., N​j​​  }，其中 1≤i≤j≤K。
 * “最大子列和”则被定义为所有连续子列元素的和中最大者。例如给定序列{ -2, 11, -4, 13, -5, -2 }，
 * 其连续子列{ 11, -4, 13 }有最大的和20。现要求你编写程序，计算给定整数序列的最大子列和。
 *
 * 本题旨在测试各种不同的算法在各种数据情况下的表现。各组测试数据特点如下：
 *
 * 数据1：与样例等价，测试基本正确性；
 * 数据2：102个随机整数；
 * 数据3：103个随机整数；
 * 数据4：104个随机整数；
 * 数据5：105个随机整数；
 * 输入格式:
 * 输入第1行给出正整数K (≤100000)；第2行给出K个整数，其间以空格分隔。
 *
 * 输出格式:
 * 在一行中输出最大子列和。如果序列中所有整数皆为负数，则输出0。
 *
 * 输入样例:
 * 6
 * -2 11 -4 13 -5 -2
 * 输出样例:
 * 20
 *
 * 思路：遍历求和，和为0时重置，保存最大值，起始位置，结束位置
 * 输入量级较大，使用工具类
 */
public class MaxSubSequence {
    public static void main(String[] args) throws IOException {
        //initial
        int start = 0, end = 0, sum = 0;
        IOUtil.init(System.in, System.out);
        //接收
        int size = IOUtil.nextInt();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = IOUtil.nextInt();
        }
        //遍历求和
        int tmpSum = 0;
        for (int i = 0; i < size; i++) {
            tmpSum += data[i];
            //若和大更新，和，尾指针
            if (tmpSum > sum) {
                sum = tmpSum;
                end = i;
            }
            //超出-1重置序列，更新头尾指针
            else if (tmpSum < 0) {
                tmpSum = 0;
                start = i + 1;
                end = start;
            }
        }
        System.out.println(sum);
    }
}
