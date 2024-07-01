public class homeworksorting{
    //sort te strings array in scending order alpabetically
public static String[] mergesortstringfunction(String arr[], int lo,  int hi){
            if(lo==hi){
                String A[]={ arr[lo] };
                return A;

            }
            int mid= lo+(hi-lo)/2;
            String arr1[]=mergesortstringfunction(arr, lo, mid);
            String arr2[]= mergesortstringfunction(arr, mid+1, hi);
            String [] arr3= merge(arr1, arr2);
            return arr3;
             
        }
        public static String[] merge(String arr1 [], String arr2[]){
           int  m=arr1.length;
           int n= arr2.length;

            String arr3[]= new String[m+n];
            int idx=0;
            int i=0;
            int j=0;
            while(i<m && j<n){
                if(isalphabeticallysmaller(arr1[i],arr2[j])){
                     arr3[idx]=arr1[i];
                    i++;
                    idx++;
                } else{
                    arr3[idx]=arr2[j];
                    j++;
                    idx++;
                }
                   
            }
            while(i<m){
                arr3[idx]=arr1[i];
                i++;
                idx++;
                

            }
            while(j<n){
                arr3[idx]=arr2[j];
                j++;
                idx++;
            }
            return arr3;
        }
            public static boolean isalphabeticallysmaller(String str1, String str2){
                if(str1.compareTo(str2)< 0){
                    return true;
                }
                return false;
            }
            //return the majority element from an integer array
            public static int countInrange(int []nums, int num,int lo, int hi){
                int count= 0;
                for(int i=lo; i<=hi;i++){
                    if(nums[i]==num){
                        count++;
                    }
                }
                return count;
            }
            public static int majorityelement(int nums[],int lo,int hi){
                //base case
                //if there is only pne de.ement in array
                if(lo==hi){
                    return nums[lo];
                }
                //recursion in right and left aves of the array
                int mid= lo+(hi-lo)/2;
                int left= majorityelement(nums, lo, mid);
                int right= majorityelement(nums, mid+1, hi);
                // if two haves agree on same eement
                if(left==right){
                    return left ;

                }
                //otherwise count eac elemen and return the winner
                int leftcount=countInrange(nums, left, lo, hi);
                int rightcount= countInrange(nums, right, lo, hi);
                return leftcount>rightcount? left:right;
            }
            public static int majorityelement(int nums[]){
                return majorityelement(nums, 0, nums.length-1);
            }
            // calculte the inversion count of the given array
            //split the given array int two halves riht and left similar to merge sort
            //count the number of inversion int the two halves along with the count in the merge step of two halves
            //stop the recursion if ony one element is left in bot halves
            //to count the number of inversoions, we wi use two pointers approac. consider i and j one pointion to left and other to rigt half
            //while iteratng trough the arrat if the current element a[i]<a[j],add it to the sorted list ,ese incerement the count by mid-1
            

            
            

            
    public static void main(String[] args) {
        int []arr= {1,4,4,5,7,8,8,8,8,0};
        System.out.println(majorityelement(arr));
        }
    
}