package BinarySearchTree;

class TreeNode07 {
	// Value of the node
	int val;

	TreeNode07 left;

	TreeNode07 right;

	TreeNode07(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _07_Check_if_a_tree_is_a_BST_or_BT {
	// Function to perform an in-order traversal
	// of a binary tree and print its nodes
	public static void printInOrder(TreeNode07 root) {
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

	public static void main(String[] args) {
		// Creating a BST
		TreeNode07 root = new TreeNode07(10);
		root.left = new TreeNode07(5);
		root.right = new TreeNode07(13);
		root.left.left = new TreeNode07(3);
		root.left.left.left = new TreeNode07(2);
		root.left.left.right = new TreeNode07(4);
		root.left.right = new TreeNode07(6);
		root.left.right.right = new TreeNode07(9);
		root.right.left = new TreeNode07(11);
		root.right.right = new TreeNode07(14);

		System.out.println("Binary Search Tree:");
		printInOrder(root);
		System.out.println();

		boolean ansNode = isValidBST(root);

		System.out.println("Ans: " + ansNode);
	}

	private static boolean isValidBST(TreeNode07 root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static Boolean isValidBST(TreeNode07 root, int minValue, int maxValue) {
		if(root == null) return true;
		
		if(root.val >= maxValue || root.val <= minValue) {
			return false;
		}
		
		return isValidBST(root.left, minValue, root.val) && isValidBST(root.right,root.val , maxValue); 
		
	}

}
