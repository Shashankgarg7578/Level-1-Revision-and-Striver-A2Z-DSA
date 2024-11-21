package BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode04 {

	int data;

	TreeNode04 left;

	TreeNode04 right;

	public TreeNode04(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode04(int data, TreeNode04 left, TreeNode04 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _05_Level_order_Traversal {

	// Main function
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode04 root = new TreeNode04(1);
		root.left = new TreeNode04(2);
		root.right = new TreeNode04(3);
		root.left.left = new TreeNode04(4);
		root.left.right = new TreeNode04(5);

		// Perform level-order traversal
		List<List<Integer>> result = levelOrder(root);

		System.out.println("Level Order Traversal of Tree:");

		// Printing the level order traversal result
		for (List<Integer> level : result) {
			printList(level);
		}
	}

	// Time Complexity: O(N)
	// Space Complexity: O(N)
	private static void printList(List<Integer> list) {
		// Iterate through the
		// list and print each element
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static List<List<Integer>> levelOrder(TreeNode04 root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		if (root == null) {
			return ans;
		}

		Queue<TreeNode04> q = new LinkedList<TreeNode04>();

		q.add(root);

		while (!q.isEmpty()) {

			int size = q.size();

			List<Integer> tempAns = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {

				TreeNode04 node = q.poll();

				tempAns.add(node.data);

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}

			}
			ans.add(tempAns);
		}

		return ans;
	}

}
