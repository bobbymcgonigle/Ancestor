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

