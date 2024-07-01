//find the longest string in word array such that its every prefix is also present iin te prd array
//word[]={"a","banana","app","ap","apple","apply"}
//find not null then
//find longest word in trie where every words epw is true;
//then find lexicographically smaller word
public class trielongestWordwithallPrefixes {
    static class Node{
        Node children[]= new Node[26];
        boolean eow;
        public Node(){
            for (int i = 0; i < children.length; i++) {
                children[i]=null;
            }
        }
    }
        public static Node root=new Node();
        public static void insert(String word){
            Node curr=root;
            int level=0;
            int idx=0;
            int len= word.length();
            for (;level<len;level++) {
                idx=word.charAt(level)-'a';
                if(curr.children[idx]==null){
                    curr.children[idx]=new Node();
                }
                //update
                curr=curr.children[idx];
          }
          curr.eow=true;
        }
        public static boolean search(String key){
            Node curr=root;
            int level=0;
            int idx=0;

            int len=key.length();
            for(;level<len;level++){
                idx= key.charAt(level)-'a';
                if (curr.children[idx]==null) {
                    return false;
                }
                curr=curr.children[idx];
            }
            return curr.eow=true;
        }
        public static String ans="";
        public static void longestWord(Node root,StringBuilder temp){
            if (root==null) {
                return;
            }
            for (int i = 0; i < 26; i++) {//childrens length
                if (root.children[i]!=null&&root.children[i].eow==true) {
                    char ch=(char)(i+'a');
                temp.append(ch);
                if (temp.length()>ans.length()) {
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtracking
                temp.deleteCharAt(temp.length()-1);
                }   
            }
        }
    public static void main(String[] args) {
        String words[]={"a","banana","app","appl","ap","apply"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
