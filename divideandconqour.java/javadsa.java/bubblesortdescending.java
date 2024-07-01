public class bubblesortdescending {
    public static void bubbledescending(int nums[]){
        for (int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                //swapping
                if(nums[j]<nums[j+1]){
                   int temp=nums[j];
                   nums[j]=nums[j+1];
                   nums[j+1]=temp; 
                }
            }
        }
    }
    public static void printfunction(int nums[]){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"  ");
        }
    }
    public static void main(String[] args) {
        int nums[]={3,2,5,1,8,7,4,5,3,1};
        bubbledescending(nums);
        printfunction(nums);

    }
}
