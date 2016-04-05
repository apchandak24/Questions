import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalTree {

	public VerticalOrderTraversalTree() {
		Tree root = new Tree(1);
//		root.left = new Tree(2);
//		root.right = new Tree(3);
//		root.left.right = new Tree(4);
//		root.left.right.right = new Tree(5);
//		root.left.right.right.right = new Tree(6);
		
//		root.left = new Tree(2);
//		root.right = new Tree(3);
//		root.left.left = new Tree(4);
//		root.left.right = new Tree(5);
//		root.right.left = new Tree(6);
//		root.right.right = new Tree(7);
		
		 root.left = new Tree(8);
	        root.right = new Tree(22);
	        root.left.left = new Tree(5);
	        root.left.right = new Tree(3);
	        root.right.left = new Tree(4);
	        root.right.right = new Tree(25);
	        root.left.right.left = new Tree(10);
	        root.left.right.right = new Tree(14);
		
		TreeMap<Integer, ArrayList<Tree>> map = new TreeMap<>();
		doVerticalTraversal(root, 0, map);
		for(Entry<Integer, ArrayList<Tree>> entry:map.entrySet()){
			System.out.println(entry.getValue().toString());
		}
		printTopViewOfTree(root);
		printBottomViewOfTree(root);
	}
	
	private void doVerticalTraversal(Tree root,int hd,TreeMap<Integer, ArrayList<Tree>> map){
		if(root==null)
			return;
		if(map.containsKey(hd)){
			map.get(hd).add(root);
		}else{
			ArrayList<Tree> list = new ArrayList<>();
			list.add(root);
			map.put(hd, list);
		}
		
		doVerticalTraversal(root.left, hd-1, map);
		doVerticalTraversal(root.right, hd+1, map);
	}
	
	private void printTopViewOfTree(Tree root){
		Queue<Tree> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		queue.add(root);
		ArrayList<Tree> list = new ArrayList<>();
		while(!queue.isEmpty()){
			Tree node = queue.poll();
			int hd = node.hd;
			if(!set.contains(hd)){
				set.add(hd);
				list.add(node);
			}
			if(node.left!=null){
				node.left.hd=hd-1;
				queue.add(node.left);
			}
			if(node.right!=null){
				node.right.hd=hd+1;
				queue.add(node.right);
			}
		}
		
		System.out.println("top view of tree "+list.toString());
		
	}
	
	private void printBottomViewOfTree(Tree root){
		TreeMap<Integer,Tree> map = new TreeMap<>();
		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Tree node = queue.poll();
			int hd = node.hd;
			map.put(hd, node);
			if(node.left!=null){
				node.left.hd=hd-1;
				queue.add(node.left);
			}
			if(node.right!=null){
				node.right.hd=hd+1;
				queue.add(node.right);
			}
			
		}
		System.out.print("Bottom up view of tree -- ");
		for(Entry<Integer,Tree> entry:map.entrySet()){
			System.out.print(entry.getValue().toString()+" ");
		}
		
		
	}
	

}

class Tree {
	int val;
	Tree left;
	Tree right;
	int hd;
	public Tree(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return val+"";
	}
}