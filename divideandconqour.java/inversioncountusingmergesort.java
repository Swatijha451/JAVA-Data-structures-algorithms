public class inversioncountusingmergesort {
    // calculte the inversion count of the given array


    //split the given array int two halves riht and left similar to merge sort
            //count the number of inversion int the two halves along with the count in the merge step of two halves
            //stop the recursion if ony one element is left in bot halves
            //to count the number of inversoions, we wi use two pointers approac. consider i and j one pointion to left and other to rigt half
            //while iteratng trough the arrat if the current element a[i]<a[j],add it to the sorted list ,ese incerement the count by mid-1
           /* public static int merge(int [] arr, int left,int mid ,int right){
                int i= left,j=mid+1,k=0;
                int pairs=0;
                int temp[]=new int[right-left+1];
                while(i<=mid && j<=right){
                   if( arr[i]<=arr[j]){
                    temp[k]=arr[i];
                    k++;
                    i++;
                   } 
                   else{
                    pairs+=(mid-i+1);
                    temp[k]=arr[j];
                    
                    k++;
                    i++;
                   }
                   //for rst elements after comparison in left
                   while (i<=mid) {
                    temp[k]=arr[i];
                    k++;
                    i++;
                    
                   }
                   //for rest of the element after comparison in right
                   while(j<=right){
                    temp[k]=arr[j];
                    k++;
                    j++;
                   }
                   //copying the sorted temp array back to original arry
                   for(i=left,k=0;i<=right;i++,k++){// or also for(int i=left;i<=right;i++){arr[i]=temp[i-left]}
                    arr[i]=arr[k];
                   }
                  
                }
                 return pairs;

            }
                 public static int mergesort(int arr[],int left,int right){
                   //base case
                    if(left>=right){
                        return 0;
                    }
                    
                        int mid=left+(right-left)/2;
                        int invCount=0;
                        invCount+=mergesort(arr,left,mid);
                        invCount+=mergesort(arr, mid+1, right);
                        invCount+=merge(arr,left,mid,right);

                    return invCount;
                
                }
                public static void main(String[] args) {
                    int arr[]={2,6,4,1,3,5};
                    int ans= mergesort(arr, 0, arr.length-1);
                    System.out.println((ans));
                }*/
                public static int merge(int arr[],int left,int mid,int right ){
                    int i=left,j=mid,k=0;
                    int invCount=0;
                    int temp[]=new int[right-left+1];
                    while (i<mid && j<=right) {
                        if(arr[i]<=arr[j]){
                            temp[k++]=arr[i++];
                        }
                        else{
                            temp[k]=arr[j];
                            invCount+=(mid-i);
                            k++;
                            j++;
                        }
                    }
                    while (i<mid) {
                        temp[k++]=arr[i++];
                    }
                    while (j<=right) {
                        temp[k++]=arr[j++];
                    }
                    for( i=left,k=0;i<=right;i++,k++){
                        arr[i++]=temp[k++];
                    }
                    return invCount;
                }
                public static int mergesort(int arr[], int left, int right){
                    //base case
                    if(left>=right){
                        return 0;
                    }
                    int invCount=0;
                   
                    if(right>left){
                         int mid= left+(right-left)/2;
                         invCount+=mergesort(arr, left, mid);
                         invCount+=mergesort(arr, mid+1, right);
                         invCount+=merge(arr, left, mid+1, right);

                    }
                    return invCount;
                }

                public static void main(String[] args) {
                    int arr[]={2,6,4,1,3,5};
                    int ans= mergesort(arr, 0, arr.length-1);
                    System.out.println(ans);
                }
}
