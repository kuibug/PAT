package dataStructures.week04;

import java.util.Scanner;

public class AVLTree {
	// AVTree 本身的定义
	public AVLNode node;

	@Override
	public String toString() {
		return "AVLTree [" + node + "]";
	}

	// 入口
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		Scanner sc = new Scanner(System.in);
		int nodeNummber = sc.nextInt();

		for (int i = 0; i < nodeNummber; i++) {
			int data = sc.nextInt();
			tree.node = tree.insert(tree.node, data);
		}
		System.out.println(tree.node.data);
		sc.close();
	}

	/**
	 * 插入函数,将指定的数据插入到树中
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private AVLNode insert(AVLNode node, int data) {
		// 若是空树,直接插入
		if (node == null) {
			node = new AVLNode(data);
		} else
		// 插入的数小于节点上的数
		if (data < node.data) {
			node.left = insert(node.left, data);
			// 插入后计算高度
			if (height(node.left) - height(node.right) >= 2) {
				// 插入的值小于左子节点，插在左边LL旋转
				if (data < node.left.data) {
					System.out.println(node.left.data + "LL旋转");
					node = singleLeft(node);
				} else {
					System.out.println(node.left.data + "LR旋转");
					node = leftRight(node);
				}
			}
		} else
		// 插入的数大于节点上的数
		{
			node.right = insert(node.right, data);
			// 插入后计算高度
			if (height(node.right) - height(node.left) >= 2) {
				// 插入的值大于右子节点，插在左边RR旋转
				if (data > node.right.data) {
					System.out.println(node.right.data + "RR旋转");
					node = singleRight(node);
				} else {
					System.out.println(node.right.data + "RL旋转");
					node = rightLeft(node);
				}
			}
		}
		//更新当前节点的高度
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	/**
	 * LR旋转
	 * 
	 * @param node2
	 * @return
	 */
	private AVLNode rightLeft(AVLNode node) {
		// 先进行RR旋转
		node.right = singleLeft(node.right);
		// 再进行LL旋转
		return singleRight(node);
	}

	/**
	 * RL旋转
	 * 
	 * @param node
	 * @return
	 */
	private AVLNode leftRight(AVLNode node) {
		// 先进行LL旋转
		node.left = singleRight(node.left);
		// 再进行RR旋转
		return singleLeft(node);
	}

	/**
	 * LL旋转 node / B(temp) / insert
	 * 
	 * @param node2
	 * @return
	 */
	private AVLNode singleLeft(AVLNode node) {
		// 先保存一下子节点
		AVLNode temp = node.left;
		// 用temp将左子树顶替掉
		node.left = temp.right;
		// 吧node改成tem的右子树
		temp.right = node;
		// 重新计算的高度
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		temp.height = Math.max(height(temp.left), node.height) + 1;
		return temp;// 返回新的根结点
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private AVLNode singleRight(AVLNode node) {
		// 先保存一下子节点
		AVLNode temp = node.right;
		// 用temp将右子树顶替掉
		node.right = temp.left;
		temp.left = node;

		// 重新计算高度
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		temp.height = Math.max(height(temp.left), node.height) + 1;

		// 返回新的根结点
		return temp;
	}

	/**
	 * 计算节点的高度
	 * 
	 * @param left
	 * @return
	 */
	private int height(AVLNode node) {
		return node == null ? -1 : node.height;
	}

}
