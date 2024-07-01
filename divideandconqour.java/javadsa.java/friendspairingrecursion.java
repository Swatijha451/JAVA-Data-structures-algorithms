public class friendspairingrecursion {
    public static int friendspairing(int n){
        //basecase
        if(n==0||n==1){
            return 1;
        }
        //when the person choses to be single
        int fnm1=friendspairing(n-1);
        //when choice is for pairing with others
        int pairing=friendspairing(n-2);
        int numberofways=(n-1)*pairing;
        return fnm1+numberofways;
    }
    public static void main(String[] args) {
        System.out.println(friendspairing(3));
    }
}
