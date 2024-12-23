package BinaryTree._3_Hard;

import java.util.ArrayList;
import java.util.List;

class TreeNode22 {
	int data;
	TreeNode22 left;
	TreeNode22 right;

	public TreeNode22(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode22(int data, TreeNode22 left, TreeNode22 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _23_Root_to_Node_Path_in_BT {
	public static void main(String[] args) {
		TreeNode22 root = new TreeNode22(3);
		root.left = new TreeNode22(5);
		root.right = new TreeNode22(1);
		root.left.left = new TreeNode22(6);
		root.left.right = new TreeNode22(2);
		root.right.left = new TreeNode22(0);
		root.right.right = new TreeNode22(8);
		root.left.right.left = new TreeNode22(7);
		root.left.right.right = new TreeNode22(4);

		int targetLeafValue = 7;

		List<Integer> path = solve(root, targetLeafValue);

		System.out.print("Path from root to leaf with value " + targetLeafValue + ": ");
		for (int i = 0; i < path.size(); ++i) {
			System.out.print(path.get(i));
			if (i < path.size() - 1) {
				System.out.print(" -> ");
			}
		}
	}

	//Time Complexity: O(N)
	//Space Complexity: O(N)
	private static List<Integer> solve(TreeNode22 root, int targetLeafValue) {

		List<Integer> ans = new ArrayList<Integer>();

		solveHelper(root, ans, targetLeafValue);

		return ans;
	}

	private static boolean solveHelper(TreeNode22 root, List<Integer> ans, int targetLeafValue) {

		if (root == null) {
			return false;
		}

		ans.add(root.data);

		if (root.data == targetLeafValue) {
			return true;
		}

		if (solveHelper(root.left, ans, targetLeafValue) || solveHelper(root.right, ans, targetLeafValue)) {
			return true;
		}

		ans.remove(ans.size() - 1);

		return false;
	}
}
