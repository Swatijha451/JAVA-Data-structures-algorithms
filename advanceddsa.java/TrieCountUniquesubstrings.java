/*given a string n of length n of lowercase aphabet characters, we need to count total number of distinct 
//substrings off this string, str="ababa,ans=10"
substring= all pprefix of al suffix=al suffix of all prefix
trie tree->unique prefix tree
unique prefix=count of nodes of trie
steps->find al suffix of string->create trie tree and insert all suffix->count nodes of trie=unique prefixes=unique substring*/
public class TrieCountUniquesubstrings {
    static class Node{
        Node[] chidren= new Node[26];
        boolean eow;
        public Node(){
for(int i=0;i<26;i++){
    chidren[i]=null;
}
        } 
       }
       public static Node root= new Node();
       public static void insert(String word){
        int level=0;
        int length=word.length();
        int idx=0;
        Node curr= root;
        for(;level<length;level++){
            idx=word.charAt(level)-'a';
            if (curr.chidren[idx]==null) {
                curr.chidren[idx]= new Node();
            }
            curr=curr.chidren[idx];//update
        }
        curr.eow=true;

       }
       public static boolean search(String key){
        int level=0;
        int len=key.length();
        int idx=0;
        Node curr= root;
        for (;level<len;level++) {
            idx=key.charAt(idx)-'a';
            if (curr.chidren[idx]==null) {
                return false;
            }
            curr=curr.chidren[idx];//update
        }
        return curr.eow=true;
       }
       public static int countnodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for (int i = 0; i <26; i++) {
            if (root.chidren[i]!=null) {
                count+=countnodes(root.chidren[i]);
            }
        }
        return count+1;
       }

       public static void main(String[] args) {
        String str="ababa";
        for (int i = 0; i <str.length(); i++) {
            String suffix=str.substring(i);
            insert(suffix);
        }
        System.out.print(countnodes(root));
       }

}
