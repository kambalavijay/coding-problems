package org.letsonlycode.kambv;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeDriver{
	 
	public static void main(String a[]) {
		 
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
        
        bst.insert(10);
        bst.insert(20);
        bst.insert(21);
        bst.insert(8);
        bst.insert(9);
        bst.insert(6);
        bst.insert(16);
        bst.insert(23);
        
        System.out.println();

        System.out.println("Height: " + bst.height());
        System.out.println("\nWidth: " + bst.getMaxWidth());
        System.out.println();

        /*
        
        
        /*

        bst.preorderTraversal();
        System.out.println();
        
        bst.postorderTraversal();
        System.out.println();
       
        
        bst.printLevelOrder();
        System.out.println();
         */
        /*System.out.println("MinElement: " + bst.getMinElement());
        System.out.println("MaxElement: " + bst.getMaxElement());*/
	}
}


class BinarySearchTreeImpl {
	 
    private BstNode root;
    private int max_width = 0;
 
    public boolean isEmpty() {
        return (this.root == null);
    }

    public int getMaxWidth() {
        printLevelOrder();
        return max_width;
    }

    public void insert(Integer data) {
 
        System.out.print("[input: "+data+"]");
        if(root == null) {
            this.root = new BstNode(data);
            System.out.println("-> inserted: "+data);
            return;
        }
 
        insertNode(this.root, data);
        System.out.print("-> inserted: "+data);
        System.out.println();
    }
 
    private BstNode insertNode(BstNode root, Integer data) {
 
        BstNode tmpNode = null;
        System.out.print("->"+root.getData());
        if(root.getData() >= data) {
            System.out.print("[L]");
            if(root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print("[R]");
            if(root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
 
        return insertNode(tmpNode, data);
    }
    
    public int height() {
    	return getHeight(root);
    }
    
    private int getHeight(BstNode root) {
    	if(root == null)
    		return 0;
    	else {
    		int leftheight = getHeight(root.getLeft());
    		int rightHeight = getHeight(root.getRight());
    		return 1 + Math.max(leftheight, rightHeight);
    	}
	}
    
    public int countNodes() {
    	return getNodesCount(root);
    }
    
    private int getNodesCount(BstNode root) {
		
    	if(root == null)
    		return 0;
    	return 1 + getNodesCount(root.getLeft()) + getNodesCount(root.getRight());
	}
    
    public void preorderTraversal() {
    	traversePreorderly(root);
    }
    
    private void traversePreorderly(BstNode root) {
		if(root == null)
			return;
		
		System.out.print(root.getData() + " ");
		traversePreorderly(root.getLeft());
		traversePreorderly(root.getRight());
	}
    
    public void inorderTraversal() {
    	traverseInorderly(root);
    }
    
    private void traverseInorderly(BstNode root) {
		if(root == null)
			return;
		
		traverseInorderly(root.getLeft());
		System.out.print(root.getData() + " ");
		traverseInorderly(root.getRight());
	}
    
    public void postorderTraversal() {
    	traversePostorderly(root);
    }
    
    private void traversePostorderly(BstNode root) {
		if(root == null)
			return;
		
		traversePostorderly(root.getLeft());
		traversePostorderly(root.getRight());
		System.out.print(root.getData() + " ");
	}
    
    void printLevelOrder()
    {
        int max = Integer.MIN_VALUE;
        int h = getHeight(root);
        for (int i=1; i<=h; i++) {
            List elements = new ArrayList();
            printGivenLevel(root, i, elements);
            max = max > elements.size() ? max : elements.size();
        }
        max_width = max;
}
  
    /* Compute the "height" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
  
    /* Print nodes at the given level */
    void printGivenLevel (BstNode root, int level, List elements)
    {
        if (root == null) {
        	return;
        }
        if (level == 1) {
        	System.out.print( "(" + root.getData() + ") ");
            elements.add(root.getData());
        	return;
        }
        printGivenLevel(root.getLeft(), level-1, elements);
        printGivenLevel(root.getRight(), level-1, elements);
    }
    
    public int getMinElement() {
    	return minElement(root);
	}
    
    public int minElement(BstNode root) {
    	return root.getLeft() == null ? root.getData() : minElement(root.getLeft());
    }
    
    public int getMaxElement() {
    	return maxElement(root);
	}
    
    public int maxElement(BstNode root) {
    	return root.getRight() == null ? root.getData() : maxElement(root.getRight());
    }
    
    
    public void edgeTraversal() {
    	edgeTraversal1(root);
    }
    
	private void edgeTraversal1(BstNode root) {
		if(root == null)
			return;
	}
    
}


class BstNode {
	 
    private BstNode left;
    private BstNode right;
    private Integer data;
 
    public BstNode(Integer data) {
        this.data = data;
    }
 
    public BstNode getLeft() {
        return left;
    }
    public void setLeft(BstNode left) {
        this.left = left;
    }
    public BstNode getRight() {
        return right;
    }
    public void setRight(BstNode right) {
        this.right = right;
    }
 
    public Integer getData() {
        return data;
    }

	@Override
	public String toString() {
		return "BstNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}