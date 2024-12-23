package BinaryTree._2_Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode15 {
	int data;
	TreeNode15 left;
	TreeNode15 right;

	public TreeNode15(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode15(int data, TreeNode15 left, TreeNode15 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _16_Zig_Zag_Traversal_of_Binary_Tree {
	static void printResult(List<List<Integer>> result) {
		for (List<Integer> row : result) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode15 root = new TreeNode15(1);
		root.left = new TreeNode15(2);
		root.right = new TreeNode15(3);
		root.left.left = new TreeNode15(4);
		root.left.right = new TreeNode15(5);
		root.right.left = new TreeNode15(6);
		root.right.right = new TreeNode15(7);

		// Get the zigzag level order traversal
		List<List<Integer>> result = ZigZagLevelOrder(root);

		// Print the result
		printResult(result);
	}

	public static List<List<Integer>> ZigZagLevelOrder(TreeNode15 root) {
		// List to store the result of zigzag traversal
		List<List<Integer>> result = new ArrayList<>();

		// Check if the root is null, return an empty result
		if (root == null) {
			return result;
		}

		Stack<TreeNode15> ms = new Stack<TreeNode15>();
		ms.push(root);

		Stack<TreeNode15> cs = new Stack<TreeNode15>();

		int level = 1;

		List<Integer> tempans = new ArrayList<Integer>();
		while (ms.size() > 0) {

			TreeNode15 node = ms.pop();
			tempans.add(node.data);

			if (level % 2 == 0) {
				if (node.right != null) {
					cs.add(node.right);
				}
				if (node.left != null) {
					cs.add(node.left);
				}
			} else {
				if (node.left != null) {
					cs.add(node.left);
				}
				if (node.right != null) {
					cs.add(node.right);
				}
			}

			if (ms.size() == 0) {
				result.add(tempans);
				tempans = new ArrayList<Integer>();
				ms = cs;
				cs = new Stack<TreeNode15>();
				level = level + 1;
			}

		}

		// Return the final result of
		// zigzag level order traversal
		return result;
	}

}
