package _04_BinarySearchTree;

class TreeNode06 {
	// Value of the node
	int val;

	TreeNode06 left;

	TreeNode06 right;

	TreeNode06(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _06_Find_Kth_SmallestOrLargest_element_in_BST {
	// Function to perform an in-order traversal
	// of a binary tree and print its nodes
	public static void printInOrder(TreeNode06 root) {
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
		TreeNode06 root = new TreeNode06(10);
		root.left = new TreeNode06(5);
		root.right = new TreeNode06(13);
		root.left.left = new TreeNode06(3);
		root.left.left.left = new TreeNode06(2);
		root.left.left.right = new TreeNode06(4);
		root.left.right = new TreeNode06(6);
		root.left.right.right = new TreeNode06(9);
		root.right.left = new TreeNode06(11);
		root.right.right = new TreeNode06(14);

		System.out.println("Binary Search Tree:");
		printInOrder(root);
		System.out.println();

		// Searching for a value in the BST
		int k = 3;
		int ans = kthSmallest(root, k);

		System.out.println("Ans: " + ans);
	}

	private static int kthSmallest(TreeNode06 root, int k) {
		int[] cnt = {0};
		return kthSmallestValue(root, k , cnt);
	}

	private static int kthSmallestValue(TreeNode06 root, int k, int[] counter) {
		if (root == null) {
			return -1;
		}

		int left = kthSmallestValue(root.left, k,counter);
		
		counter[0]++;
		if(counter[0] == k) {
			return root.val;
		}
		
		int right = kthSmallestValue(root.right, k, counter);
		
		return left != -1 ? left : right;
	}

}
