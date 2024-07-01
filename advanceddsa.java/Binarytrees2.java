import java.util.*;
public class Binarytrees2{
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
        //return true if the given binary tree is a subtree of another tree
        public static boolean isSubtree(Node root,Node subroot){
            //base case
            if (root==null) {
                return false;
            }
            if (root.data==subroot.data) {
                 if (isIdentical(root,subroot)) {//true
                return true;
            }
            }
           
            return isSubtree(root.left, subroot)||isSubtree(root.right, subroot);
        }
        //helper function isIdentical
        public static boolean isIdentical(Node node,Node subroot){
            //base case
            if (node==null&&subroot==null) {
                return true;
            }
            //the conditions when the roots are unequal
            else if (node==null||subroot==null||node.data!=subroot.data) {
                return false;
            }
            if (!isIdentical(node.left, subroot.left)) {//eft subtree
                return false;
            }
            if (!isIdentical(node.right, subroot.right)) {//right subtree
                return false;
            }
            return true;


        }
        //top view of a tree
        //->level order traversal
        //->caculate horizontal distance
        //->map datastructure(key:horizontal distance,value:Node)
        //loop from min to max
        static class info{
            Node node;
            int hd;
             info(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        public static void topview(Node root){
            Queue <info>q=new LinkedList<>();
            HashMap<Integer,Node>map=new HashMap<>();
            int min=0;
            int max=0;
            q.add(new info(root,0));
            q.add(null);
            while (!q.isEmpty()) {
                info curr= q.remove();
                if (curr==null) {
                    if (q.isEmpty()) {
                        break;
                    } else{
                        q.add(null);
                    }
                } else{
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left!=null) {
                        q.add(new info(curr.node.left,curr.hd-1));
                        min=Math.min(min, curr.hd-1);                    }
                    if (curr.node.right!=null) {
                        q.add(new info(curr.node.right,curr.hd+1));
                        max=Math.max(max, curr.hd+1);
                    }
                }
            }
            for (int i = min; i <=max; i++) {
                System.out.print(map.get(i).data+" ");
            }
            
        }
        ////kthlevel of a tree
        public static void klevel(Node root,int level,int k){
            if (root==null) {
                return;
            }
            if (level==k) {
                System.out.print(root.data+" ");
                return;
            }
            klevel(root.left, level+1, k);
            klevel(root.right, level+1, k);
        }
        //lowest common anscestor of two nodes n1 and n2 in a binary tree
        //aproac 1;
        public static Node LowestCommenAncestor1(Node root,int n1,int n2){
            ArrayList<Node>path1=new ArrayList<>();
            ArrayList<Node> path2=new ArrayList<>();
            getPath(root,n1,path1);
            getPath(root,n2,path2);
            //last common ancestor
            int i=0;
            for(;i<path1.size()&&i<path2.size();i++){
                if (path1.get(i)!=path2.get(i)) {
                    break;
                }    
        }
        Node lca=path1.get(i-1);
        return lca;
    }
    public static boolean getPath(Node root,int n,ArrayList<Node>Path){
        //base cass
        if(root==null){
            return false;
        }
        Path.add(root);
        if (root.data==n) {//data found in root
            return true;
        }
        //if not found in root
        boolean foundleft=getPath(root.left,n, Path);
        boolean foundright=getPath(root.right, n, Path);  
        if (foundleft||foundright) {
            return true;
        }
        Path.remove(Path.size()-1);
        return false;

    }
    //aproach2 of lowest common anestor
    //O(n) and constant space
    public static Node LowestCommenAncestor(Node root,int n1,int n2){
        //base case
        if (root==null||root.data==n1||root.data==n2) {
            return root;
        }
        Node leftLCA=LowestCommenAncestor(root.left,n1,n2);
        Node rightLCA= LowestCommenAncestor(root.right, n1, n2);
        //leftlca=value &&right lca=null
        if (rightLCA==null) {
            return leftLCA;
        }
        if (leftLCA==null) {
            return rightLCA;
        }
        
        return root;
    }
    //minimum distance between nodes
    //find lowest coomon ancestor of n1 and n2
    //find distance 1=n1tolca
    //find distance 2=n2tollca
    //minimum distance between n1 nad n2= distance1+distance2
    public static int LCAdisrtance(Node lca,int n){//eper function
        if (lca==null) {
            return -1;//no common ancestor
        }
        if (lca.data==n) {
            return 0;//lca itself is the root
        }
        int leftlcadistance=LCAdisrtance(lca.left, n);
        int rightlcadistance= LCAdisrtance(lca.right, n);
        if (leftlcadistance==-1&&rightlcadistance==-1) {
            return -1;
        }
        else if (leftlcadistance==-1) {
            return rightlcadistance+1;
        }
        else{
            return leftlcadistance+1;
        }
    }
    public static int minDistance(Node root,int n1,int n2){
        Node lca=BinaryTree.LowestCommenAncestor(root, n1, n2);
        int distance1=LCAdisrtance(lca, n1);
        int distance2=LCAdisrtance(lca, n2);
        return distance1+distance2;
    
    }
}
public static void main(String args[]){

}
}