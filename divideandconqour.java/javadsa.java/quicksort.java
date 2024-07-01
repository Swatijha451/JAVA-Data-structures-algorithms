public class quicksort {//worst case time cplxiy when aay is aleady sorted ascening or descending when pivot is last elent or first elent
    //quicksort does not take extra mmory like merge sort
    // worst case isO(n squarednm)
    public static void quicksortfunc(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //calling the partition function to get the pivot index
        int pivotidx= partition(arr, si, ei);
        quicksortfunc(arr, si, pivotidx-1);//for the part left of pivot excluding pivot
        quicksortfunc(arr, pivotidx+1,ei);//for the part right of pivot
    }
    public static int partition(int arr[],int si,int ei){
        int pivot= arr[ei];// pivot often taken as last element
        int i= si-1;//i is -1 because it will make place for the elemnt less or more on either side of the pivot
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;// made place then swapped
                //swap
                int temp= arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        //to put the pivot in its right palce
         int temp= pivot;
            arr[ei]=arr[i];
            arr[i]=temp;
            return i; 
    }
    public static void main(String[] args) {
        int arr[]= {6,4,9,5,2,7};
        quicksortfunc(arr, 0, arr.length-1);
        mergesort.printarr(arr);
    }
}
