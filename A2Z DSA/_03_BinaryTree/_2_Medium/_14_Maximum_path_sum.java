package _03_BinaryTree._2_Medium;

class TreeNode13 {

	int data;
	TreeNode13 left;
	TreeNode13 right;

	public TreeNode13(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode13(int data, TreeNode13 left, TreeNode13 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _14_Maximum_path_sum {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode13 root = new TreeNode13(1);
		root.left = new TreeNode13(2);
		root.right = new TreeNode13(3);
		root.left.left = new TreeNode13(4);
		root.left.right = new TreeNode13(5);
		root.left.right.right = new TreeNode13(6);
		root.left.right.right.right = new TreeNode13(7);

		// Finding and printing the maximum path sum
		int maxPathSum = maxPathSum2(root);
		System.out.println("Maximum Path Sum: " + maxPathSum);
	}

	static int maxSum = Integer.MIN_VALUE;

	public static int maxPathSum2(TreeNode13 root) {
		if (root == null) {
			return 0;
		}

		int left = Math.max(0, maxPathSum2(root.left));
		int right = Math.max(0, maxPathSum2(root.right));

		maxSum = Math.max(maxSum, left + right + root.data);

		return Math.max(left, right) + root.data;
	}

}
