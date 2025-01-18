package _03_BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode06 {

	int data;
	TreeNode06 left;
	TreeNode06 right;

	public TreeNode06(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode06(int data, TreeNode06 left, TreeNode06 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _07_Iterative_Inorder_Traversal_of_BT {
	// Main function
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode06 root = new TreeNode06(1);
		root.left = new TreeNode06(2);
		root.right = new TreeNode06(3);
		root.left.left = new TreeNode06(4);
		root.left.right = new TreeNode06(5);

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
	// Space Complexity: O(N)
	private static List<Integer> inOrder(TreeNode06 root) {
		List<Integer> inOrder = new ArrayList<Integer>();

		Stack<TreeNode06> st = new Stack<TreeNode06>();
		TreeNode06 node = root;
		while (true) {
			if (node != null) {
				st.push(node);
				node = node.left;
			} else {
				if (st.empty()) {
					break;
				}
				node = st.pop();
				inOrder.add(node.data);
				node = node.right;
			}
		}

		return inOrder;
	}

}
