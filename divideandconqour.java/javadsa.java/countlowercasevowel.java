public class countlowercasevowel {
    public static int lowecasevowel(String str){
        
        int count=0;
        
        
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            
            if(ch=='a'||ch=='i'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;

            }
        
    }
    return count;
}
    public static void main(String[] args) {
        String str= "ihateyou";
        System.out.println(lowecasevowel(str));
    }
}
