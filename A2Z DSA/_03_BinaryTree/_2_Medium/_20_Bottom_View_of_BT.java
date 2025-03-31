package _03_BinaryTree._2_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode19 {
	int data;
	TreeNode19 left;
	TreeNode19 right;

	public TreeNode19(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode19(int data, TreeNode19 left, TreeNode19 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _20_Bottom_View_of_BT {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode19 root = new TreeNode19(1);
		root.left = new TreeNode19(2);
		root.left.left = new TreeNode19(4);
		root.left.right = new TreeNode19(10);
		root.left.left.right = new TreeNode19(5);
		root.left.left.right.right = new TreeNode19(6);
		root.right = new TreeNode19(3);
		root.right.right = new TreeNode19(10);
		root.right.left = new TreeNode19(9);

		// Get the Bottom View traversal
		List<Integer> bottomView = bottomView(root);

		// Print the result
		System.out.println("Bottom View Traversal: ");
		for (int node : bottomView) {
			System.out.print(node + " ");
		}
	}

	static class Pair {
		TreeNode19 node;
		int line;

		public Pair(TreeNode19 node, int line) {
			this.node = node;
			this.line = line;
		}

	}

	private static List<Integer> bottomView(TreeNode19 root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			Pair pair = q.remove();

			TreeNode19 node = pair.node;

			int level = pair.line;

			//only this change in previous Question TopView
			map.put(level, node.data);

			if (node.left != null) {
				q.add(new Pair(node.left, level - 1));
			}
			if (node.right != null) {
				q.add(new Pair(node.right, level + 1));
			}
		}

		for (int a : map.values()) {
			ans.add(a);
		}

		return ans;
	}
}
