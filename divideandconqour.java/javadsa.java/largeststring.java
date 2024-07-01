public class largeststring {
    public static String largeststringfunction(String fruits[]){
        String str=fruits[0];
        for(int i=1;i<fruits.length;i++){
            if((str.compareTo(fruits[i]))<0){//if compare to function returns 0, the string are equal,<0 str1<str2,>0,str1>str2
                str= fruits[i];

            }

        }
        return str;

    }
    public static void main(String[] args) {
        String fruits[]={"apple","mango","banana","lichi","papaya"};
        System.out.println(largeststringfunction(fruits));
        
    }
    
}
