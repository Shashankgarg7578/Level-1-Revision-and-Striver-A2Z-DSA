package BinarySearchTree;

class TreeNode08 {
	// Value of the node
	int val;

	TreeNode08 left;

	TreeNode08 right;

	TreeNode08(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _08_LCA_in_BST {
	// Function to perform an in-order traversal
	// of a binary tree and print its nodes
	public static void printInOrder(TreeNode08 root) {
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
		TreeNode08 root = new TreeNode08(10);
		root.left = new TreeNode08(5);
		root.right = new TreeNode08(13);
		root.left.left = new TreeNode08(3);
		root.left.left.left = new TreeNode08(2);
		root.left.left.right = new TreeNode08(4);
		root.left.right = new TreeNode08(6);
		root.left.right.right = new TreeNode08(9);
		root.right.left = new TreeNode08(11);
		root.right.right = new TreeNode08(14);

		System.out.println("Binary Search Tree:");
		printInOrder(root);
		System.out.println();

		TreeNode08 ansNode = lowestCommonAncestor(root, root.left.left.left, root.left.right.right);

		System.out.println("Ans: " + ansNode.val);
	}

	private static TreeNode08 lowestCommonAncestor(TreeNode08 root, TreeNode08 p, TreeNode08 q) {
		if (root == null) {
			return null;
		}

		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}

		return root;
	}

}
