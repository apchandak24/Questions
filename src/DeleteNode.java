
public class DeleteNode {

	public DeleteNode() {
		TreeNod tree = new TreeNod(50);
		 
        /*  BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
		tree.left = new TreeNod(30);
		tree.left.left=new TreeNod(20);
		tree.left.right = new TreeNod(40);
		
		tree.right = new TreeNod(70);
		tree.right.left=new TreeNod(60);
		tree.right.right = new TreeNod(80);
		printNodes(tree);
		System.out.println();
		TreeNod root = deleteNode(tree, 50);
		
		printNodes(root);
	}
	
	
	private TreeNod deleteNode(TreeNod root,int key) {
		if(root==null)
			return null;
		if(root.val<key)
			root.right = deleteNode(root.right, key);
		else if(root.val>key)
			root.left = deleteNode(root.left, key);
		else{
			
			if(root.left==null)
				return root.right;
			if(root.right==null)
				return root.left;
			
			root.val = findInorderSuccessor(root.right);
			
			root.right = deleteNode(root.right, root.val);
			
		}
		return root;
			
	}
	
	private int findInorderSuccessor(TreeNod root){
		TreeNod temp = root;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.val;
	}
	private void printNodes(TreeNod root){
		if(root==null)
			return;
		printNodes(root.left);
		System.out.print(" "+root.val);
		printNodes(root.right);
	}
	
}

class TreeNod {
	int val;
	TreeNod left;
	TreeNod right;

	public TreeNod(int val) {
		this.val = val;
	}

}