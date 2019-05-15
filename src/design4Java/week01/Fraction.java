package design4Java.week01;

import java.math.BigDecimal;

public class Fraction {
	int up;
	int down;

	public Fraction(int up, int down) {
		this.up = up;
		this.down = down;
	}

	public void print() {
		// 先约分
		int[] a = Approximate(this.up, this.down);

		System.out.println(this.up + "/" + this.down);
	}

	private int[] Approximate(int up2, int down2) {
		int tem = Math.max(up2, down2);
		int be = 2;
		while (!(up2 % be == 0 && down2 % be == 0)) {
			be++;
		}
		return null;
	}

	public Fraction plus(Fraction b) {
		// TODO Auto-generated method stub
		return null;
	}

	public Fraction multiply(Fraction b) {
		// TODO Auto-generated method stub
		return null;
	}

	// 将分数转换为double值
	public double toDouble(Fraction f) {
		BigDecimal upd = new BigDecimal(f.up);
		BigDecimal downd = new BigDecimal(f.down);
		return upd.divide(downd).doubleValue();
	}

}
