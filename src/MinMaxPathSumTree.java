public class MinMaxPathSumTree {

	public MinMaxPathSumTree() {
		
//		 Tree root = new Tree(15);
//		   root.left = new Tree(10);
//		   root.right = new Tree(20);
//		   root.right.left = new Tree(22);
//		   root.left.left = new Tree(6);
//		   root.left.right = new Tree(7);
//		   root.left.right.left = new Tree(2);
//		   root.left.right.right = new Tree(16);
//		   root.left.right.left.left = new Tree(0);
//		   root.left.right.left.right = new Tree(5);
//		   root.left.right.right.left = new Tree(3);
		
//		Tree root = new Tree(15);
//        root.left = new Tree(-2);
//        root.right = new Tree(7);
//        root.left.left = new Tree(8);
//        root.left.right = new Tree(-4);
		
		Tree root = new Tree(1);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.right = new Tree(-4);
		root.left.right.right = new Tree(-5);
		root.left.right.right.right = new Tree(6);
		   
		   System.out.println("Minimum sum path---- "+getMinimumPathSum(root));
	}
	
	
	private int getMinimumPathSum(Tree root){
		if(root==null)
			return 0;
		int sum = root.val;
		int lSum = getMinimumPathSum(root.left);
		int rSum = getMinimumPathSum(root.right);
		
		if(lSum<=rSum){
			sum+=lSum;
		}
		else{
			sum+=rSum;
		}
		return sum;
	}
	
}
