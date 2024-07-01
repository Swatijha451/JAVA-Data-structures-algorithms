import java.util.ArrayList;
//monotonous arraylist increasing or decreasing
import java.util.Collections;

public class homeworkarraylst {
    public static boolean monotone(ArrayList<Integer>list){
        boolean inc=true;
        boolean dec= true;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                inc=false;
            }
            if(list.get(i)<list.get(i+1)){
                dec= false;

            }
        }
        return inc||dec;
        
        
    }
    //find the onely number 
    public static ArrayList<Integer> lonely(ArrayList<Integer>list1){
        Collections.sort(list1);
        ArrayList <Integer> list2=new ArrayList<>();
        for(int i=1;i<list1.size()-1;i++){
            if(list1.get(i-1)+1<list1.get(i) &&list1.get(i)+1<list1.get(i+1)){
                list2.add(list1.get(i));
            }
        }
        if(list1.size()==1){
            list2.add(list1.get(0));

        }
        if (list1.size()>1) {
            if(list1.get(0)+1<list1.get(1)){
                list2.add(list1.get(0));
            }    
        }
        if(list1.get(list1.size()-2)+1<list1.get(list1.size()-1)){
            list2.add(list1.get(list1.size()-1));

        }
    
        return list2;
    }
    //
        
    
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        list.add(11);
        System.out.println(lonely(list));

    }
}
