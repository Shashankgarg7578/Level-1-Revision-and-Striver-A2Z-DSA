package _03_BinaryTree._3_Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class TreeNode28 {
	int data;
	TreeNode28 left;
	TreeNode28 right;

	public TreeNode28(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode28(int data, TreeNode28 left, TreeNode28 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _28_Construct_BT_from_Preorder_and_Inorder_Traversal {
	public static void main(String[] args) {
		Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(9, 3, 15, 20, 7));
		Vector<Integer> preorder = new Vector<>(java.util.Arrays.asList(3, 9, 20, 15, 7));

		System.out.print("Inorder Vector: ");
		printVector(inorder);

		System.out.print("Preorder Vector: ");
		printVector(preorder);

		TreeNode28 root = buildTree(preorder, inorder);

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

	private static void printInorder(TreeNode28 root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	private static TreeNode28 buildTree(Vector<Integer> preorder, Vector<Integer> inorder) {
		// inValue Index
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.size(); i++) {
			inMap.put(inorder.get(i), i);
		}

		TreeNode28 root = buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);

		return root;
	}

	private static TreeNode28 buildTree(Vector<Integer> preorder, int preStart, int preEnd, Vector<Integer> inorder,
			int inStart, int inEnd, Map<Integer, Integer> inMap) {

		// Base case: If the start indices
        // exceed the end indices, return null
		if(preStart > preEnd || inStart > inEnd) {
			return null;
		}
		
		// Create a new TreeNode with value
        // at the current preorder index
		TreeNode28 root = new TreeNode28(preorder.get(preStart));

		// Find the index of the current root
        // value in the inorder traversal
		int inRootIdx = inMap.get(root.data);

		// Calculate the number of
        // elements in the left subtree
		int numsLeft = inRootIdx - inStart;
		
		 // Recursively build the left subtree
		root.left = buildTree(preorder, preStart + 1, preEnd + numsLeft, inorder, inStart, inRootIdx - 1, inMap);
		
		 // Recursively build the right subtree
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRootIdx + 1, inEnd, inMap);

		return root;
	}

}
