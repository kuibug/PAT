package javase.week06;

import java.util.Scanner;

public class GPS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String time = "";

		while (sc.hasNext()) {
			String str = sc.nextLine();
			// 以END结束接收
			if (str.equals("END")) {
				break;
			}

			String[] splited = str.split(",");
			// 遍历检查是否定位成功，不成功跳过
			if (splited[0].equals("$GPRMC") && splited[2].equals("A")) {
				System.out.println("定位成功！");

				// 定位成功，检验值的是否正确
				int result = check(str);

				// 校验判断
				int hash = Integer.parseInt(str.substring(str.lastIndexOf('*') + 1), 16);
				if (hash == result) {
					System.out.println("校验成功！" + hash + ":" + result);
					// 校验成功开始计算时间，每次满足上述两个条件就更新目标结果语句
					time = calTime(splited[1]);
				} else {
					System.out.println("校验失败！" + hash + ":" + result);
				}

			} else {
				System.out.println("定位失败！");
			}
		}

		// 打印结果
		System.out.print(time);
		sc.close();
	}

	// 计算语句中的时间
	private static String calTime(String time) {
		int UTC = Integer.parseInt(time.substring(0, 6));
		int BJT = toBJT(UTC);
		// System.out.println("时间传参测试：" + time);
		StringBuilder newTime = new StringBuilder(BJT + "");
		while (newTime.length() < 6) {
			newTime.insert(0, '0');
		}
		newTime.insert(2, ':');
		newTime.insert(5, ':');
		return newTime.toString();
	}

	private static int toBJT(int UTC) {
		int BJT = UTC + 80000;
		if (BJT >= 240000) {
			BJT -= 240000;
		}
		return BJT;
	}

	/**
	 * 校验'$','*'中间的异或值
	 * 
	 * @param str
	 * @return
	 */
	private static int check(String str) {
		String calStr = str.substring(str.indexOf('$') + 1, str.lastIndexOf('*')).replaceAll(",", "");
		int result = -1;
		for (int i = 0; i < calStr.length() - 1; i++) {
			if (i == 0) {
				result = calStr.charAt(i) ^ calStr.charAt(i + 1);
			} else {
				result ^= calStr.charAt(i + 1);
			}
		}
		return result;
	}
}
/*
 * 
 * $GPRMC,024813.640,A,3158.4608,N,11848.3737,E,10.05,324.27,150706,,,A*50
 END
 */