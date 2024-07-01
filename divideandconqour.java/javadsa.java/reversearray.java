public class reversearray {
    public static void reversearrayfunction(int arr[]){
        int first= 0;
        int  last= arr.length-1;
        while(first < last){
            //swaping first vlue withlast value
            int temp= arr[last];
            arr[last]=arr[first];
            arr[first]= temp;
            first++;
            last--;
        }
    
    }
    public static void main(String[] args) {
        int numbers[]= {1,3,5,7,9};
        reversearrayfunction(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        
    }
}
