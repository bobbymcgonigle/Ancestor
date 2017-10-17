 import java.util.Scanner;
 
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

class tree{
	treeNode root;
	
	public tree() {
		root = null;
	}
	
	public tree(treeNode node) {
		root = node;
	}
	
}
public class lowestCommonAncestor {

	public static void main(String[] args) {
		

	}
	
}

