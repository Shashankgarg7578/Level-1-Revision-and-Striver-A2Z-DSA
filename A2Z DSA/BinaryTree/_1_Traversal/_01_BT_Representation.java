package BinaryTree._1_Traversal;

class Node {

	int data;

	Node left;

	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class _01_BT_Representation {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
	}
}
