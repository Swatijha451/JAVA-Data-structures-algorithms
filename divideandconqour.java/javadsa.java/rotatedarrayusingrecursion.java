

public class rotatedarrayusingrecursion {
    //the function to find the index of the minimum element in the nums array using binary search
   /*  public  static int search(int nums[],int target){

        //minsearc function will find the minimummelement in array
        int min= minsearch(nums);
        //find in sortedleft
        if(nums[min]<=target && target<= nums[nums.length-1]){
            return search(nums,target, 0, min);
        }
        //find in sorted rigt 
        else{
            return search(nums, target, 0, min);
        }    
    }
    //binary searc to find target in left to right boundary 
    public static int search(int nums[],int target,int left,int right){
        int l=left;
        int r= right;
        //or printing 
        while(l<=r){
            int mid= l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;

            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
    //minsearc will give smallest element index
    public static int  minsearch(int nums[]){
        int left=0;
        int right= nums.length-1;
        while(left<right){
            int mid= left+(right-left)/2;
            if(mid>0 && nums[mid-1]> nums[mid]){
                return mid;
            }
            else if(nums[left]<= nums[mid]&& nums[mid]>nums[right]){
                left=mid+1;

            } else{
                left=mid-1;
            }

        }
        return left;

    }*/
    //rotated array index using recursion
    public static int search (int [] nums, int target, int si, int ei){
        // base case
        if(si>ei){
            return -1;// invalid conditiion target does not exist in array
        }
        int mid= si+(ei-si)/2;
    // 1st case wher mid is the target
    if(nums[mid]==target){
        return mid;
    }
    // 2nd case when target lies in the left of mid on line l1
    if(nums[si]<=nums[mid]){
        if(nums[si]<=target&&target<=nums[mid]){
            //recursion
            return search(nums, target, si, mid-1);
        }
        else{
            return search(nums, target, mid+1, ei);
        }
    }

    
    //case b= when target lies on the l2
    else{
        if(nums[mid]<=target && target<=nums[ei]){
            return search(nums, target, mid+1, ei);
        }
        // caseb: left of
        else{
            return search(nums, target, si, mid-1);
        }

    }

    
}
    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        int target=3;
    System.out.println(search(nums, target,0, nums.length-1));
       
        
    }
}
