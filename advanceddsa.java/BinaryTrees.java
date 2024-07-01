import java.util.*;
public class BinaryTrees {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
            
        
    static class BinaryTree{
        static int idx=-1;
        public static Node buildtree(int arr[]){
            idx++;
            if (arr[idx]==-1) {
                return null;
            }
            
            Node newNode=new Node(arr[idx]);
            newNode.left=buildtree(arr);
            newNode.right=buildtree(arr);
            return newNode;
        }
         //preorder traversal
        public static void preorder(Node root){
            if (root==null) {
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
             if (root==null) {
                return;
            }
             inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
             if (root==null) {
                return;
            }
             postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");   
        }
        public static void levelorder(Node root){
            if (root==null) {
                return;
            }
            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node curNode=q.remove();//1
                if (curNode==null) {
                    System.out.println();//for nrext line after level
                    if (q.isEmpty()) {
                        break;//if its the last in array
                    } else{
                        q.add(null);//
                    }
                }
                    else{//if its not null
                        System.out.print(curNode.data+" ");
                        if (curNode.left!=null) {
                            q.add(curNode.left);
                        }
                        if (curNode.right!=null) {
                            q.add(curNode.right);
                        }
                    }
                
                
            }
        }
        public static int height(Node root){
            if (root ==null) {
                return 0;
            }
            int lh=height(root.left);
            int rh= height(root.right);
            return Math.max(lh, rh)+1;
        }
        public static int count(Node root){
            if (root==null) {
                return 0;
            }
            int leftcount=count(root.left);
            int rightcount=count(root.right);
            return leftcount+rightcount+1;
        }
        public static int sum(Node root){
            if (root==null) {
                return 0;
            }
            int leftSum=sum(root.left);
            int rightSum=sum(root.right);
            return leftSum+rightSum+root.data;

        }
        public static int diameter2(Node root){//O(n2)
            if (root==null) {
                return 0;
            }
            int leftdiam=diameter2(root.left);
            int lh=height(root.left);
            int rightdiam=diameter2(root.right);
            int rh=height(root.right);
            int selfdiam=lh+rh+1;
            return Math.max(selfdiam, Math.max(rightdiam, leftdiam));
        }
        //2nd approach->O(n)
        
     static class Info {
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
       

        public static Info diameter(Node root){
            if (root ==null) {
                return  new Info(0,0);
            }
            Info leftInfo=diameter(root.left);
            Info rightInfo=diameter(root.right);
            int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
            int ht= Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new Info(diam, ht);
        }
        //subtree of another tree
        

       
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.right.left= new Node(4);
        root.right.right=new Node(5);
        root.left.left=new Node(6);
        root.left.right=new Node(7);
       System.out.println(BinaryTree.diameter(root).diam);
    }
}
