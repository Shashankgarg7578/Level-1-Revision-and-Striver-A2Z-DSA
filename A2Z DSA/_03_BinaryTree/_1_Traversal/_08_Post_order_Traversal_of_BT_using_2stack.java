package _03_BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode07 {

	int data;
	TreeNode07 left;
	TreeNode07 right;

	public TreeNode07(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode07(int data, TreeNode07 left, TreeNode07 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _08_Post_order_Traversal_of_BT_using_2stack {

	public static void printList(List<Integer> list) {
		// Iterate through the list
		// and print each element
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	// Main method
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode07 root = new TreeNode07(1);
		root.left = new TreeNode07(2);
		root.right = new TreeNode07(3);
		root.left.left = new TreeNode07(4);
		root.left.right = new TreeNode07(5);

		// Getting postorder traversal
		List<Integer> result = postOrder(root);

		// Printing the postorder traversal result
		System.out.print("Postorder traversal: ");
		printList(result);
	}

//	Time Complexity: O(2N) 
//	Space Complexity: O(2N) 
	private static List<Integer> postOrder(TreeNode07 root) {
		List<Integer> postOrder = new ArrayList<Integer>();

		Stack<TreeNode07> st1 = new Stack<TreeNode07>();
		Stack<Integer> st2 = new Stack<Integer>();

		st1.add(root);
		while (!st1.isEmpty()) {
			TreeNode07 node = st1.pop();
			st2.add(node.data);

			if (node.left != null) {
				st1.add(node.left);
			}
			if (node.right != null) {
				st1.add(node.right);
			}
		}

		while (!st2.isEmpty()) {
			postOrder.add(st2.pop());
		}

		return postOrder;
	}
}
