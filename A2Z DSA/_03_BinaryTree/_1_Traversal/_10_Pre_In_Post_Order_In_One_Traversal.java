package _03_BinaryTree._1_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode09 {

	int data;
	TreeNode09 left;
	TreeNode09 right;

	public TreeNode09(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode09(int data, TreeNode09 left, TreeNode09 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _10_Pre_In_Post_Order_In_One_Traversal {

	// Function to print the elements of a list
	public static void printList(List<Integer> list) {
		// Iterate through the list
		// and print each element
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	// Main function
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode09 root = new TreeNode09(1);
		root.left = new TreeNode09(2);
		root.right = new TreeNode09(3);
		root.left.left = new TreeNode09(4);
		root.left.right = new TreeNode09(5);

		// Getting the pre-order, in-order,
		// and post-order traversals
		List<Integer> pre, in, post;
		List<List<Integer>> traversals = preInPostTraversal(root);

		// Extracting the traversals
		// from the result
		pre = traversals.get(0);
		in = traversals.get(1);
		post = traversals.get(2);

		// Printing the traversals
		System.out.print("Preorder traversal: ");
		printList(pre);

		System.out.print("Inorder traversal: ");
		printList(in);

		System.out.print("Postorder traversal: ");
		printList(post);
	}

	static class Pair {
		TreeNode09 node;
		int count;

		public Pair() {
		}

		public Pair(TreeNode09 node, int count) {

			this.node = node;
			this.count = count;
		}
	}

//	Time Complexity: O(3N) 
//	Space Complexity: O(4N)
	private static List<List<Integer>> preInPostTraversal(TreeNode09 root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> pre = new ArrayList<Integer>();
		List<Integer> in = new ArrayList<Integer>();
		List<Integer> post = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<Pair>();
		st.push(new Pair(root, 1));

		while (st.size() > 0) {

			Pair it = st.pop();

			if (it.count == 1) {
				pre.add(it.node.data);
				it.count++;
				st.push(it);

				if (it.node.left != null) {
					st.push(new Pair(it.node.left, 1));
				}
			} else if (it.count == 2) {
				in.add(it.node.data);
				it.count++;
				st.push(it);

				if (it.node.right != null) {
					st.push(new Pair(it.node.right, 1));
				}

			} else if (it.count == 3) {
				post.add(it.node.data);
			}

		}

		ans.add(pre);
		ans.add(in);
		ans.add(post);
		return ans;
	}
}
