package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.RedBlackTree;

public class test1 {

	@Test
	public void test() {
		RedBlackTree<Integer>.Node root = null;
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
        
        redBlackTree.insert(2);
        //assertTrue(redBlackTree.searchTree(root, 2));
        
//        root = redBlackTree.insert(root, 44);
//        assertTrue(redBlackTree.find(root, 44));
        
        redBlackTree.insert(-2);
        //assertTrue(redBlackTree.find(root, -2));
        
        redBlackTree.insert(200);
       // assertTrue(redBlackTree.find(root, 200));
        
       // assertFalse(redBlackTree.find(root, 55));
        
        
       // assertTrue(redBlackTree.validateRedBlackTree(root));
	}

}
