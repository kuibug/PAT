package dataStructures.week04;

public class AVLNode {
	public static int NULL = -1;
	public int data; // 所储存的数值
	public AVLNode left; // 左节点的index
	public AVLNode right; // 右节点的index
	public int height;	//平衡因子

	public AVLNode() {
	}

	public AVLNode(int data) {
		this(data, null, null,0);
	}

	public AVLNode(int data, AVLNode left, AVLNode right, int height) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = height;
	}

	@Override
	public String toString() {
		return "AVLNode [D=" + data + ", L=" + left + ", R=" + right + ", H=" + height + "]";
	}
	
}
