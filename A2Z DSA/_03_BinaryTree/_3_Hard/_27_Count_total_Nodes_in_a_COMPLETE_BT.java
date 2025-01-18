package _03_BinaryTree._3_Hard;

class TreeNode27 {
	int data;
	TreeNode27 left;
	TreeNode27 right;

	public TreeNode27(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode27(int data, TreeNode27 left, TreeNode27 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _27_Count_total_Nodes_in_a_COMPLETE_BT {
	public static void main(String[] args) {
		// Create the binary tree
		TreeNode27 root = new TreeNode27(1);
		root.left = new TreeNode27(2);
		root.right = new TreeNode27(3);
		root.left.left = new TreeNode27(4);
		root.left.right = new TreeNode27(5);
		root.right.left = new TreeNode27(6);

		// Call the countNodes function
		int totalNodes = countNodes(root);

		// Print the result
		System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
	}

	private static int countNodes(TreeNode27 root) {
		if (root == null) {
			return 0;
		}

		int left = getHeightLeft(root);
		int right = getHeightRight(root);

		if (left == right) {
			//if both sides have same height then 2^left +1
			return ((2 << left) - 1);
		} else {
			//if both sides have same height then count both sides then + 1
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	private static int getHeightRight(TreeNode27 root) {

		int count = 0;

		while (root.right != null) {
			count++;
			root = root.right;
		}

		return count;
	}

	private static int getHeightLeft(TreeNode27 root) {
		int count = 0;

		while (root.left != null) {
			count++;
			root = root.left;
		}

		return count;
	}
}
