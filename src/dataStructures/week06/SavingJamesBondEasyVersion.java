package dataStructures.week06;

import java.util.Scanner;

/**
 * save 007 先用DFS试试 鳄鱼到到边缘的距离=到到中心距离-半径
 * 
 * @author craftsman
 * @date 2019年5月7日
 */
class Cayman {
	int X;
	int Y;

	public Cayman(int x, int y) {
		X = x;
		Y = y;
	}

	@Override
	public String toString() {
		return "Cayman [" + X + "," + Y + "]";
	}

}

public class SavingJamesBondEasyVersion {
	static int num, jump;
	static Cayman[] canmans;
	static boolean alive = false;//007是否能活下去，显然默认不能

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();// 倒霉鳄鱼的数量
		jump = sc.nextInt();// 007跳跃距离

		// int[][] canmans = new int[caymanNum][2];
		canmans = new Cayman[num];
		for (int i = 0; i < num; i++) {
			int X = sc.nextInt();// X坐标
			int Y = sc.nextInt();// Y坐标
			canmans[i] = new Cayman(X, Y);// Y坐标
		}
		sc.close();
		Cayman james = new Cayman(0, 0); // 初始化007目前的位置
		// 先看该点能不能到岸边
		boolean ok = isPort(james);
		
		if (ok) {
			alive = true;
		}
	}

	private static boolean isPort(Cayman james) {
		boolean isPort = false;
		// 先算该点到左右两边的距离，取最小值
		// int right = 50 - james.X;
		// int left = james.X + 50;
		int X = Math.min(50 - james.X, james.X + 50);
		int Y = Math.min(50 - james.Y, james.Y + 50);
		if (Math.min(X, Y) < jump) {
			isPort = true;
			alive = true;
		}
		return isPort;
	}

	/**
	 * 计算两点距离的算法，结果向上取整
	 * 
	 * @param cayman1
	 * @param cayman2
	 * @return line 两点的距离（int）
	 */
	private static int calLine(Cayman cayman1, Cayman cayman2) {
		int x = cayman1.X - cayman2.X;
		int y = cayman1.Y - cayman2.Y;
		double line = Math.pow(x * x + y * y, 0.5);
		return (int) Math.ceil(line);
	}
}
