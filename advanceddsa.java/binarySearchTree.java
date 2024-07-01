import java.util.*;
public class binarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node buildBST(Node root,int val){
        if (root==null) {
            root=new Node(val);
            return root;
        }
        if (root.data>val) {
            root.left=buildBST(root.left, val);
        }
        else {
            root.right=buildBST(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
       
        inorder(root.left);
        System.out.print(root.data+"->");
        inorder(root.right);
         
        
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    public static Node delete(Node root,int val){
        if (root.data<val) {
            root.right=delete(root.right, val);
        }
        else if (root.data>val) {
            root.left=delete(root.left, val);
        }
        else{
            //case:1=deleting leaf node
            if (root.left==null&&root.right==null) {
                return null;
            }
            //case:2=single child of node
            if (root.left==null) {
                return root.right;
            }
            else if (root.right==null) {
                return root.right;
            }
            //case:3= 2 children of a node 
            Node inorderSuccessor=findInordeSuccessor(root.right);
            //inorder successor is the left most node 
            //in right subtree of the node->min value in the right subtree is going to be its inorder successor
            root.data=inorderSuccessor.data;
            root.right=delete(root.right, inorderSuccessor.data);
        }
        return root;
    }
    public static Node findInordeSuccessor(Node root){
        while (root.left!=null) {
            root=root.left;
        }
        return root;

    }
    public static void printInRange(Node root,int k1,int k2){
        if (root==null) {
            return;
        }
        if (root.data>=k1 &&root.data<=k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if (root.data<k1) {
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void roottoleafPath(Node root,ArrayList<Integer>path){
        if (root==null) {
            return;
        }
        path.add(root.data);
        if (root.left==null&& root.right==null) {
            printPath(path);
            
        }
        roottoleafPath(root.left, path);
        roottoleafPath(root.right, path);
        path.remove(path.size()-1);//ast index;

    }
    public static void printPath(ArrayList<Integer>path){
        for (int i = 0; i < path.size()-1; i++) {
            System.out.print(path.get(i) +"->");
        }
        System.out.println("null");
    }
    public static boolean isValidBST(Node root,Node min,Node max){
        if (root==null) {
            return true;
        }
        if (min!=null && root.data<=min.data) {
            return false;
        }
        else if (max!=null && root.data>=max.data) {
            return false;
        }
        return isValidBST(root.left, min, root)&&isValidBST(root.right, root, max);
    }
    public static Node createmirror(Node root){
        if (root==null) {
            return null;
        }
        Node leftMirror=createmirror(root.left);
        Node rightMirror= createmirror(root.right);
        root.right=leftMirror;
        root.left=rightMirror;
        return root;
    }
    
    public static void main(String args[]){
       /*  Node root=new Node(8);
        root.left=new Node(5);
        root.right= new Node(10);
        root.left.left=new Node(3);
        root.left.right= new Node(6);
        root.right.right=new Node(11);
        root.right.right.right=new Node(14);*/
        int vaues[]={8,5,3,6,10,11,14};
        Node root= null;
        for (int i = 0; i < vaues.length; i++) {
            root= buildBST(root, vaues[i]);
        }
        inorder(root);
        System.out.println();
        
        roottoleafPath(root, new ArrayList<>());
        
       
       
    }
    
}
