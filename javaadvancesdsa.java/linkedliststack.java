public class linkedliststack {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        static Node head=null;
        public static boolean isEmpty(){
            return head==null;
        }
        //push
        public static void push(int data){
            Node newnode= new Node(data);
            if(isEmpty()){
                return ;
            }
            newnode.next=head;
            head= newnode;
        }
        //pop
        public static int pop(){
            if (isEmpty()) {
                return -1;
                
            }
            int top= head.data;
            head=head.next;
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        
        }
    }
}
