package BinaryTree._2_Medium;

class TreeNode14 {

	int data;
	TreeNode14 left;
	TreeNode14 right;

	public TreeNode14(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode14(int data, TreeNode14 left, TreeNode14 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _15_Check_if_two_trees_are_identical_or_not {
	public static void main(String[] args) {
		// Node1
		TreeNode14 root1 = new TreeNode14(1);
		root1.left = new TreeNode14(2);
		root1.right = new TreeNode14(3);
		root1.left.left = new TreeNode14(4);

		// Node2
		TreeNode14 root2 = new TreeNode14(1);
		root2.left = new TreeNode14(2);
		root2.right = new TreeNode14(3);
		root2.left.left = new TreeNode14(4);

		if (isIdentical(root1, root2)) {
			System.out.println("The binary trees are identical.");
		} else {
			System.out.println("The binary trees are not identical.");
		}
	}

	private static boolean isIdentical(TreeNode14 root1, TreeNode14 root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}
		
		return ((root1.data == root2.data) && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right));
	}
}
