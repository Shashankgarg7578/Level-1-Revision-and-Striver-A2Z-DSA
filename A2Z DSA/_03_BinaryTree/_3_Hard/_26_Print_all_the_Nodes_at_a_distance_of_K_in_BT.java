package _03_BinaryTree._3_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode26 {
	int data;
	TreeNode26 left;
	TreeNode26 right;

	public TreeNode26(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode26(int data, TreeNode26 left, TreeNode26 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class _26_Print_all_the_Nodes_at_a_distance_of_K_in_BT {
	public static void main(String[] args) {
		TreeNode26 root = new TreeNode26(3);
		root.left = new TreeNode26(5);
		root.right = new TreeNode26(1);
		root.left.left = new TreeNode26(6);
		root.left.right = new TreeNode26(2);
		root.right.left = new TreeNode26(0);
		root.right.right = new TreeNode26(8);
		root.left.right.left = new TreeNode26(7);
		root.left.right.right = new TreeNode26(4);

		int k = 2; // distance

		List<Integer> ans = distanceK(root, root.left, k);

		for (Integer a : ans) {
			System.out.println(a);
		}
	}

	public static List<Integer> distanceK(TreeNode26 root, TreeNode26 target, int k) {

		Map<TreeNode26, TreeNode26> parent_map = new HashMap<TreeNode26, TreeNode26>();
		// make child-parent map
		markParentNodes(root, parent_map);

		Map<TreeNode26, Boolean> vis = new HashMap<TreeNode26, Boolean>();
		Queue<TreeNode26> queue = new LinkedList<TreeNode26>();

		queue.offer(target);

		vis.put(target, true);

		int curr_level = 0;
		while (!queue.isEmpty()) {

			int qsize = queue.size();

			if (curr_level == k)
				break;

			curr_level++;

			for (int i = 0; i < qsize; i++) {
				TreeNode26 tmpNode = queue.poll();

				if (tmpNode.left != null && vis.get(tmpNode.left) == null) {
					vis.put(tmpNode.left, true);
					queue.add(tmpNode.left);
				}
				if (tmpNode.right != null && vis.get(tmpNode.right) == null) {
					vis.put(tmpNode.right, true);
					queue.add(tmpNode.right);
				}
				if (parent_map.get(tmpNode) != null && vis.get(parent_map.get(tmpNode)) == null) {
					vis.put(parent_map.get(tmpNode), true);
					queue.offer(parent_map.get(tmpNode));
				}
			}

		}

		List<Integer> ans = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			TreeNode26 temp = queue.poll();
			ans.add(temp.data);
		}
		
		return ans;
	}

	private static void markParentNodes(TreeNode26 root, Map<TreeNode26, TreeNode26> parent_map) {
		Queue<TreeNode26> queue = new LinkedList<TreeNode26>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode26 tempNode = queue.poll();

			if (tempNode.left != null) {
				queue.offer(tempNode.left);
				parent_map.put(tempNode.left, tempNode);
			}
			if (tempNode.right != null) {
				queue.offer(tempNode.right);
				parent_map.put(tempNode.right, tempNode);
			}
		}

	}

}
