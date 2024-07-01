import java.util.*;

public class hashMapImlementation {
    //it is implemented as array of linkedList
    //array of linked list ios called buckets
    static class HashMap<K,V>{
        private class Node {
        K key;
        V val;
        public Node(K key,V val){
            this.key= key;
            this.val=val;
        }
    }
    private int n;//n//size of linked list
    private int N;//size of bucket array
    private LinkedList<Node>buckets [];//N//size of array
    @SuppressWarnings("uncheked")//for intilazing buckets with linkedist but without mentioning the type linked lisst
    //hashmap constructor
    public HashMap(){
        this.N=4;
        this.buckets=new LinkedList[4];
        for (int i = 0; i <N; i++) {
            this.buckets[i]=new LinkedList<>();//initilaizing every bucket with an empty linkedist
        }
    }
    private int hashFunction( K key){
        int hc=key.hashCode();//calling hashcode for the object key wwhic will n return a hash value after hashing
        //it can return positive or negative value but we need index which is an absolute value
        return Math.abs(hc)%N;//size is 4 where remainder will be between 0 to 3


    }
    private int searchInLL(K key, int bi){
        LinkedList<Node> ll= buckets[bi];//taking out the linked list stored at the bucket index
        int di=0;
        for (int i = 0; i < ll.size(); i++) {//traversing throug the linkedList stored at bi downwards to find di
            Node node=ll.get(i);
            if (node.key==key) {//if the key already exists
                return di;
            }
            di++;   
        }
        return -1;// if the key does not exoist
    }
    @SuppressWarnings("unchecked")
    private void rehash(){
        LinkedList<Node>[]oldbuck=buckets;
        buckets=new LinkedList[N*2];
        N=2*N;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i]=new LinkedList<>();//initializing with empty linked lists
        }
        //nodes->add in bucket
        for (int i = 0; i < oldbuck.length; i++) {
            LinkedList<Node>ll=oldbuck[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node=ll.remove();
                put(node.key, node.val);
            }
        }

    }
    public void put(K key,V val){//O(lambda)->contant time O(1)
        int bi= hashFunction(key);//bucked Index
        int di=searchInLL(key,bi);//data Index->validIndex(update) Else -1(creat newNode)
        if (di!=-1) {//if key already exists
            Node node=buckets[bi].get(di);
            node.val=val;
        }
        else{
            buckets[bi].add(new Node(key, val));//else create new node 
            n++;
        }
        double lambda= (double)n/N;//find threshold
        if (lambda>2.0) {//greater than threshhold then rehash
            rehash();
        }
    } 
    public boolean containsKey(K key){//O(1)
        int bi=hashFunction(key);
        int di=searchInLL(key, bi);
        if (di!=-1) {
            return true;
        }
        else{
            return false;
        }
    }
    public V get(K key){//O(1)
        int bi= hashFunction(key);
        int di= searchInLL(key, bi);
        if(di!=-1){
            Node node=buckets[bi].get(di);
            return node.val;
        }
        else{
            return null;
        }
    }
    public V remove(K key){//O(1)
        int bi= hashFunction(key);
        int di= searchInLL(key, bi);
        if (di!=-1) {
            Node node=buckets[bi].remove();
            n--;
            return node.val;
        }
        else{
            return null;
        }

    }
    public ArrayList<K> keyset(){
        ArrayList<K>keys= new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node>ll=buckets[i];
            for (Node node: ll) {
                keys.add(node.key);
            }
        }
        return keys;

    }
    public boolean isEmpty(){
        return n==0;
    }
    }
    public static void main(String[] args) {
       HashMap<String,Integer>hm= new HashMap<>();
       hm.put("India",100);
       hm.put("US",30);
       hm.put("Nepal",10);
       ArrayList<String>keys=hm.keyset();
       for(String key:keys){
        System.out.println(key);
       } 
    }
}