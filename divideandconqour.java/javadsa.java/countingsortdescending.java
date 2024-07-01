public class countingsortdescending {
    public static void countingsortdescendingfunction(int [] arr){
        //for finding the largest element in input array
        int largest= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest= Math.max(largest,arr[i]);
        }
        // craeting a count array to store the frequency of every element in input array
        int count[]= new int[largest+1];//taking the element of input array as index including 0
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;//store the count of each element
        }
        int j=0;
        for(int i=count.length-1;i>=0;i--){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }

    }
    public static void main(String[] args) {
        int nums[]={7,6,8,8,9,0,0,9,6};
        countingsortdescendingfunction(nums );
        bubblesort.arrayprint(nums);

    }
}
