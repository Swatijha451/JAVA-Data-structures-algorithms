public class selectionsortdescending {
    public static void descendingfunction(int nums[]){
        for (int i=0;i<nums.length-1;i++){
            int largestIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[largestIndex]<nums[j]){
                    largestIndex=j;
                }
            }
            //swap
            int temp=nums[largestIndex];
            nums[largestIndex]=nums[i];
            nums[i]=temp;
            
        }
        

    }
    public static void main(String[] args) {
        int nums[]={2,6,6,7,3,3,2,4,9,0};
        descendingfunction(nums);
        bubblesortdescending.printfunction(nums);
    }
}
