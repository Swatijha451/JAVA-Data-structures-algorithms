//maximum of all subarrays of size k=3
//n=size of array

import java.util.PriorityQueue;
//print maximum of a window of size k-> sliding window
public class heapsSidingWindowProblem {
    static class pair implements Comparable<pair> {
    int val;
    int idx;
    public pair(int val,int idx){
        this.val=val;
        this.idx=idx;
    }
    @Override
    public int compareTo(pair p2){
        //descemding sort
        return p2.val-this.val;
    }
        
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;//window size;
        int[] res= new int[arr.length-k+1];//8-3+1=6//n-k+1
        PriorityQueue<pair>pq = new PriorityQueue<>();//max heap priority Queue
        //1st window;->add k numbers in pq
        for (int i = 0; i < k; i++) {
            pq.add(new pair(arr[i], i));
        }
        res[0]=pq.peek().val;//max element will be in from because its max heap
        for (int i=k; i< arr.length; i++) {
            while (pq.size()>0 &&pq.peek().idx<=(i-k)) {//remove the first(max element) if its outside the window
            pq.remove();
            }
             pq.add(new pair(arr[i], i));//curent pair
             res[(i-k+1)]=pq.peek().val;
             
        }
        //print result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
            
        }
        System.out.println();
       
    }
}
