package org.letsonlycode.kambv;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new BTNode(50);

        tree.root.left = new BTNode(30);
        tree.root.right = new BTNode(60);

        tree.root.left.left = new BTNode(5);
        tree.root.left.right = new BTNode(20);

        tree.root.right.left = new BTNode(45);
        tree.root.right.right = new BTNode(70);

        tree.root.right.right.left = new BTNode(65);
        tree.root.right.right.right = new BTNode(80);


        System.out.println(tree.getSizeOfLargestBST());
    }
}

// A Java program to introduce Binary Tree 
class BinaryTree
{
    // Root of Binary Tree 
    BTNode root;

    // Constructors 
    BinaryTree(int key)
    {
        root = new BTNode(key);
    }

    BinaryTree()
    {
        root = null;
    }

    public int max() {
        return max1(root);
    }

    public int max1(BTNode root) {
        return max0(root, Integer.MIN_VALUE);
    }

    public int max0(BTNode root, int v) {
        if(root == null)
            return v;
        else
            return Math.max(max0(root.left, root.key), max0(root.right, root.key));
    }

    public int min() {
        return min1(root);
    }

    public int min1(BTNode root) {
        return min0(root, Integer.MIN_VALUE);
    }

    public int min0(BTNode root, int v) {
        if(root == null)
            return v;
        else
            return Math.min(min0(root.left, root.key), min0(root.right, root.key));
    }

    private int getNodesCount(BTNode root) {

        if(root == null)
            return 0;
        return 1 + getNodesCount(root.left) + getNodesCount(root.right);
    }

    public int getSizeOfLargestBST(){
        return getSizeOfLargestBST1(root);
    }

    private int getSizeOfLargestBST1(BTNode root){
        if(isBST0(root)){
            return getNodesCount(root);
        }
        else{
            return Math.max(getSizeOfLargestBST1(root.left), getSizeOfLargestBST1(root.right));
        }
    }

    public boolean isBST(){
        return isBST0(root);
    }

    private boolean isBST0(BTNode root){
        if(root ==  null)
            return true;

        if(root.left != null && ( max1(root.left) > root.key || min1(root.right) < root.key))
            return false;

        if(!isBST0(root.left) || !isBST0(root.right)){
            return false;
        }

        return true;
    }
}

/* Class containing left and right child of current
node and key value*/
class BTNode
{
    int key;
    BTNode left, right;

    public BTNode(int item)
    {
        key = item;
        left = right = null;
    }

}