public class removeduplicatesstringrecursion {
    public static void removeduplicatte(String str,int idx,StringBuilder newStr, boolean map[]){
        //base case
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        //kaam
        char currchar=str.charAt(idx);
        //the case where already exist the word in  string which ios stored as true in our boolean array map
        if(map[currchar-'a']==true){
            //call the recursive function for next index
            removeduplicatte(str, idx+1, newStr, map);

        }
        //the other case where duplicate does not exist
        else{
            map[currchar-'a']=true;
            removeduplicatte(str, idx+1, newStr.append(currchar), map);
        }
    }
    public static void main(String[] args) {
        String str= "appnaacollegee";
        removeduplicatte(str, 0,new StringBuilder(""),new boolean[26]);
    }
}
