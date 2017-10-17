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
		
		
	}


}
