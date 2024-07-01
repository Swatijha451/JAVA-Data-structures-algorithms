public class rotatedarrayindex {
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
        int target=6;
    System.out.println(search(nums, target,0, nums.length-1));
       
        
    }
}


