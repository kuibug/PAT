package selfTest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Notice that the number 123456789 is a 9-digit number consisting exactly the numbers from 1 to 9, with no duplication.
 * Double it we will obtain 246913578, which happens to be another 9-digit number consisting exactly the numbers from 1
 * to 9, only in a different permutation. Check to see the result if we double it again!
 *
 * Now you are suppose to check if there are more numbers with this property. That is, double a given number with k
 * digits, you are to tell if the resulting number consists of only a permutation of the digits in the original number.
 *
 * @InputSpecification: 输入示例
 * Each input contains one test case. Each case contains one positive integer with no more than 20 digits.
 * @OutputSpecification: 输出示例
 * For each test case, first print in a line "Yes" if doubling the input number gives a number that consists of only a
 * permutation of the digits in the original number, or "No" if not. Then in the next line, print the doubled number.
 *
 * 翻译：给一串1-9无重复的数字，Double之后仍然得到一串1-9无重复的数字，验证更多正整数以下是否成立
 * 输入：输入小于20个正整数
 * 输出：是否成立 + double之后的数字
 *
 * 分析：400ms + 64MB内存，果断空间换时间
 * 输入数字计数，double之后递减，出现0就不yes，当然长度不一样当然不yes
 * 输入规模不大，但是20位已经超出long值了，所以这个要靠自己来计算，虽然我大Java有BigDecimal神器，但是还是要理解其算法
 */
public class HaveFunWithNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        //计算
        BigInteger sqe = new BigInteger(str);
        String str_double = sqe.add(sqe).toString();

        //判断
        boolean flag = isTrue(str, str_double);
        if (flag)
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println(str_double);
    }

    private static boolean isTrue(String str, String str_double) {
        int old_len = str.length();
        int new_len = str_double.length();
        byte[] ints = new byte[10];
        boolean result = true;

        //长度不等直接退出
        if (old_len != new_len) {
            return false;
        }

        //先计数
        for (int i = 0; i < old_len; i++) {
            byte b = (byte) (str.charAt(i) - '0');
            ints[b]++;
        }
        //在递减
        for (int i = 0; i < new_len; i++) {
            byte b = (byte) (str_double.charAt(i) - '0');
            ints[b]--;

            //这行是为了加速高度重复的数串
            if (ints[b] < 0) return false;
        }
        for (byte anInt : ints) {
            if (anInt != 0) {
                result = false;
                break;
            }
        }
        System.out.println(Arrays.toString(ints));
        //这里用多个出口纯属为了效率考虑
        return result;
    }
}
