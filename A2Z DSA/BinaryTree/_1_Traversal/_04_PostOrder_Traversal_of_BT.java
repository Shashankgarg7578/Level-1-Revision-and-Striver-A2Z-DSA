package BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode03 {

	int data;

	TreeNode03 left;

	TreeNode03 right;

	public TreeNode03(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class _04_PostOrder_Traversal_of_BT {
	// Function to print the
	// elements of a list
	static void printList(List<Integer> list) {
		// Iterate through the list
		// and print each element
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode03 root = new TreeNode03(1);
		root.left = new TreeNode03(2);
		root.right = new TreeNode03(3);
		root.left.left = new TreeNode03(4);
		root.left.right = new TreeNode03(5);

		// Getting postorder traversal
		List<Integer> result = postOrder(root);

		// Printing the postorder
		// traversal result
		System.out.print("Postorder traversal: ");
		printList(result);
	}

	// Time Complexity: O(N)
    // Space Complexity: O(N) 
	private static List<Integer> postOrder(TreeNode03 root) {
		List<Integer> ans = new ArrayList<Integer>();
		postOrderTraversal(root, ans);
		return ans;
	}

	private static void postOrderTraversal(TreeNode03 root, List<Integer> ans) {

		if (root == null) {
			return;
		}
		postOrderTraversal(root.left, ans);
		postOrderTraversal(root.right, ans);
		ans.add(root.data);
	}
}
