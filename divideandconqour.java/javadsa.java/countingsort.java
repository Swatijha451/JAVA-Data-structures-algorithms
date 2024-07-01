public class countingsort {
    public static void countingsortfunction(int arr[]){
        int largest= Integer.MIN_VALUE;// for finding the range
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);

        }
        // creating count array to find the frequency of elements in the given array
        int count[]=new int[largest+1];//largest+1because we are finding frequency of elements for positive numbers that statrts from 0
        //iterating over the original array
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;//taking the elemnts of orriginal array as index
        }
        //sorting after taking the frequency in count array
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={1,4,1,3,2,4,3,7};
        countingsortfunction(arr);
        bubblesort.arrayprint(arr);
    }
}
