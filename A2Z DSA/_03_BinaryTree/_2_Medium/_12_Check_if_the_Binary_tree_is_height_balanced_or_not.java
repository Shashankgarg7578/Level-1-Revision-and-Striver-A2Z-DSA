package _03_BinaryTree._2_Medium;

class TreeNode11 {

	int data;
	TreeNode11 left;
	TreeNode11 right;

	public TreeNode11(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode11(int data, TreeNode11 left, TreeNode11 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _12_Check_if_the_Binary_tree_is_height_balanced_or_not {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode11 root = new TreeNode11(1);
		root.left = new TreeNode11(2);
		root.right = new TreeNode11(3);
		root.left.left = new TreeNode11(4);
		root.left.right = new TreeNode11(5);
		root.left.right.right = new TreeNode11(6);
		root.left.right.right.right = new TreeNode11(7);

		// Checking if the tree is balanced
		if (isBalanced(root)) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
	}

	// Time Complexity: O(N)
    // Space Complexity : O(1)
	private static boolean isBalanced(TreeNode11 root) {

		if (isBalancedCheck(root) == -1) {
			return false;
		}

		return true;
	}

	//code is same as just little change : Height of a BT
	private static int isBalancedCheck(TreeNode11 root) {
		if (root == null) {
			return 0;
		}
		int left = isBalancedCheck(root.left);
		int right = isBalancedCheck(root.right);

		//if any one give -1 height
		if (left == -1 || right == -1) {
			return -1;
		}

		//if abs is greater then height is -1
		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(left, right);
	}

}
