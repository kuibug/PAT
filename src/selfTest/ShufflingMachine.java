package selfTest;

import utils.Reader;

import java.io.IOException;
import java.util.Arrays;

/**
 * Shuffling is a procedure used to randomize a deck of playing cards. Because standard shuffling techniques are seen as
 * weak, and in order to avoid "inside jobs" where employees collaborate with gamblers by performing inadequate
 * shuffles, many casinos employ automatic shuffling machines. Your task is to simulate a shuffling machine.
 *
 * The machine shuffles a deck of 54 cards according to a given random order and repeats for a given number of times. It
 * is assumed that the initial status of a card deck is in the following order:
 * S1, S2, ..., S13,
 * H1, H2, ..., H13,
 * C1, C2, ..., C13,
 * D1, D2, ..., D13,
 * J1, J2
 *
 * Input Specification:
 * Each input file contains one test case. For each case, the first line contains a positive integer K (≤20) which is
 * the number of repeat times. Then the next line contains the given order. All the numbers in a line are separated by a
 * space.
 *
 * Output Specification:
 * For each test case, print the shuffling results in one line. All the cards are separated by a space, and there must
 * be no extra space at the end of the line.
 *
 * 翻译：balabala~ (赌徒之言)
 *
 * 任务：
 * 赌场老板：我要你做一个自动洗牌机
 * 给一副新牌，给一个数组，将数字当前位置的牌移动到值对应的位置，对了多洗几次(不超20次，多了客人看的蛋疼)
 * 400ms内完成
 * 64MB 的桌面
 * 16KB 的草稿纸
 * 分析：
 * 输入规模：54 + 1 ，花200ms给Scanner的话太冤了，上Reader
 * 思路：乍一看完全没想法，先按照要求来把，时间复杂度为O(n^2),在洗牌系数少的情况下接近O(n)还可以
 */
public class ShufflingMachine {
    /**
     * 扑克的序列，原始值是新牌排列(S H C D J, 1 ~ 13)
     */
    static String[] poker = {
            "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13",
            "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13",
            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13",
            "J1", "J2"
    };

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        //先接收值
        int times = Reader.nextInt();//洗牌次数
        int[] sequ = new int[54];//洗牌序列

        for (int i = 0; i < 54; i++) {
            sequ[i] = Reader.nextInt();
        }

        //洗牌
        Shuffling(sequ, times);

        //码牌(滑稽)
        System.out.println(Arrays.toString(poker));
    }

    /**
     * 这里重载防止后期BT
     *
     * @param sequ 要求序列
     * @param times 洗牌次数
     */
    private static void Shuffling(int[] sequ, int times) {
        while (times > 0) {
            Shuffling(sequ);
            times--;
        }
    }

    /**
     * 单次按照要求洗牌
     *
     * @param sequ 洗牌序列
     */
    private static void Shuffling(int[] sequ) {
        for (int i = 0; i < 54; i++) {
            String tmp = poker[i];
            poker[i] = poker[sequ[i]-1];
            poker[sequ[i]-1] = tmp;
        }
    }
}
