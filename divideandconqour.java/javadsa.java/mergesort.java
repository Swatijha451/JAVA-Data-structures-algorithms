public class mergesort{//timecoplexity= nO(logn) ,space complexity=O(n),deppthfirst search
    public static void main(String[] args) {
        int arr[]= {6,4,2,8,3,9};
        mergesortFuns(arr, 0, arr.length-1);
        printarr(arr);
        
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void mergesortFuns(int arr[],int si,int ei){
         //base case
        if(si>=ei){
            return;
        }
        int mid= si+(ei-si)/2;//finding out the mid
        mergesortFuns(arr, si, mid);//calling sortfunction for thr left  of arraybefore mid
        mergesortFuns(arr,mid+1,ei);//calling function for right of arrayafter mid
        mergefunc(arr, si, mid, ei);//merging the elements of left and right sorted elements 
    }     
    public static void mergefunc(int arr[],int si,int mid,int ei){
        int temp[]= new int[ei-si+1];//size of temp array is one longer tan te original
        int i=si;// itrertor for left part of array
        int j=mid+1;// iterator for right part of array
        int k= 0;//iterator for thee temporary array
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];//storing the lesser ele,ment in trmporary array
                i++;
                
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
            //for the left out element after comaprison int left sorted array
            while(i<=mid){
                temp[k++]=arr[i++];
            }
            //for leftover element after comparioson in right sorted array
            while(j<=ei){
                temp[k++]=arr[j++];
            }
            //copy the temp array to orogonal arry
            for(k=0,i=si;k<temp.length;k++,i++){
                arr[i]=temp[k];
            }
    }
}
     
    


