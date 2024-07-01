public class bubblesort {
    public static void bubblesortfunction(int arr[]){
        for (int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                //swapping current element with the next element if it larger
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    public static void arrayprint(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int nums[]={4,2,5,3,1};
        bubblesortfunction(nums);
        arrayprint(nums);
        
    }
}
