package BinaryTree._2_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode17 {
	int data;
	TreeNode17 left;
	TreeNode17 right;

	public TreeNode17(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode17(int data, TreeNode17 left, TreeNode17 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _18_Vertical_Order_Traversal_of_BT {
	private static void printResult(List<List<Integer>> result) {
		for (List<Integer> level : result) {
			for (int node : level) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode17 root = new TreeNode17(1);
		root.left = new TreeNode17(2);
		root.left.left = new TreeNode17(4);
		root.left.right = new TreeNode17(10);
		root.left.left.right = new TreeNode17(5);
		root.left.left.right.right = new TreeNode17(6);
		root.right = new TreeNode17(3);
		root.right.right = new TreeNode17(10);
		root.right.left = new TreeNode17(9);

		// Get the Vertical traversal
		List<List<Integer>> verticalTraversal = findVertical(root);

		// Print the result
		System.out.print("Vertical Traversal: ");
		printResult(verticalTraversal);
	}

	static class Tuple {

		TreeNode17 node;
		int v; // vertices
		int l; // level

		public Tuple(TreeNode17 node, int v, int l) {
			this.node = node;
			this.v = v;
			this.l = l;
		}
	}

//	Time Complexity: O(N * log2N * log2N * log2N) 
//	Space Complexity: O(N + N/2)
	//Level Order Traversal
	private static List<List<Integer>> findVertical(TreeNode17 root) {
              //vertical,         level          nodes
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();

		Queue<Tuple> queue = new LinkedList<_18_Vertical_Order_Traversal_of_BT.Tuple>();
		queue.offer(new Tuple(root, 0, 0));

		while (!queue.isEmpty()) {
			Tuple tuple = queue.poll();

			TreeNode17 node = tuple.node;
			int vertice = tuple.v;
			int level = tuple.l;

			if (!map.containsKey(vertice)) {
				map.put(vertice, new TreeMap<>());
			}

			if (!map.get(vertice).containsKey(level)) {
				map.get(vertice).put(level, new PriorityQueue<Integer>());
			}

			map.get(vertice).get(level).offer(node.data);

			if (node.left != null) {
				queue.offer(new Tuple(node.left, vertice - 1, level + 1));
			}

			if (node.right != null) {
				queue.offer(new Tuple(node.right, vertice + 1, level + 1));
			}
		}

		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		for (TreeMap<Integer, PriorityQueue<Integer>> entrySet : map.values()) {

			ans.add(new ArrayList<Integer>());

			for (PriorityQueue<Integer> pq : entrySet.values()) {

				while (!pq.isEmpty()) {
					System.out.println(pq.peek());
					ans.get(ans.size() - 1).add(pq.poll());
				}
			}
		}

		return ans;
	}
}
