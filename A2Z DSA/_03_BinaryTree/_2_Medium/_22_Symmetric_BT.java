package _03_BinaryTree._2_Medium;

class TreeNode21 {
	int data;
	TreeNode21 left;
	TreeNode21 right;

	public TreeNode21(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode21(int data, TreeNode21 left, TreeNode21 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _22_Symmetric_BT {

	private static void printInorder(TreeNode21 root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode21 root = new TreeNode21(1);
		root.left = new TreeNode21(2);
		root.right = new TreeNode21(2);
		root.left.left = new TreeNode21(3);
		root.right.right = new TreeNode21(3);
		root.left.right = new TreeNode21(4);
		root.right.left = new TreeNode21(4);

		System.out.print("Binary Tree (Inorder): ");
		printInorder(root);
		System.out.println();

		boolean res = isSymmetric(root);

		if (res) {
			System.out.println("This Tree is Symmetrical");
		} else {
			System.out.println("This Tree is NOT Symmetrical");
		}
	}

	// Time Complexity: O(N)
	// Space Complexity: O(1)
	private static boolean isSymmetric(TreeNode21 root) {
		return root == null || isSymmetricHelper(root.left, root.right);
	}

	private static boolean isSymmetricHelper(TreeNode21 left, TreeNode21 right) {

		if (left == null || right == null) {
			return left == right;
		}

		if (left.data != right.data) {
			return false;
		}

		return isSymmetricHelper(left.left, left.right) && isSymmetricHelper(right.right, right.left);
	}
}
