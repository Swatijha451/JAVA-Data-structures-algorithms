import java.util.Stack;

public class queueusingtwostacks {
    static class queue{
        static Stack<Integer>s1=new Stack<>();
        static Stack<Integer>s2= new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if (s1.isEmpty()) {
                System.out.println("the queue is empty");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if (s1.isEmpty()) {
                System.out.println("te queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        queue q=new queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(0);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
            
        }
    }
}
