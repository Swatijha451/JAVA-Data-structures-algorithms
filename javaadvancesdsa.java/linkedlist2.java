public class linkedlist2 {
    public static  class Node {
          int data;
         Node next;
         //constructor of node class
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
    
    //mergesort in linked list
    //recursive function
    public Node mergeSort(Node head){
        //base case
        if (head==null||head.next==null) {
            return head;
        }
        //find mid
        Node midnode= getMid(head);
        //left &right half
        Node righthead= midnode.next;
        midnode.next=null;
        Node newleft= mergeSort(head);
        Node newright= mergeSort(righthead);
        //merge step
        return merge(newleft,newright);
    }
    //function to find mid node from the 2nd half
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast= fast.next.next;

        }
        return slow;//slow is the mid node
    }
    public Node merge(Node head1,Node head2){
        Node mergedll= new Node(-1);//new linked list to add soeted nodes at the back of this node
        Node temp= mergedll;
        while (head1!=null&&head2!=null) {
            if (head1.data<=head2.data) {
                 temp.next=head1;
            head1=head1.next;
            temp= temp.next;
                
            } else{
               temp.next=head2;
            head2=head2.next;
            temp= temp.next;
            }
        }
            //for leftover elements
            while (head1!=null) {
                temp.next=head1;
            head1=head1.next;
            temp= temp.next;
            }
            while (head2!=null) {
                 temp.next=head2;
            head2=head2.next;
            temp= temp.next;
            }
           return mergedll.next;
    }
    //print the given linked list in zig zag fzshion
    public void  zigzag(){
        //find mid
        Node slow=head;
        Node fast= head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast= fast.next.next;
            
        }
        Node mid=slow;
        //reverase 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            
        }
        Node lefthead=head;
        Node rigthead=prev;
        Node nextL,nextR;
        //zig zag merge
        while (lefthead!=null && rigthead!=null) {
             nextL=lefthead.next;
        lefthead.next=rigthead;
        nextR=rigthead.next;
        rigthead.next=nextL;
        //update
        lefthead=nextL;
        rigthead=nextR;    
        }
       
    }
    
    public static void main(String[] args) {
        linkedlist2 ll=new linkedlist2();
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);
        ll.printll();
        ll.zigzag();
      
        ll.printll();
        
        
    
    }
}
