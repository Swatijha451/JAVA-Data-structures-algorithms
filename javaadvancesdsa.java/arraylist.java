import java.util.ArrayList;
import java.util.Collections;

public class arraylist{
    public static void main(String[] args) {
        //declaration
        ArrayList<Integer> list=new ArrayList<>();
        //adding elements in arraylist
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //prnting the list
        System.out.println(list);
        //accessing the element of arraylist
       int element= list.get(0);
       System.out.println(element);
       // deleting an element;
       list.remove(2);
       System.out.println(list);
       // set operation
       list .set(2, 20);
       System.out.println(list);
       //containds fuunction
       System.out.println(list.contains(5));
       //running loop on arraylist
       for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
       }
       System.out.println();
      //reverse of arraylist
      for(int i=list.size()-1;i>=0;i--){
        System.out.print(list.get(i)+" ");

      }
      System.out.println();
      //maximum in arraylist
      int max= Integer.MIN_VALUE;
      for(int i=0;i<list.size();i++){
        if(max<list.get(i)){
            max=list.get(i);
        }
      }
      System.out.println(("max element "+max));
      //swap two numbers
      int temp=list.get(2);
      list.set(2, list.get(3));
      list.set(3, temp);
      System.out.println(list+" ");
      //sorting an arrylist
      //ascending by default;
      Collections.sort(list);
      System.out.print(list);
      System.out.println();
      //descening
      Collections.sort(list,Collections.reverseOrder());
      System.out.print(list);
      System.out.println();
      //add arrrayist inside arraylist
      ArrayList<ArrayList<Integer>>mainlist=new ArrayList<>();
      ArrayList<Integer>list1= new ArrayList<>();
      list1.add(1);list1.add(2);
      mainlist.add(list1);
      ArrayList<Integer>list2= new ArrayList<>();
      list2.add(3);list2.add(4);
      mainlist.add(list2);
      //printing te arraylist
      System.out.print(mainlist);
      System.out.println();
      for(int i=0;i<mainlist.size();i++){
        ArrayList<Integer>currlist=mainlist.get(i);
        for(int j=0;j<currlist.size();j++){
            System.out.print(currlist.get(j)+" ");
            
        }
        System.out.println();
      }
      System.out.println();
    }
}