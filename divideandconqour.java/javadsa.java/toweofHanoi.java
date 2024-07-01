public class toweofHanoi {
    public static void toweofhanoifunc(int n, String source, String helper, String destination ){
        if(n==1){
            System.out.println("tranfer disk "+n+" from "+source+" to "+destination);
            return;
        }
        // transfer top n-1 from source to helper using destination as helper
        toweofhanoifunc(n-1, source, destination, helper);
        //tranfer nTh disk from source to destinat
        System.out.println("transfer disk " + n +" from "+source+" to "+helper);
        //transfer n-1 from helper to destination using source as elper
        toweofhanoifunc(n-1, helper,source, destination);
    }
    public static void main(String[] args) {
        int  n=4;
        toweofhanoifunc(n, "A","B" , "C");
    }
}
    

