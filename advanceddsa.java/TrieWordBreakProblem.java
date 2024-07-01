//given an input String and a dictionary of words,find out if the input string can be brokrn into a space separated
//sequence of dictionary words
//O(L)->length of the ongest word


public class TrieWordBreakProblem {
    static class Node{
        Node[]children= new Node[26];
        boolean eod;
        public Node(){
            for (int i = 0; i < children.length; i++) {
                children[i]=null;
            }
        }
    }
    public static Node root= new Node();
    public static void insert(String str){
        Node curr=root;
        for (int i = 0; i < str.length(); i++) {
            int idx= str.charAt(i)-'a';
            if (curr.children[idx]==null) {
                curr.children[idx]= new Node();
            }
            curr=curr.children[idx];
        }

        curr.eod=true;
    }
    public static boolean search(String key){
        Node curr=root;
        for (int i=0; i < key.length(); i++) {
            int idx= key.charAt(i)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eod=true;
    }
    public static boolean wordBreak(String key){
        if (key.length()==0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0,i))&&wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String arr[]={"i","like","sam","samsung","mobile","ice"};
        String key="ilikesamsung";
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        System.out.println(wordBreak(key));
    }
}
