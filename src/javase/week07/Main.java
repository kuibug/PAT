package javase.week07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
             String result = Integer.toBinaryString(num);
             if(num == 0) {
                 System.out.println(32);
             }else {
                 System.out.println(32 - result.length());
             }          
    }
}