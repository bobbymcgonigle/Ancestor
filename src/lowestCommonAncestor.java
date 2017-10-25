import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

// tree solution code
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
class DAGnode {
	ArrayList<DAGnode> parents;
	ArrayList<DAGnode> children;
	int data;
	String color;
	int count;

	public DAGnode() {		//make an empty node, initialize parents and children
		data = 0;
		color = "white";
		count = 0;
		parents = new ArrayList();
		children = new ArrayList();
	}

	public DAGnode(int input) {		//make a node with data, initialize parents and children
		data = input;
		color = "white";
		count = 0;
		parents = new ArrayList();
		children = new ArrayList();
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
	
	//this method takes an inputed node, and gives all of its ancestors a color, recursively
	
	
	void colorAllAncestors(DAGnode theNode, String nodeColor) {
		if (nodeColor != null) {
			if(theNode != null) {
				theNode.color = nodeColor;
				if (!theNode.parents.isEmpty()) {
					for (int i = 0; i < theNode.parents.size(); i++) {
						colorAllAncestors(theNode.parents.get(i), nodeColor);
					}
				}
			}
		}

	}
	
	//once one node has all of its ancestors colored, this goes and colors all the common ancestors a different color
	
	void colorAllCommonAncestors(DAGnode theNode, String newColor, String oldColor) {
		if (newColor != null && oldColor != null) {
			if(theNode != null) {
				if (theNode.color == oldColor) {
					theNode.color = newColor;
				}
				if (!theNode.parents.isEmpty()) {
					for (int i = 0; i < theNode.parents.size(); i++) {
						colorAllCommonAncestors(theNode.parents.get(i), newColor, oldColor);
					}
				}
				
			}
		}
	}
	
	//this method the parents of each common ancestor by one, leaving the least common ancestor(s) colored and with value 0
	
	void counting(DAGnode theNode, String theColor) {
		if (theNode != null && theColor != null) {
			if (!theNode.parents.isEmpty() && theNode.color == theColor) {
				for (int i = 0; i < theNode.parents.size(); i++) {
					theNode.parents.get(i).increment();
				}
			}
			for (int j = 0; j < theNode.children.size(); j++) {
				counting(theNode.children.get(j), theColor);
			}
		}

	}
	
	//this recursively travels through the list appending all found LCAs to an arraylist
	void findAnswers(DAGnode head, ArrayList<DAGnode> answers, String theColor){
		if(head != null && answers != null && theColor != null) {
			if(head.color == theColor && head.count == 0) {
				answers.add(head);
			}
			
			if(!head.children.isEmpty()) {
				for(int i = 0; i < head.children.size(); i++){
					findAnswers(head.children.get(i), answers, theColor);
				}
			}
		}
	}

	public ArrayList<DAGnode> lowestCommonAncestor(DAGnode head, DAGnode p, DAGnode q) {
		if(head != null && p != null && q != null) {
			ArrayList<DAGnode> lowestCommonAncestors = new ArrayList();
			if (p.data == q.data) {
				lowestCommonAncestors.add(p);
				return lowestCommonAncestors;
			}

			if (p.parents.isEmpty() && q.parents.isEmpty()) {
				return null;
			}

			if (p.parents.isEmpty() || q.parents.isEmpty()) {
				lowestCommonAncestors.add(p);
				return lowestCommonAncestors;
			}

			String pColor = "red";
			colorAllAncestors(p, pColor);

			String qColor = "blue";
			colorAllCommonAncestors(q, qColor, pColor);

			counting(head, qColor);
			
			findAnswers(head, lowestCommonAncestors, qColor);
			
			return lowestCommonAncestors;
		}
		else {
			return null;
		}
		
	}

}

//Dear person grading this, really sorry this is so long, decided to just take a glance at the problem and code it all myself.
//There is probably a lot of poor efficiency and needless code in here; I'm out of practice.

//Gonna test the solution in main using a DAG that looks as follows: https://i.stack.imgur.com/Cjn5H.png


public class lowestCommonAncestor {

	public static void main(String[] args) {
		/*
		DAGnode head = new DAGnode(0);
		DAGnode node1 = new DAGnode(1);
		DAGnode node2 = new DAGnode(2);
		DAGnode node3 = new DAGnode(3);
		DAGnode node4 = new DAGnode(4);
		DAGnode node5 = new DAGnode(5);
		
		head.addChild(node2);
		head.addChild(node1);
		
		node2.addChild(node3);
		node2.addChild(node5);
		
		node1.addChild(node5);
		node1.addChild(node4);
		
		node3.addChild(node4);
		
		
		
		ArrayList<DAGnode> myList = head.lowestCommonAncestor(head, node4, node5);
		
		
		
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i).data);
		}
		*/
		
		
		
		//testing the tree solution
		/*
		 * treeNode root = new treeNode(7); root.left = new treeNode(9);
		 * 
		 * treeNode Dave = new treeNode(5); root.right = Dave;
		 * 
		 * root.left.left = new treeNode(4); root.left.right = new treeNode(11);
		 * root.left.left.left = new treeNode(17); root.left.left.right = new
		 * treeNode(27); root.left.right.left = new treeNode(1); root.left.right.right =
		 * new treeNode(91); root.right.left = new treeNode(13); root.right.left.left =
		 * new treeNode(72);
		 * 
		 * treeNode Jack = new treeNode(14); root.right.left.right = Jack;
		 * 
		 * treeNode Fred = new treeNode(46); root.right.right = Fred;
		 * 
		 * root.right.right.left = new treeNode(12); root.right.right.right = new
		 * treeNode(3);
		 * 
		 * int result = root.lowestCommonAncestor(root, Jack, Fred).getData();
		 * System.out.print(result);
		 */
	}

}
