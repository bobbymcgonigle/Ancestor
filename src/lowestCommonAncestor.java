 import java.util.Scanner;
 import java.util.Arrays;
 import java.util.ArrayList;
 

/*
class treeNode{
	treeNode left, right;
	int data;
	
	public treeNode() {
		left = null;
		right = null;
		data= 0;
	}
	
	public treeNode(int n) {
		left = null;
		right = null;
		data = n;
	}
	
	void addLeft(treeNode leftNode) {
		left = leftNode;
	}
	
	void addRight(treeNode rightNode) {
		right = rightNode;
	}
	
	treeNode getLeft() {
		return left;
	}
	
	treeNode getRight() {
		return right;
	}
	
	void addData(int n) {
		data = n;
	}
	
	int getData() {
		return data;
	}
	//found at: https://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/
	
	public treeNode lowestCommonAncestor(treeNode root, treeNode p, treeNode q) {
	    if(root==null)
	        return null;
	 
	    if(root==p || root==q)
	        return root;
	 
	    treeNode l = lowestCommonAncestor(root.left, p, q);
	    treeNode r = lowestCommonAncestor(root.right, p, q);
	 
	    if(l!=null&&r!=null){
	        return root;
	    }else if(l==null&&r==null){
	        return null;
	    }else{
	        return l==null?r:l;
	    }
	}
}
*/
 class DAGnode{
	 ArrayList<DAGnode> parents;
	 ArrayList<DAGnode> children;
	 int data;
	 String color;
	 int count;
	 
	 public DAGnode() {
		 data = 0;
		 color = "white";
		 count = 0;
		 parents = null;
		 children = null;
	 }
	 
	 public DAGnode(int input) {
		 data = input;
		 color = "white";
		 count = 0;
		 parents = null;
		 children = null;
	 }
	 
	 void addChild(DAGnode child) {
		 children.add(child);
		 child.parents.add(this);
	 }
	 
	 void addColor(String input) {
		 color = input;
	 }
	 
	 void increment() {
		 count++;
	 }
	 
	 
 }
 

public class lowestCommonAncestor {

	public static void main(String[] args) {
		/*
		treeNode root = new treeNode(7);
		root.left = new treeNode(9);
		
		treeNode Dave = new treeNode(5);
		root.right = Dave;
		
		root.left.left = new treeNode(4);
		root.left.right = new treeNode(11);
		root.left.left.left = new treeNode(17);
		root.left.left.right = new treeNode(27);
		root.left.right.left = new treeNode(1);
		root.left.right.right = new treeNode(91);
		root.right.left = new treeNode(13);
		root.right.left.left = new treeNode(72);
		
		treeNode Jack = new treeNode(14);
		root.right.left.right = Jack;
		
		treeNode Fred = new treeNode(46);
		root.right.right = Fred;
		
		root.right.right.left = new treeNode(12);
		root.right.right.right = new treeNode(3);
		
		int result = root.lowestCommonAncestor(root, Jack, Fred).getData();
		System.out.print(result);
		*/
	}
	
}

