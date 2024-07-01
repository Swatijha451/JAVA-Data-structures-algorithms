public class binarysearch {
    public static int binarysearchfunction(int arr[],int key){
        int start=0;
        int end= arr.length-1;
        
        while(start<end){
            int mid= (start+end)/2;


            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]<key){
                start= mid+1;
            }
            else{
                end= mid-1;
            }
        }
        return -1;// if the while condition is not true
    }
    public static void main(String[] args) {
        int numbersarray[]= {2,3,5,7,8,9,10,11};
        int key= 10;
        System.out.println("the number is at index "+binarysearchfunction(numbersarray,key));

    }
    
}
