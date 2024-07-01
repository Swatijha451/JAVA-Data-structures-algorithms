//Trie data structure/prefix tree/retrieva tree
//it id a K-arraytree
public class triedataStructure {
     static class Node{
        Node[]children=new Node[26];
        boolean endofword;
        public Node(){
            for (int i = 0; i < children.length; i++) {
                children[i]=null;//intitizing every node with null
            }
        }
    }
    public static Node root= new Node();
    //insert in trie-. O(L) L is the length of the longest word
    public static void insert(String word){
        Node curr= root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                curr.children[idx]= new Node();
            }
            curr=curr.children[idx];
        }
        curr.endofword=true;
    }
    //search in trie ->O(L)
    public static boolean search(String key){
        Node curr=root;
        for (int level = 0; level < key.length(); level++) {
            int idx=key.charAt(level)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr=curr.children[idx];//update the curr 
        }
        return curr.endofword==true;
    }


    public static void main(String[] args) {
        String word[]={"the","a","there","any","thee"};
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        System.out.println(search("the"));
    }
}
