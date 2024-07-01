public class queuelinkedlist {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        static class Queue{
            static Node head=null;
            static Node tail=null;
            public static boolean isEmpty(){
                return head==null&&tail==null;
            }
            public static void add(int data){
                Node newnNode=new Node(data);
                //adding 1st element in an empty linked list
                if (head==null) {
                    head=tail=newnNode;
                    return;
                }
                tail.next=newnNode;
                tail=newnNode;

            }
            public static int remove(){
                if (isEmpty()) {
                    System.out.println("thequeue is empty");
                    return -1;

                }
                int front= head.data;
                //single element case
                if (head==tail) {
                    head=tail=null;
                }
                else{
                    head=head.next;
                }
                return front;
            }
            public static int peek(){
                if (isEmpty()) {
                    System.out.println("the queue is empty");
                    return -1;
                }
                return head.data;
            }
        
    }
    public static void main(String[] args) {
        Queue q= new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
