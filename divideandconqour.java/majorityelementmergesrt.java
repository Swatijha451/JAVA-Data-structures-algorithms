public class majorityelementmergesrt {
    //return the majority element from an integer array
    public static int getCount(int []nums ,int left,int right, int target){
        int count= 0;
        for(int i=left; i<=right;i++){
            if(nums[i]==target){
                count++;
            }
        }
        return count;
    }
    public static int majority(int nums[],int left,int right){
        //base case
        //if there is only pne de.ement in array
        if(left==right){
            return nums[left];
        }
    
        //recursion in right and left halves of the array
        int mid= left+(right-left)/2;
        int leftmaxelement= majority(nums, left, mid);
        int rightmaxelement= majority(nums, mid+1, right);
        // if two haves agree on same eement
        //if(left==right){
          //  return left ;

        //}
        //otherwise count eac elemen and return the winner
        int countA=getCount(nums,left,mid, leftmaxelement);
        int countB =getCount(nums, mid+1, right,rightmaxelement);
        if(countA>countB) {
        
            return leftmaxelement;
        
        }
        else return rightmaxelement;
    }
        
   // public static int majorityelement(int nums[]){
     //   return majority(nums, 0, nums.length-1);
    //} 

public static void main(String[] args) {
int []arr= {4,4,5,7,8,8,8,8,0};
int ans=majority(arr, 0, arr.length-1);
System.out.println(ans);
}

}

