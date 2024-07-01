

public class LinkedList {
    public static class Node{
        int data;
        Node next;
        //constructor of node class for itializing
        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    public static Node head;
    public static Node tail;
    public static int size;
    // method to add first in linked lis
    public void addfirst(int data){
        //create new node of Node class
        Node newnode=new Node( data);
        size++;
        //base case
        if(head==null){
            head=tail=newnode;
            return;
        }
        //link newnodes next to head
        newnode.next=head;
        //change newnode as new head
        head=newnode;
    }
    //addlast method
    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        if (head==null) {
            head=tail=newNode;
        }
        tail.next=newNode;
        tail= newNode;
    }
    //print linkedistfunction
    public   void printll(){
        Node temp= head;
        if(head==null){
            System.out.println("the ll is empty");
            return;
        }
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp= temp.next;
        }
        System.out.println();
    }
    //add in middle->O(N)
    public void add(int data, int idx){
        if(idx==0){
            addfirst(data);
            return;
        }
        Node newnode= new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public int removefirst(){
        int val;
        if(size==0){
            return Integer.MIN_VALUE;
        }
        if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        val=head.data;
        head= head.next;
        size--;
        return val;
    }
    public int removelast(){
        if(size==0){
            return Integer.MIN_VALUE;
        }
        if (size==1) {
            int val=tail.data;
            head=tail= null;
            size=0;
            return val;
            
        }
        Node prev= head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;//tail.data
        prev.next=null;
        size--;
        return val;
    }
    //iterative search in linked list
    public int irsearh(int key){
        Node temp=head;
        int i=0;//index
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;// key not found
    }
    //seac in linkedist using recursion
    //helper function
    public static int helper(Node head, int key){
        //base case
        if(head==null){
            return -1;//the key does not exist
        }
        if(head.data==key){
            return 0;//haed lies at 0 index
        }
        //recursiom
        int idx= helper(head.next, key);
        if(idx==-1){
            return -1;//the key does not exist
        }
        return idx+1;
    }
    public int recsearch(int key){//returns the indexof te key in thr linked list
       return helper(head, key);
    }
    //reverse alinked list
    public void reverse(){
        Node prev=null;
        Node curr= tail=head;
        Node next;
        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev=curr;  
            curr=next;
        }
        head=prev;
    }
    //find and remove nth node from end
    //itertaive search
    public void deleteNthFromEnd(int n){
        //calculate size 
        Node temp=head;
        int sz=0;
        while (temp!=null) {
            temp=temp.next;
            sz++;
            
        }
        //case 1->delete haed or removefirst
        if(n==sz){
            head=head.next;
            return;
        }
        //case ->sz-n because to delete the n th node from end we need sz-n from beginning
        int i=1;
        int iTofind=sz-n;
        Node prev=head;
        while(i<iTofind){
            prev=prev.next;
            i++;

        }
        prev.next=prev.next.next;
        return;
    }
    //chheck if ll is palindrome or not;
    //heper finction to midnode using slow fast approach
    public Node findMid(Node head){
        Node slow= head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow= slow.next;
            fast= fast.next.next;
            
        }
        return slow;//s;low is the mid node of te ll
    }
    public boolean checkPalindrome(){
        if(head==null||head.next==null){//case of one element in ll
            return true;
        }
        //step 1: find mid
        Node midnode= findMid(head);
        //step 2: reverse 2nd half
        Node prev= null;
        Node curr=midnode;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;   
        }
        Node left=head;//head of 1st half
        Node right= prev;//head of last half
        //step 3: ceck 1st half and last half
        while (right!=null) {
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;

        }
        return true;
    }
    public boolean detectloop(){
        Node slow=head;
        Node fast= head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }   
        }
        return false;

    }
    public void removeloop(){
        //detect cycle
        Node slow=head;
        Node fast= head;
        boolean cycle=false;
        while (fast!=null && fast.next!=null) {
            slow =slow.next;
            slow= slow.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        //if cycle does not exist
        if (cycle==false) {
            return;
            
        }
        //cycle exists
        //find meeting point of slow and fast
        slow=head;
        Node prev=null;
        while (slow!=fast) {
            prev=fast;
            slow=slow.next;
            fast=fast.next;    
        }
        //remove cycle
        prev.next=null;


    }
      
    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= head.next;
        ll.printll();
        
    }
}
    
    


