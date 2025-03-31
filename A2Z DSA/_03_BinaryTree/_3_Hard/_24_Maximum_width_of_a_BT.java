package _03_BinaryTree._3_Hard;

import java.util.LinkedList;
import java.util.Queue;

//TreeNode structure
class TreeNode24 {
	int val;
	TreeNode24 left;
	TreeNode24 right;

	TreeNode24(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class _24_Maximum_width_of_a_BT {
	public static void main(String[] args) {
		TreeNode24 root = new TreeNode24(3);
		root.left = new TreeNode24(5);
		root.right = new TreeNode24(1);
		root.left.left = new TreeNode24(6);
		root.left.right = new TreeNode24(2);
		root.right.left = new TreeNode24(0);
		root.right.right = new TreeNode24(8);
		root.left.right.left = new TreeNode24(7);
		root.left.right.right = new TreeNode24(4);

		int maxWidth = widthOfBinaryTree(root);

		System.out.println("Maximum width of the binary tree is: " + maxWidth);
	}

	public static class Pair {
		TreeNode24 node;
		int num; //index

		Pair(TreeNode24 node, int num) {
			this.node = node;
			this.num = num;
		}
	}

	// Function widthOfBinaryTree to find the
	// maximum width of the Binary Tree
	public static int widthOfBinaryTree(TreeNode24 root) {

		if (root == null) {
			return 0;
		}

		int ans = 0;

		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			int qsize = queue.size();
			
			//get min pos from front because
			//everytime it is on front
			int mmin = queue.peek().num;
			
			// Store the first and last positions
            // of nodes in the current level
			int first = 0, last = 0;

			for (int i = 0; i < qsize; i++) {
				//for always start new level by 0, because if we map all nodes by number then it will exceed
				int currIdx = queue.peek().num - mmin;

				TreeNode24 curNode = queue.peek().node;

				queue.poll();

				if (i == 0) {
					first = currIdx;
				}

				if (i == qsize - 1) {
					last = currIdx;
				}

				//add left child by formula
				if (curNode.left != null) {
					queue.add(new Pair(curNode.left, 2 * currIdx + 1));
				}

				//add right child by formula
				if (curNode.right != null) {
					queue.add(new Pair(curNode.right, 2 * currIdx + 2));
				}

			}

			//formula for find max node on level
			ans = Math.max(ans, last - first + 1);
		}

		return ans;
	}

}
