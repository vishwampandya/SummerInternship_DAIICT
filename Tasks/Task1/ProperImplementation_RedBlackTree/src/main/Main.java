package main;

public class Main {
public static void main(String args[]) {
    	
    	/*RedBlackTree<Integer>.Node root = null;
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
        

        root = redBlackTree.insert(root, 10);
        root = redBlackTree.insert(root, 15);
        root = redBlackTree.insert(root, -10);
        root = redBlackTree.insert(root, 20);
        root = redBlackTree.insert(root, 30);
        root = redBlackTree.insert(root, 40);
        root = redBlackTree.insert(root, 50);
        
        //redBlackTree.printRedBlackTree(root);

        root = redBlackTree.delete(root, 50);
        if(redBlackTree.validateRedBlackTree(root)){
        	System.out.println("This is a red black tree");
        }
        else{
        	System.out.println("Some rules are voilated , this is not a red black tree");
        }*/
    	
    	
    	
    	
    	RedBlackTree<String>.Node root = null;
        RedBlackTree<String> redBlackTree = new RedBlackTree<String>();
        

        root = redBlackTree.insert(root, "Vishwam");
        root = redBlackTree.insert(root, "pandya");
        root = redBlackTree.insert(root, "hat");
        root = redBlackTree.insert(root, "cat");
        
        
        //redBlackTree.printRedBlackTree(root);

        root = redBlackTree.delete(root, "cat");
        if(redBlackTree.validateRedBlackTree(root)){
        	System.out.println("This is a red black tree");
        }
        else{
        	System.out.println("Some rules are voilated , this is not a red black tree");
        }
    }
}
