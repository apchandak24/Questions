class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	int height;

	public TreeNode(int val) {
		this.val = val;
		height = 1;
	}

}

public class AVLTree {

	public AVLTree() {

		TreeNode root = insert(null, 8);
		preOrder(root);
		System.out.println();
		root = insert(root, 10);
		preOrder(root);
		System.out.println();
		root = insert(root, 20);
		preOrder(root);
		System.out.println();
		root = insert(root, 5);
		preOrder(root);
		System.out.println();
		root = insert(root, 7);
		preOrder(root);
		System.out.println();
		root = insert(root, 4);
		root = insert(root, 9);
		preOrder(root);

	}

	private int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private TreeNode insert(TreeNode root, int val) {

		if (root == null) {
			TreeNode n = new TreeNode(val);
			return n;
		}
		if (val < root.val)
			root.left = insert(root.left, val);
		else
			root.right = insert(root.right, val);

		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

		int balanceF = getHeight(root.left) - getHeight(root.right);

		if (balanceF > 1 && val < root.left.val)
			return rightRotate(root);
		else if (balanceF < -1 && val > root.right.val)
			return leftRotate(root);
		else if (balanceF > 1 && val > root.left.val) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		} else if (balanceF < -1 && val < root.right.val) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	private TreeNode leftRotate(TreeNode node) {
		TreeNode r = node.right;
		TreeNode r_l = r.left;

		r.left = node;
		node.right = r_l;

		r.height = Math.max(getHeight(r.left), getHeight(r.right)) + 1;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		return r;

	}

	private TreeNode rightRotate(TreeNode node) {
		TreeNode l = node.left;
		TreeNode l_r = l.right;

		l.right = node;
		node.left = l_r;
		l.height = Math.max(getHeight(l.left), getHeight(l.right)) + 1;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		return l;
	}

	private void preOrder(TreeNode root) {

		if (root != null)
			System.out.print(root.val + " ");
		else {

			return;
		}
		preOrder(root.left);
		preOrder(root.right);
	}

}
