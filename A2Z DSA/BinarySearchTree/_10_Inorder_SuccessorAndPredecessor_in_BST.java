package BinarySearchTree;

class TreeNode10 {
	// Value of the node
	int val;

	TreeNode10 left;

	TreeNode10 right;

	TreeNode10(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _10_Inorder_SuccessorAndPredecessor_in_BST {
	// Function to perform an in-order traversal
	// of a binary tree and print its nodes
	public static void printInOrder(TreeNode10 root) {
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
		TreeNode10 root = new TreeNode10(10);
		root.left = new TreeNode10(5);
		root.right = new TreeNode10(13);
		root.left.left = new TreeNode10(3);
		root.left.left.left = new TreeNode10(2);
		root.left.left.right = new TreeNode10(4);
		root.left.right = new TreeNode10(6);
		root.left.right.right = new TreeNode10(9);
		root.right.left = new TreeNode10(11);
		root.right.right = new TreeNode10(14);

		System.out.println("Binary Search Tree:");
		printInOrder(root);
		System.out.println();

		TreeNode10 ansNode = inOrderSuccessor(root, root.left.right.right);

		System.out.println("Ans: " + ansNode.val);
	}

	private static TreeNode10 inOrderSuccessor(TreeNode10 root, TreeNode10 p) {
		
		TreeNode10 successor = null;
		
		while(root != null) {
			
			if(p.val >= root.val) {
				root = root.right;
			}else {
				successor = root;
				root = root.left;
			}
			
		}
		
		return successor;
	}

}
