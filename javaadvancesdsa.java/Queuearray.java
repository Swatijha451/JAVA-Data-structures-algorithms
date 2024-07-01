public class Queuearray {
    static class Queue{
         static int arr[];
       static int size;
         static int rear;
        //constructor of clas queue
        Queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
        }
    
    public static boolean isEmpty(){
        return rear==-1;
    
    }
    public static void  add(int data){
        //ceck weather tthre quue is full
        if(rear==size-1){
            System.out.println("the queue is full");
            return ;
        }
        rear=rear+1;
        arr[rear]=data;

    }

    //removing the first element of queue in last in first out
    public static int remove(){
        if (isEmpty()) {
            System.out.println("the queue is empty");
            return -1;
        }
        int front=arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        rear=rear-1;
        return front;//returnoing the removed element

    }
    public static int peek(){
        if (isEmpty()) {
            System.out.println("the queue is empty");
            return -1;
        }
        return arr[0];

    }
}
public static void main(String[] args) {
    Queue q= new Queue(5);
    q.add(0);
    q.add(1);
    q.add(2);
    q.add(3);
    while (!q.isEmpty()) {
        System.out.println(q.peek());
        q.remove();
    }
}
}

