package _04_BinarySearchTree;

class TreeNode02 {
	// Value of the node
	int val;

	TreeNode02 left;

	TreeNode02 right;

	TreeNode02(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _02_Ceil_in_a_BST {
	public static void printInOrder(TreeNode02 root) {
		// Check if the current node
		// is null (base case for recursion)
		if (root == null) {
			// If null, return and
			// terminate the function
			return;
		}

		// Recursively call printInOrder
		// for the left subtree
		printInOrder(root.left);

		// Print the value of the current node
		System.out.print(root.val + " ");

		// Recursively call printInOrder
		// for the right subtree
		printInOrder(root.right);
	}

	// Main method
	public static void main(String[] args) {
		// Creating a BST
		TreeNode02 root = new TreeNode02(10);
		root.left = new TreeNode02(5);
		root.right = new TreeNode02(13);
		root.left.left = new TreeNode02(3);
		root.left.left.left = new TreeNode02(2);
		root.left.left.right = new TreeNode02(4);
		root.left.right = new TreeNode02(6);
		root.left.right.right = new TreeNode02(9);
		root.right.left = new TreeNode02(11);
		root.right.right = new TreeNode02(14);

		System.out.println("Binary Search Tree: ");
		printInOrder(root);
		System.out.println();

		// Searching for a value in the BST
		int target = 8;
		int ceil = findCeil(root, target);

		if (ceil != -1) {
			System.out.println("Ceiling of " + target + " is: " + ceil);
		} else {
			System.out.println("No ceiling found!");
		}
	}

	private static int findCeil(TreeNode02 root, int target) {

		int ceil = -1;

		while (root != null) {

			if (root.val == target) {
				ceil = root.val;
				return ceil;
			}

			if (target > root.val) {
				root = root.right;
			} else {
				ceil = root.val;
				root = root.left;
			}

		}

		return ceil;
	}
}
