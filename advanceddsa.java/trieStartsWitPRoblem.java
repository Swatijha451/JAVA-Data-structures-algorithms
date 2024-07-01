//crete a function boolen startwitt(String prefix) for a trie . return true i ftere ids a previously insrerted
//String word tat as the prefix
//["apple","app","mango","man","woman"]-.ans
//ans="apple"
public class trieStartsWitPRoblem {
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
       public static boolean startsWith(String prefix){
        Node curr= root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx=prefix.charAt(i)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr=curr.children[idx];
        }
        return true;

       }
       
       public static void main(String[] args) {
        String words[]={"apple","app","mango","man","woman"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String prefix="app";
        System.out.println(startsWith(prefix));
       }
}
