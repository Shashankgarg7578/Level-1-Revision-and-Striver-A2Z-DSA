package BinaryTree._3_Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class TreeNode29 {
	int data;
	TreeNode29 left;
	TreeNode29 right;

	public TreeNode29(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode29(int data, TreeNode29 left, TreeNode29 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _29_Construct_BT_from_Postorder_and_Inorder_Traversal {
	public static void main(String[] args) {
		Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(40, 20, 50, 10, 60, 30));
		Vector<Integer> postorder = new Vector<>(java.util.Arrays.asList(40, 50, 20, 60, 30, 10));

		System.out.print("Inorder Vector: ");
		printVector(inorder);

		System.out.print("Preorder Vector: ");
		printVector(postorder);

		TreeNode29 root = buildTree(postorder, inorder);

		System.out.println("Inorder of Unique Binary Tree Created:");
		printInorder(root);
		System.out.println();
	}

	private static void printVector(Vector<Integer> vec) {
		for (int i = 0; i < vec.size(); i++) {
			System.out.print(vec.get(i) + " ");
		}
		System.out.println();
	}

	private static void printInorder(TreeNode29 root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	private static TreeNode29 buildTree(Vector<Integer> postorder, Vector<Integer> inorder) {
		// inValue Index
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.size(); i++) {
			inMap.put(inorder.get(i), i);
		}

		TreeNode29 root = buildTree(postorder, 0, postorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);

		return root;
	}

	private static TreeNode29 buildTree(Vector<Integer> postorder, int postStart, int postEnd, Vector<Integer> inorder,
			int inStart, int inEnd, Map<Integer, Integer> inMap) {

		// Base case: If the start indices
		// exceed the end indices, return null
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}

		// Create a new TreeNode with value
		// at the current preorder index
		TreeNode29 root = new TreeNode29(postorder.get(postEnd));

		// Find the index of the current root
		// value in the inorder traversal
		int inRootIdx = inMap.get(root.data);

		// Calculate the number of
		// elements in the left subtree
		int numsLeft = inRootIdx - inStart;

		// Recursively build the left subtree
		root.left = buildTree(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRootIdx - 1, inMap);

		// Recursively build the right subtree
		root.right = buildTree(postorder, postStart + numsLeft, postEnd - 1, inorder, inRootIdx + 1, inEnd, inMap);

		return root;
	}

}