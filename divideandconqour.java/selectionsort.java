public class selectionsort {
    public static void selectionsortfunction(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minipostion= i;// miniposition is the index not the value
            //outer loop
            for(int j=i+1;j<arr.length;j++){
                if(arr[minipostion]>arr[j]){
                    minipostion=j;
                }
            }
            //swap
            int temp=arr[minipostion];
            arr[minipostion]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        int arr[]={5,2,4,3, 1};
        selectionsortfunction(arr);
        bubblesort.arrayprint(arr);
    } 
}
