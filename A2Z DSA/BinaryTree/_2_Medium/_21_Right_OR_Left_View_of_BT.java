package BinaryTree._2_Medium;

import java.util.ArrayList;
import java.util.List;

class TreeNode20 {
	int data;
	TreeNode20 left;
	TreeNode20 right;

	public TreeNode20(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode20(int data, TreeNode20 left, TreeNode20 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _21_Right_OR_Left_View_of_BT {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode20 root = new TreeNode20(1);
		root.left = new TreeNode20(2);
		root.left.left = new TreeNode20(4);
		root.left.right = new TreeNode20(10);
		root.left.left.right = new TreeNode20(5);
		root.left.left.right.right = new TreeNode20(6);
		root.right = new TreeNode20(3);
		root.right.right = new TreeNode20(10);
		root.right.left = new TreeNode20(9);

		// Get the Right View traversal
		List<Integer> rightView = rightsideView(root);

		// Print the result for Right View
		System.out.print("Right View Traversal: ");
		for (int node : rightView) {
			System.out.print(node + " ");
		}
		System.out.println();

		// Get the Left View traversal
		List<Integer> leftView = leftsideView(root);

		// Print the result for Left View
		System.out.print("Left View Traversal: ");
		for (int node : leftView) {
			System.out.print(node + " ");
		}
		System.out.println();
	}

	//Time Complexity: O(N)
	//Space Complexity : O(N) 
	private static List<Integer> rightsideView(TreeNode20 root) {
		List<Integer> ans = new ArrayList<Integer>();

		recursiveRightSideView(root, 0, ans);

		return ans;
	}

	private static void recursiveRightSideView(TreeNode20 root, int level, List<Integer> ans) {
		if (root == null) {
			return;
		}

		if (level == ans.size()) {
			ans.add(root.data);
		}

		recursiveRightSideView(root.right, level + 1, ans);
		recursiveRightSideView(root.left, level + 1, ans);
	}


	private static List<Integer> leftsideView(TreeNode20 root) {
		List<Integer> ans = new ArrayList<Integer>();

		recursiveLeftSideView(root, 0, ans);

		return ans;
	}

	private static void recursiveLeftSideView(TreeNode20 root, int level, List<Integer> ans) {
		if (root == null) {
			return;
		}

		if (level == ans.size()) {
			ans.add(root.data);
		}

		recursiveRightSideView(root.left, level + 1, ans);
		recursiveRightSideView(root.right, level + 1, ans);
	}

}
