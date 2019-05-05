package javase.week05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Polynomial implements Comparable<Polynomial> {
	int constant; // 系数
	int coefficient; // 指数

	public Polynomial(int constant, int coefficient) {
		this.constant = constant;
		this.coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Polynomial [con=" + constant + ", coef=" + coefficient + "]";
	}

	@Override
	public int compareTo(Polynomial o) {
		int coff = o.coefficient;
		// 按照指数降序排序
		return coff - this.coefficient;
	}

}

public class PolynomialSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 数据录入
		ArrayList<Polynomial> poly1 = input(sc);
		ArrayList<Polynomial> poly2 = input(sc);

		// 排序
		Collections.sort(poly1);
		Collections.sort(poly2);
		//System.out.println(poly1 + "\n" + poly2);
		// 求和
		String result = getSum(poly1, poly2);
		System.out.print(result);
	}

	private static String getSum(ArrayList<Polynomial> poly1, ArrayList<Polynomial> poly2) {
		StringBuilder result = new StringBuilder();
		int pointer1 = 0;
		int pointer2 = 0;

		// 当两个数组都有内容的时候
		while (pointer1 < poly1.size() && pointer2 < poly2.size()) {
			Polynomial p1 = poly1.get(pointer1);
			Polynomial p2 = poly2.get(pointer2);

			String con, coef;
			// 如果数组一的始数大于数组二指数,输出数组一
			if (p1.coefficient > p2.coefficient) {
				con = p1.constant + "";
				coef = p1.coefficient + "";
				pointer1++;
			} else
			// 如果数组一的指数小于数组二指数,输出数组二
			if (p1.coefficient < p2.coefficient) {
				con = p2.constant + "";
				coef = p2.coefficient + "";
				pointer2++;
			} else
			// 指数相等,加和
			{
				con = p1.constant + p2.constant + "";
				coef = p1.coefficient + "";
				pointer1++;
				pointer2++;
			}
			// 添加字符串
			result.append(add(con, coef));

		}
		// 第一个空了,第二个还没空
		if (pointer1 == poly1.size() && pointer2 < poly2.size()) {
			String con, coef;
			while (pointer2 < poly2.size()) {
				con = poly2.get(pointer2).constant + "";
				coef = poly2.get(pointer2).coefficient + "";
				pointer2++;
				result.append(add(con, coef));
			}
		}

		// 第二个空了,第一个还没空
		if (pointer1 < poly1.size() && pointer2 == poly2.size()) {
			String con, coef;
			while (pointer1 < poly1.size()) {
				con = poly1.get(pointer2).constant + "";
				coef = poly1.get(pointer2).coefficient + "";
				pointer1++;
				result.append(add(con, coef));
			}
		}
		//System.out.println(result);
		// 最后再来检查最后一个字符是不是"+"
		if (result.length() != 0 && result.charAt(result.length() - 1) == '+') {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	private static String add(String con, String coef) {
		String result = "";

		// 处理指数为1
		if (coef.equals("1")) {
			coef = "";
		}
		if (con.equals("0")) {
			return "";
		}
		// 处理指数为0
		if (coef.equals("0")) {
			result = con;
		} else {
			result = con + "x" + coef + "+";
		}
		return result;
	}

	/**
	 * 数据录入
	 * 
	 * @param sc
	 * @return ArrayList<Polynomial> 录入的数据的arraylist
	 */
	private static ArrayList<Polynomial> input(Scanner sc) {
		ArrayList<Polynomial> arrayList = new ArrayList<Polynomial>();
		boolean inputFlag = true; // 检查是否需要继续输入
		while (inputFlag) {
			int coefficient = sc.nextInt();
			int constant = sc.nextInt();
			arrayList.add(new Polynomial(constant, coefficient));
			if (coefficient == 0) {
				inputFlag = false;
			}
		}

		return arrayList;
	}
}
/*
 * 6 2 3 12 5 3 1 6 0 20 5 3 6 2 2 12 1 6 0 20
 */