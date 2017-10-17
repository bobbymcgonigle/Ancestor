import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lowestCommonAncestorTest {

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


}
