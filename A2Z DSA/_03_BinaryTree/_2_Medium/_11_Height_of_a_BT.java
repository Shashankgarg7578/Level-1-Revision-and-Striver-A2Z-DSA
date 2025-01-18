package _03_BinaryTree._2_Medium;

class TreeNode10 {

	int data;
	TreeNode10 left;
	TreeNode10 right;

	public TreeNode10(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode10(int data, TreeNode10 left, TreeNode10 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _11_Height_of_a_BT {
	// Main function
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode10 root = new TreeNode10(1);
		root.left = new TreeNode10(2);
		root.right = new TreeNode10(3);
		root.left.left = new TreeNode10(4);
		root.left.right = new TreeNode10(5);
		root.left.right.right = new TreeNode10(6);
		root.left.right.right.right = new TreeNode10(7);

		int depth = maxDepth(root);

		System.out.println("Maximum depth of the binary tree: " + depth);
	}

	private static int maxDepth(TreeNode10 root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return 1 + Math.max(left, right);
	}
}
