import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class lowestCommonAncestorTest {
	/*
	@Test
	public void treeNodeTest() {
		treeNode tester = new treeNode();
		assertEquals(tester.left, null);
		assertEquals(tester.right, null);
		assertEquals(tester.data, 0);
		
		tester.addData(2);
		assertEquals(tester.data, 2);
		
		assertEquals(tester.getLeft(), null);
		assertEquals(tester.getRight(), null);
		
		treeNode tester2 = new treeNode(5);
		assertEquals(tester2.data, 5);
		
		tester2.addLeft(new treeNode(17));
		assertEquals(tester2.getLeft().getData(), 17);
		
		tester2.addRight(new treeNode(15));
		assertEquals(tester2.getRight().getData(), 15);
	}
	
	@Test
	public void lcaTest() {
		treeNode root = null;
		treeNode thing = new treeNode(18);
		assertEquals(thing.lowestCommonAncestor(root, null, null), null);
		assertEquals(thing.lowestCommonAncestor(thing, null, null), null);
		assertEquals(thing.lowestCommonAncestor(thing, thing, thing), thing);
		assertEquals(thing.lowestCommonAncestor(thing, thing, null), thing);
		assertEquals(thing.lowestCommonAncestor(thing, null, thing), thing);
		assertEquals(thing.lowestCommonAncestor(null, null, null), null);
	*/
		/*Explanation of this test
		 * 
		 * !!!All of the nodes to the left of 7 are irrelevant as I didn't use them in the test but they are written in the code
		 * just in case I decide to write more tests
		 *     
		 * 
		 *       			(7)
		 *      		   /   \
		 *     	        (9)   (5) <-DAVE
		 *                   /   \
		 * 				 (13)     (46)<-Fred
		 * 				/   \     /   \
		 * 			  (72)  (14) (12) (3)
		 *                   ^
		 *                   |
		 *                  JACK
		 *                  
		 * Therefore, the least common ancestor of Fred and Jack should be Dave.
		 * For some reason, when I commit this to github the formatting goes all funky.
		 * So, for easier reference, Dave is 5, Fred is 46, and Jack is 14
		 */
	
		/*
		treeNode root1 = new treeNode(7);
		root1.left = new treeNode(9);
		
		treeNode Dave = new treeNode(5);
		root1.right = Dave;
		
		root1.left.left = new treeNode(4);
		root1.left.right = new treeNode(11);
		root1.left.left.left = new treeNode(17);
		root1.left.left.right = new treeNode(27);
		root1.left.right.left = new treeNode(1);
		root1.left.right.right = new treeNode(91);
		root1.right.left = new treeNode(13);
		root1.right.left.left = new treeNode(72);
		
		treeNode Jack = new treeNode(14);
		root1.right.left.right = Jack;
		
		treeNode Fred = new treeNode(46);
		root1.right.right = Fred;
		
		root1.right.right.left = new treeNode(12);
		root1.right.right.right = new treeNode(3);
		
		int result = root1.lowestCommonAncestor(root1, Jack, Fred).getData();
		assertEquals(result, Dave.getData());
		
	
	
	}
	*/

	
	@Test
	public void DAGnodeTest() {
		DAGnode tester = new DAGnode();
		assertEquals(tester.parents.isEmpty(), true);
		assertEquals(tester.children.isEmpty(), true);
		assertEquals(tester.data, 0);
		assertEquals(tester.color, "white");
		assertEquals(tester.count, 0);
		
		tester.data = 2;
		assertEquals(tester.data, 2);
		
		tester.addColor("green");
		assertEquals(tester.color, "green");
		
		tester.increment();
		tester.increment();
		tester.increment();
		assertEquals(tester.count, 3);
		
		DAGnode tester2 = new DAGnode(5);
		assertEquals(tester2.data, 5);
		
		tester.addChild(tester2);
		assertEquals(tester2.parents.get(0), tester);
		assertEquals(tester.children.get(0), tester2);
	}
	
	//outlined in main, but the graph I'm using to test from the beginning can be found here: https://i.stack.imgur.com/Cjn5H.png
	@Test
	public void lowestCommonAncestorDAGTest() {
		
		DAGnode head = new DAGnode(0);
		
		ArrayList<DAGnode> myList= head.lowestCommonAncestor(head, head, head);
		assertEquals(myList.get(0), head);
		
		ArrayList<DAGnode> myList1= head.lowestCommonAncestor(null, null, null);
		assertEquals(myList1, null);
		
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
		
		ArrayList<DAGnode> myList2= head.lowestCommonAncestor(head, node4, node5);
		
		assertEquals(myList2.get(0), node2);
		assertEquals(myList2.get(1), node1);
		
		ArrayList<DAGnode> myList3 = head.lowestCommonAncestor(head, node4, node4);
		assertEquals(myList3.get(0), node4);
		
		ArrayList<DAGnode> myList4 = head.lowestCommonAncestor(null, node4, node4);
		assertEquals(myList4, null);
		
		ArrayList<DAGnode> myList5 = head.lowestCommonAncestor(head, null, node4);
		assertEquals(myList5, null);
		
		//two nodes with no parents
		DAGnode head1 = new DAGnode(17);
		DAGnode head2 = new DAGnode(18);
		
		ArrayList myList6 = head1.lowestCommonAncestor(head1, head1, head2);
		assertEquals(myList6, null);
		
		//two nodes where one is the head and one is the parent
		head2.parents.add(head1);
		
		ArrayList myList7 = head1.lowestCommonAncestor(head1, head1, head2);
		assertEquals(myList7.get(0), head1);
		
		ArrayList myList8 = head1.lowestCommonAncestor(head1, head2, head1);
		assertEquals(myList8.get(0), head1);
		
		
	}
}
