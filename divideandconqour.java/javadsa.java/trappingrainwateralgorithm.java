public class trappingrainwateralgorithm {
    public static int trappedwaterfuction(int height[]){
        int n= height.length;
        //calculate left max boundary in an array
        int leftmax[]= new int[n];
        leftmax[0]=height[0];
        for (int i=1;i<n;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);

        }
        //calculate right max boundary in an array for each bar
        int rightmax[]=new int[n];
        rightmax[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        } 
        int trappedwater=0;
        //loop
        for(int i=0;i<n;i++){
            //fin minof left max and rightmax
            int waterlevel= Math.min(rightmax[i],leftmax[i]);
            //calculate trapped water by(min boundary-height of bar)*widthof bar 
            trappedwater += waterlevel-height[i];
        }
        return trappedwater;


         
        
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};  
       System.out.println( trappedwaterfuction(height));
    }
} 
