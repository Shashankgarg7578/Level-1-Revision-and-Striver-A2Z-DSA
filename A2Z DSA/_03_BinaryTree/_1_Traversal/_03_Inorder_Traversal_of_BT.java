package _03_BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode02 {

	int data;

	TreeNode02 left;

	TreeNode02 right;

	public TreeNode02(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class _03_Inorder_Traversal_of_BT {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode02 root = new TreeNode02(1);
		root.left = new TreeNode02(2);
		root.right = new TreeNode02(3);
		root.left.left = new TreeNode02(4);
		root.left.right = new TreeNode02(5);

		// Getting inorder traversal
		List<Integer> result = inOrder(root);

		// Displaying the inorder traversal result
		System.out.print("Inorder Traversal: ");
		// Output each value in the
		// inorder traversal result
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	// Time Complexity: O(N)
//	Space Complexity: O(N) 
	private static List<Integer> inOrder(TreeNode02 root) {
		List<Integer> ans = new ArrayList<Integer>();
		inOrderTraversal(root, ans);
		return ans;
	}

	private static void inOrderTraversal(TreeNode02 root, List<Integer> ans) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left, ans);
		ans.add(root.data);
		inOrderTraversal(root.right, ans);
	}

}
