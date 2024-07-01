import java.util.*;

public class Binarysearchtree2 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    //sorted array to balance binary Search Tree->lowest possible height of bst
    public static Node balancedBST(int arr[], int start, int end){
        if (start>end) {
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        root.left=balancedBST(arr, start,mid-1);
        root.right=balancedBST(arr, mid+1, end);
        return root;

    }
    public static void preorder(Node root){
        if (root==null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //convert BST to balanced BST
    //find inorder sequence
    //sorted  arraylist to balanced BST
    public static Node balancedBST2(Node root){
        ArrayList<Integer>al= new ArrayList<>();
        //inorder sequence
        getInorder(root,al);
        root= createBalancedBST(al, 0, al.size()-1);
        return root;
    }
    public static void getInorder1(Node root,ArrayList<Integer>al){
        if (root==null) {
            return;
        }
        getInorder(root.left, al);
        al.add(root.data);
        getInorder(root.right, al);

    }
    public static Node createBalancedBST(ArrayList<Integer>al,int start,int end){
        if (start>end) {
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(al.get(mid));
        root.left=createBalancedBST(al, start, mid-1);
        root.right=createBalancedBST(al, mid+1,end);
        return root;


    }
    //size of largest Bst in a Binary tree
    static class Info{
        boolean isBST;
        int max;
        int min;
        int size;
        Info(boolean isBST,int max,int min,int size){
            this.isBST=isBST;
            this.max=max;
            this.min=min;
            this.size=size;
        }

    }
    public static int maxSize=0;
    public static Info largestBST(Node root){
        //base case
        if (root==null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max= Math.max(root.data, Math.max(leftInfo.max,rightInfo.max));
        if (root.data<=leftInfo.max||root.data>=rightInfo.min) {
            return new Info(false, max, min, size);
        }
        if (leftInfo.isBST&&rightInfo.isBST) {
            maxSize=Math.max(maxSize, size);
            return new Info(true, max, min, size); 
        }
        return new Info(false,max,min,size);
    }
    //merge 2 bsts
    public static void getInorder(Node root,ArrayList<Integer>al){
        if (root==null) {
            return;
        }
        getInorder(root.left, al);
        al.add(root.data);
        getInorder(root.right, al);
    }
    public static Node mergeBST(Node root1,Node root2){
        //step1
        ArrayList<Integer>al1=new ArrayList<>();
        getInorder(root1, al1);
        //step2
        ArrayList<Integer>al2=new ArrayList<>();
        getInorder(root2, al2);
        //merge
        int i=0,j=0;
        ArrayList<Integer>finallist=new ArrayList<>();
        while (i<al1.size()&&j<al2.size()) {
            if (al1.get(i)<=al2.get(i)) {
                finallist.add(al1.get(i));
                i++;
            }
            else{
                finallist.add(al2.get(j));
                j++;
            }
        }
        while (i<al1.size()) {
            finallist.add(al1.get(i));
            i++;
        }
        while (j<al2.size()) {
            finallist.add(al2.get(j));
        }
        return createBalancedBST(finallist, 0, finallist.size()-1);
    }
    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.left.left=new Node(1);
        root.left.left.right=new Node(4);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(14);
        
        preorder(root);
        System.out.println();
        System.out.print(largestBST(root).size);


    }
}
