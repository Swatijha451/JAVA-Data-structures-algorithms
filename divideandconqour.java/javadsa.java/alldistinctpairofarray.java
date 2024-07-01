public class alldistinctpairofarray {
   public static void printpairsfunction(int arr[]){
    int count=0;
    for(int i=0;i<arr.length;i++){
        int current=arr[i];
        for (int j=i+1;j<arr.length;j++){
            System.out.print("("+current+","+arr[j]+")");
            count++;

        }
         
        System.out.println();
    }
    System.out.println("the count is "+ count);
   }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10,12};
        printpairsfunction(arr);
        System.out.println();
    }
}
