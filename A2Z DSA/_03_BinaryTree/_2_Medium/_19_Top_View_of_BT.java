package _03_BinaryTree._2_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode18 {
	int data;
	TreeNode18 left;
	TreeNode18 right;

	public TreeNode18(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode18(int data, TreeNode18 left, TreeNode18 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _19_Top_View_of_BT {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode18 root = new TreeNode18(1);
		root.left = new TreeNode18(2);
		root.left.left = new TreeNode18(4);
		root.left.right = new TreeNode18(10);
		root.left.left.right = new TreeNode18(5);
		root.left.left.right.right = new TreeNode18(6);
		root.right = new TreeNode18(3);
		root.right.right = new TreeNode18(10);
		root.right.left = new TreeNode18(9);

		// Get the top view traversal
		List<Integer> topView = topView(root);

		// Print the result
		System.out.println("Vertical Traversal: ");
		for (int node : topView) {
			System.out.print(node + " ");
		}
	}

	static class Pair {
		TreeNode18 node;
		int line;

		public Pair(TreeNode18 node, int line) {
			this.node = node;
			this.line = line;
		}

	}

	private static List<Integer> topView(TreeNode18 root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		Queue<Pair> q = new LinkedList<_19_Top_View_of_BT.Pair>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			Pair pair = q.remove();

			TreeNode18 node = pair.node;

			int level = pair.line;

			if (!map.containsKey(level)) {
				map.put(level, node.data);
			}

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
