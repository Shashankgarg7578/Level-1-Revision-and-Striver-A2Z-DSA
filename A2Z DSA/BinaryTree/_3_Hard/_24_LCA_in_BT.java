package BinaryTree._3_Hard;

class TreeNode23 {
	int data;
	TreeNode23 left;
	TreeNode23 right;

	public TreeNode23(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode23(int data, TreeNode23 left, TreeNode23 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _24_LCA_in_BT {
	public static void main(String[] args) {
		TreeNode23 root = new TreeNode23(3);
		root.left = new TreeNode23(5);
		root.right = new TreeNode23(1);
		root.left.left = new TreeNode23(6);
		root.left.right = new TreeNode23(2);
		root.right.left = new TreeNode23(0);
		root.right.right = new TreeNode23(8);
		root.left.right.left = new TreeNode23(7);
		root.left.right.right = new TreeNode23(4);

		TreeNode23 p = root.right.left;

		TreeNode23 q = root.left.right.left;

		TreeNode23 ans = lowestCommonAncestor(root, p, q);

		System.out.println(ans.data);

	}

	// Time complexity: O(N) where n is the number of nodes.
	// Space complexity: O(N), auxiliary space.
	public static TreeNode23 lowestCommonAncestor(TreeNode23 root, TreeNode23 p, TreeNode23 q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode23 left = lowestCommonAncestor(root.left, p, q);
		TreeNode23 right = lowestCommonAncestor(root.right, p, q);

		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return root;
		}
	}

}
