package BinaryTree._3_Hard;

class TreeNode25 {
	int data;
	TreeNode25 left;
	TreeNode25 right;

	public TreeNode25(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode25(int data, TreeNode25 left, TreeNode25 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _25_Check_for_Children_Sum_Property {
	public static void main(String[] args) {
		// Create the binary tree
		TreeNode25 root = new TreeNode25(3);
		root.left = new TreeNode25(5);
		root.right = new TreeNode25(1);
		root.left.left = new TreeNode25(6);
		root.left.right = new TreeNode25(2);
		root.right.left = new TreeNode25(0);
		root.right.right = new TreeNode25(8);
		root.left.right.left = new TreeNode25(7);
		root.left.right.right = new TreeNode25(4);

		// Print the inorder traversal
		// of tree before modification
		System.out.print("Binary Tree before modification: ");
		inorderTraversal(root);
		System.out.println();

		// Call the changeTree function
		// to modify the binary tree
		changeTree(root);

		// Print the inorder traversal
		// after modification
		System.out.print("Binary Tree after Children Sum Property: ");
		inorderTraversal(root);
		System.out.println();
	}

	private static void changeTree(TreeNode25 root) {
		if (root == null) {
			return;
		}

		// check if childSum is greater
		int childSum = 0;
		if (root.left != null) {
			childSum += root.left.data;
		}
		if (root.right != null) {
			childSum += root.right.data;
		}

		if (childSum >= root.data) {
			// check if childSum is greater then change root
			root.data = childSum;
		} else {
			// check if root is greater then change left, right
			if (root.left != null) {
				root.left.data = root.data;
			}
			if (root.right != null) {
				root.right.data = root.data;
			}
		}

		changeTree(root.left);
		changeTree(root.right);

		// change root
		int tot = 0;
		if (root.left != null) {
			tot += root.left.data;
		}
		if (root.right != null) {
			tot += root.right.data;
		}

		// check left or right should exist
		// because we update only non leaf node
		if (root.left != null || root.right != null) {
			root.data = tot;
		}
	}

	private static void inorderTraversal(TreeNode25 root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);

	}
}
