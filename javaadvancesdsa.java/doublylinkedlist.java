public class doublylinkedlist{
    public class Node{
        int data;
        Node next;
        Node prev;
        //constructor
        public Node(int data){
            this.data= data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    //add
    public void addfirst(int data){
        Node newnode= new Node(data);
        size++;
        if (head==null) {
            head=tail=newnode;
            return;
            
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    //print
    public void print(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"<->");
            temp=temp.next;
            
        }
        System.out.println("null");
    }
    public static int removefirst(){
        if(head==null){
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;

        }
        int val= head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;

    } 
    public void reverse(){
        Node curr=head;
        Node prev= null;
        Node next;
         while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            //update;
            prev=curr;
            curr=next;
            
         }
         head=prev;
    }
    public void addLast(int data){
        
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;

        }
        tail.next=newNode;
        tail=newNode;

    }
    public int removelast(){
        if (head==null) {
            size--;
            return Integer.MIN_VALUE;
            
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
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
    public static void main(String[] args) {
    doublylinkedlist dll= new doublylinkedlist();
    dll.addfirst(3);
    dll.addfirst(2);
    dll.addfirst(1);
    dll.addLast(5);
    dll.print();;
    dll.removelast();
    dll.print();
    }
}