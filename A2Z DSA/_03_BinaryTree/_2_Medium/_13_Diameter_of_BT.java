package _03_BinaryTree._2_Medium;

class TreeNode12 {

	int data;
	TreeNode12 left;
	TreeNode12 right;

	public TreeNode12(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode12(int data, TreeNode12 left, TreeNode12 right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}

public class _13_Diameter_of_BT {
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode12 root = new TreeNode12(1);
		root.left = new TreeNode12(2);
		root.right = new TreeNode12(3);
		root.left.left = new TreeNode12(4);
		root.left.right = new TreeNode12(5);
		root.left.right.right = new TreeNode12(6);
		root.left.right.right.right = new TreeNode12(7);

		// Calculate the diameter of the binary tree
		int diameter = diameterOfBinaryTree(root);

		System.out.println("The diameter of the binary tree is: " + diameter);
	}

	static int maxDia = 0;

	// code is same as just little change : Height of a BT
	//Time Complexity: O(N) 
    //Space Complexity : O(1)
	private static int diameterOfBinaryTree(TreeNode12 root) {
		if (root == null) {
			return 0;
		}

		int lh = diameterOfBinaryTree(root.left);
		int rh = diameterOfBinaryTree(root.right);

		//this line we added
		maxDia = Math.max(maxDia, (lh + rh));

		return 1 + Math.max(lh, rh);
	}
}









