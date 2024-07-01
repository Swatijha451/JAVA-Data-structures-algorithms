public class inversioncount2 {
    public static int merge(int arr[], int left, int mid, int right){
        int temp[]= new int [right-left+1];
        int p1=left,p2= mid+1, k=0;
        int invCount=0;

        while(p1<=mid &&p2<=right){
            if(arr[p1]<=arr[p2]){
                temp[k]=arr[p1];
                k++;p1++;

            }
            else{
                invCount+=(mid-p1+1);
                temp[k]=arr[p2];
                k++;p2++;
            }
        }
        while (p1<=mid) {
            temp[k++]=arr[p1++];
            
        }
        while (p2<=right) {
            temp[k++]=arr[p2++];
            
        }
        for(int idx=left;idx<=right;idx++){
            arr[idx]=temp[idx-left];
        }
        return invCount;
    }
    public static int mergesort(int arr[],int left, int right){
        //base case
        if(left>=right){
            return 0;
        }
        int mid= left+(right-left)/2;
        int ans=0;
        ans+=mergesort(arr, left, mid);
        ans+=mergesort(arr, mid+1, right);
        ans+=merge(arr, left, mid, right);
        return ans;
    }
    public static void main(String[] args) {
        int arr[]= {8,4,2,1};
        int ans= mergesort(arr, 0, arr.length-1);
        System.out.println(ans);
    }
}
