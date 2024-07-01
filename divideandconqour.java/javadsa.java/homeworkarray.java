//check array for repitition
public class homeworkarray {
    public static boolean arrayrepetitionfuction(int nums[]){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                return true;
            }

            }
            
        }
        return false;
    }
    //find index of target element in a sorted raotaed array ata a degree usin g binary algoritm
    public  static int search(int [] arr, int target){
        // min will have index of of minimum element of arr
        int min= minsearch(arr);
        if(arr[min]<=target && target<= arr[arr.length-1]){
            return search(arr, target, min, arr.length-1);

        }
        else{
            return search(arr, target, 0, min);
        }
    }
    public static int   search(int arr[], int target, int left, int right){
        int l= left;
        int r= right;
        while(l<=r){
            int mid= l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                r= mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;

    }
    // minsearch will return the index of minimum element of te array
    public  static int minsearch(int [] nums){
        int left=0;// left and right are index
        int right= nums.length-1;
        while(left<right){
            int mid= left+(right-left)/2;
            if(mid>0 && nums[mid-1]>nums[mid]){
                return mid;
            }
            else if(nums[left]<=nums[mid]&& nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right= mid-1;
            }

        }
        return left;

    }
    // another question:  return triplet subsrray such that the su of elements of triplets are equal to 0 solution set must not caontain duplicate triplets
    public static void subarrayTripletwithequalSum(int arr[]){
        int arr3 []= new int[2];
        
        

    }

    public static void main(String[] args) {
        int num[]={4,5,6,7,0,1,2};
       System.out.println(search(num,0));
        
    }
}
