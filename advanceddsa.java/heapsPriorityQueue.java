//priority->Preferance Order->by default ascending order
//Prriority quesues in java colection framwwork
import java.util.*;
public class heapsPriorityQueue {
    static class Student implements Comparable <Student>{
    int rank;
    String name;
    Student(int rank,String name){
        this.rank=rank;
        this.name=name;
    }
    @Override
    public int compareTo(Student s2){//compareto function return int s1-s2=0->s1==s2,==-ve-.s1<s2,==+ve->s1>s2
        return this.rank-s2.rank;//whichever rank is smaler will be given higher priority queue
    }

    
} 
//heap data structure can be visualised as binary tree and implemented as array or arraylist
//min heap= where root is smaller than the leaf  nodes
//max heap= where root is maximum and the leaf nodes arte m inimum
static class heap{
    ArrayList<Integer>arr=new ArrayList<>();
    //add fuction of heap
    public void add(int data){
        //add at lasst index
        arr.add(data);
        int x=arr.size()-1;//ast index of arraylist
        int parent=(x-1)/2;//parent index is universaaly given as this
        while (arr.get(x)<arr.get(parent)) {
            //swap
            int temp=arr.get(x);
            arr.set(x, arr.get(parent));
            arr.set(parent, temp);
            //updat eafter swaping for next steps
            x=parent;
            parent=(x-1)/2;
        }
    }
    //peek function
    public  int peek(){
       return arr.get(0);//first element of arraylist;

    }
    public int remove(){//removing te first element from tje arraylist;
        int data= arr.get(0);
        //step 1->SWAP FIRST AND LAST
        int temp= arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);
        //step 2->delete last
        arr.remove(arr.size()-1);
        //step 3->heapify
        heapify(0);
        return data;
    }
    public void heapify(int i){//o(logn)
        int left=2*i+1;
        int right= 2*i+2;
        int minIndex=i;
        if (left<arr.size()-1&&arr.get(minIndex)>arr.get(left)) {
            minIndex=left;
        }
        if (right<arr.size()-1&&arr.get(minIndex)>arr.get(right)) {
            minIndex=right;
        }
        if (minIndex!=i) {
            //swap
            int temp=arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);
            heapify(minIndex);
        }
    }
    public boolean isEmpty(){
        return arr.size()==0;
    }
}
    //heap sort O(nlogn)
    //array->ascending sort(create max heap) ,array->descending sort(create min heap)
    //steps-call heapify for non leaf nodes,push argest elemt to last by swap(first,last)
    public static void heapSort(int arr[]){
        //build max heap for ascending sort
        int n= arr.length;
        for(int i=n/2;i>=0;i--){
            heapify2(arr,i,n);
        }
        //push largest to end
        for(int i=n-1;i>0;i--){
            //swap largest at end
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify2(arr,0,n);

        }
    }
    public static void heapify2(int arr[], int i,int size){
        int left= 2*i+1;
        int right= 2*i+2;
        int maxIndex=i;
        if (left<size&& arr[left]<arr[maxIndex]) {
            maxIndex=left;
        }
        if (right<size&& arr[right]<arr[maxIndex]) {
            maxIndex=right;
        }
        if (maxIndex!=i) {
           //swap
           int temp=arr[i];
           arr[i]=arr[maxIndex];
           arr[maxIndex]=temp;
           heapify2(arr, maxIndex, size); 
        }
            
        }         

    public static void main(String[] args) {
        int arr[]={1,5,4,2,3};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
