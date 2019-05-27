package design4Java.week01;

import java.math.BigDecimal;

public class Fraction {
	private int up;
	private int down;

	public Fraction(int up, int down) {
		this.up = up;
		this.down = down;
	}

	public void print() {
		// 先约分
		int[] a = Approximate(this.up, this.down);
		// 若分母为1直接输出分子
		if (a[1] == 1) {
			System.out.println(a[0]);
		} else {
			System.out.println(a[0] + "/" + a[1]);
		}
	}

	/**
	 * 
	 * @param up2
	 * @param down2
	 * @return
	 */
	private int[] Approximate(int up2, int down2) {
		int tem = Math.max(up2, down2);
		int i = 2;
		while (i <= tem) {
			if (up2 % i == 0 && down2 % i == 0) {
				up2 = up2 / i;
				down2 = down2 / i;
				i = 2;
			} else {
				i++;
			}
		}
		int[] a = { up2, down2 };
		return a;
	}

	public Fraction plus(Fraction b) {
		int downd = this.down * b.down;
		int upd = this.up * b.down + b.up * this.down;
		return new Fraction(upd, downd);
	}

	/**
	 * 直接相乘，要带那个调用print就约分了
	 * 
	 * @param b
	 * @return
	 */
	public Fraction multiply(Fraction b) {
		int upd = this.up * b.up;
		int downd = this.down * b.down;
		return new Fraction(upd, downd);
	}

	// 将分数转换为double值
	public double toDouble(Fraction f) {
		BigDecimal upd = new BigDecimal(f.up);
		BigDecimal downd = new BigDecimal(f.down);
		return upd.divide(downd).doubleValue();
	}

}
