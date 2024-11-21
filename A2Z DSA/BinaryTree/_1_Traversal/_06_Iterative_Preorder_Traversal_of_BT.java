package BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode05 {

	int data;

	TreeNode05 left;

	TreeNode05 right;

	public TreeNode05(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode05(int data, TreeNode05 left, TreeNode05 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _06_Iterative_Preorder_Traversal_of_BT {
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode05 root = new TreeNode05(1);
		root.left = new TreeNode05(2);
		root.right = new TreeNode05(3);
		root.left.left = new TreeNode05(4);
		root.left.right = new TreeNode05(5);

		// Getting the preorder traversal
		List<Integer> result = preorderTraversal(root);

		// Displaying the preorder traversal result
		System.out.print("Preorder Traversal: ");
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	// Time Complexity: O(N)
	// Space Complexity: O(N)
	private static List<Integer> preorderTraversal(TreeNode05 root) {
		List<Integer> ans = new ArrayList<Integer>();

		Stack<TreeNode05> st = new Stack<TreeNode05>();
		st.add(root);

		while (st.size() > 0) {

			TreeNode05 node = st.pop();

			ans.add(node.data);

			// first take right then take left
//			because in we have to print first left then right and 
			if (node.right != null) {
				st.add(node.right);
			}

//			in stack it is LIFO so we have to take left in end.
			if (node.left != null) {
				st.add(node.left);
			}

		}

		return ans;
	}
}
