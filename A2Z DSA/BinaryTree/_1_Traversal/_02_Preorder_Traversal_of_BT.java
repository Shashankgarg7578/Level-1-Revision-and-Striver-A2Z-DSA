package BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode01 {

	int data;

	TreeNode01 left;

	TreeNode01 right;

	public TreeNode01(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class _02_Preorder_Traversal_of_BT {
	// Main function
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode01 root = new TreeNode01(1);
		root.left = new TreeNode01(2);
		root.right = new TreeNode01(3);
		root.left.left = new TreeNode01(4);
		root.left.right = new TreeNode01(5);

		// Getting preorder traversal
		List<Integer> result = preOrder(root);

		// Displaying the preorder traversal result
		System.out.print("Preorder Traversal: ");
		// Output each value in the
		// preorder traversal result
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	// Time Complexity: O(N)
//	Space Complexity: O(N) 
	private static List<Integer> preOrder(TreeNode01 root) {
		List<Integer> ans = new ArrayList<Integer>();
		preOrderTraversal(root, ans);
		return ans;
	}

	private static void preOrderTraversal(TreeNode01 root, List<Integer> ans) {
		if (root == null) {
			return;
		}

		ans.add(root.data);
		preOrderTraversal(root.left, ans);
		preOrderTraversal(root.right, ans);
	}
}
