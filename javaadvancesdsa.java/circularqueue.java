public class circularqueue {
    //circular queue is made using array to make the add function O(n)
    static class CircularQueue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        CircularQueue(int n){
            arr=new int[size];
            size=n;
            rear=-1;
            front=-1;
        }
        public static boolean isEmpty(){
             return rear==-1&&front==-1;    
        }
        public static boolean isFull(){
            return (rear+1)%size==front;

        }
        public static void add(int data){
            //check weather the queue is full
            if (isFull()) {
                System.out.println("the queue is full");
                return ;
            }
            //adding 1sst element in an empty queue
            if (front==-1) {
                front=0;//0 here is the index of array 1st iondex
            }
            //updating 
            rear=(rear+1)%size;
            arr[rear]=data;

        }
        public static int remove(){
            //check if empty
            if(isEmpty()){
                System.out.println("the queue is empty");
                return -1;
            }
            int resut= arr[front];
            //deleting one elemnt inqueue
            if(rear==front){
                rear=front=-1;// ony element deleted the queue is null
            }
            else{
                front=( front+1)%size;
            }
            return resut;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("the queue is empty");
                return -1;
            }
            
            
            return arr[front];

        }

    }
    public static void main(String[] args) {
        CircularQueue q=new CircularQueue(5);
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}
