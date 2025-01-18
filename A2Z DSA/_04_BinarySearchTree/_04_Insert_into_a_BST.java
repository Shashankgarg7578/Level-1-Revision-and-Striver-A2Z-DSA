package _04_BinarySearchTree;

class TreeNode04 {
	// Value of the node
	int val;

	TreeNode04 left;

	TreeNode04 right;

	TreeNode04(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _04_Insert_into_a_BST {

	public static TreeNode04 insertIntoBST(TreeNode04 root, int val) {

		if (root == null) {
			return new TreeNode04(val);
		}

		TreeNode04 cur = root;
		while (true) {

			if (cur.val <= val) {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = new TreeNode04(val);
					break;
				}
			} else {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode04(val);
					break;
				}
			}
		}

		return root;
	}

	// Function to perform an in-order traversal
	// of a binary tree and print its nodes
	public static void printInOrder(TreeNode04 root) {
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
		TreeNode04 root = new TreeNode04(10);
		root.left = new TreeNode04(5);
		root.right = new TreeNode04(13);
		root.left.left = new TreeNode04(3);
		root.left.left.left = new TreeNode04(2);
		root.left.left.right = new TreeNode04(4);
		root.left.right = new TreeNode04(6);
		root.left.right.right = new TreeNode04(9);
		root.right.left = new TreeNode04(11);
		root.right.right = new TreeNode04(14);

		System.out.println("Binary Search Tree:");
		printInOrder(root);
		System.out.println();

		// Searching for a value in the BST
		int val = 8;
		TreeNode04 ansNode = insertIntoBST(root, val);

		printInOrder(ansNode);
	}
}
