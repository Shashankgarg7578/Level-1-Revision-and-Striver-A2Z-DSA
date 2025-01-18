package _04_BinarySearchTree;

class TreeNode05 {
	// Value of the node
	int val;

	TreeNode05 left;

	TreeNode05 right;

	TreeNode05(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _05_Delete_a_Node_in_BST {

	// Function to perform an in-order traversal
	// of a binary tree and print its nodes
	public static void printInOrder(TreeNode05 root) {
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
		TreeNode05 root = new TreeNode05(10);
		root.left = new TreeNode05(5);
		root.right = new TreeNode05(13);
		root.left.left = new TreeNode05(3);
		root.left.left.left = new TreeNode05(2);
		root.left.left.right = new TreeNode05(4);
		root.left.right = new TreeNode05(6);
		root.left.right.right = new TreeNode05(9);
		root.right.left = new TreeNode05(11);
		root.right.right = new TreeNode05(14);

		System.out.println("Binary Search Tree:");
		printInOrder(root);
		System.out.println();

		// Searching for a value in the BST
		int key = 10;
		TreeNode05 ansNode = deleteNode(root, key);

		printInOrder(ansNode);
	}

	private static TreeNode05 deleteNode(TreeNode05 root, int key) {

		if (root == null) {
			return null;
		}
		if (root.val == key) {
			return helper(root);
		}

		TreeNode05 dummy = root;

		while (root != null) {
			if (root.val > key) {
				if (root.left != null && root.left.val == key) {
					root.left = helper(root.left);
				} else {
					root = root.left;
				}
			} else {
				if (root.right != null && root.right.val == key) {
					root.right = helper(root.right);
				} else {
					root = root.right;
				}
			}
		}

		return dummy;
	}

	private static TreeNode05 helper(TreeNode05 root) {

		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {

			//take right Node
			TreeNode05 rightChild = root.right;

			//take  right most node from Left side
			TreeNode05 lastRightChildOnLeft = findLastRightChildOnLeft(root.left);

			//add right Node in right most node from Left side
			lastRightChildOnLeft.right = rightChild;

			return root.left;
		}
	}

	//for return right most node from Left side
	private static TreeNode05 findLastRightChildOnLeft(TreeNode05 root) {
		if (root.right == null) {
			return root;
		}

		return findLastRightChildOnLeft(root.right);
	}
}
