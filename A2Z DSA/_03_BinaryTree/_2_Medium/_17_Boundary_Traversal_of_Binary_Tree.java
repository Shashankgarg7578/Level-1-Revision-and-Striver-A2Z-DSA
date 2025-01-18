package _03_BinaryTree._2_Medium;

import java.util.ArrayList;
import java.util.List;

class TreeNode16 {
	int data;
	TreeNode16 left;
	TreeNode16 right;

	public TreeNode16(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode16(int data, TreeNode16 left, TreeNode16 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

//not required but good to understand.
public class _17_Boundary_Traversal_of_Binary_Tree {

	static void printResult(List<Integer> result) {
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode16 root = new TreeNode16(1);
		root.left = new TreeNode16(2);
		root.right = new TreeNode16(3);
		root.left.left = new TreeNode16(4);
		root.left.right = new TreeNode16(5);
		root.right.left = new TreeNode16(6);
		root.right.right = new TreeNode16(7);

		// Get the boundary traversal
		List<Integer> result = printBoundary(root);

		// Print the result
		System.out.print("Boundary Traversal: ");
		printResult(result);
	}

//	Time Complexity: O(N) 
//	Space Complexity: O(N) 
	private static List<Integer> printBoundary(TreeNode16 root) {
		List<Integer> ans = new ArrayList<Integer>();

		if (root == null) {
			return ans;
		}

		if (!isLeaf(root)) {
			ans.add(root.data);
		}

		addLeftBoundary(root, ans);
		addLeaves(root, ans);
		addRightBoundary(root, ans);
		return ans;
	}

	private static boolean isLeaf(TreeNode16 root) {
		return root.left == null && root.right == null;
	}

	private static void addLeftBoundary(TreeNode16 root, List<Integer> ans) {
		TreeNode16 curr = root.left;

		while (curr != null) {
			if (!isLeaf(curr)) {
				ans.add(curr.data);
			}

			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

	}

	private static void addRightBoundary(TreeNode16 root, List<Integer> ans) {
		List<Integer> tempList = new ArrayList<Integer>();

		TreeNode16 curr = root.right;

		while (curr != null) {
			if (!isLeaf(curr)) {
				tempList.add(curr.data);
			}

			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}

		for (int i = tempList.size() - 1; i >= 0; i--) {
			ans.add(tempList.get(i));
		}

	}

	private static void addLeaves(TreeNode16 root, List<Integer> ans) {
		if (isLeaf(root)) {
			ans.add(root.data);
			return;
		}

		if (root.left != null) {
			addLeaves(root.left, ans);
		}
		if (root.right != null) {
			addLeaves(root.right, ans);
		}

	}

}
