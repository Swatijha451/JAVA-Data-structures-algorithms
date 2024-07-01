//you are gioven n activities with their start and end times. find the maximum numbe rof activities
//that can be performed by a singe  person.
//non-overlaoing or disjoint sets
//greedy algorithm
import java.util.*;

public class axtivityseectionga{
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={6,4,7,9,2,9};
        int activities[][]=new int[start.length][3];
        //sorting the end time in ascending order
        for (int i = 0; i < start.length; i++) {
            activities[i][0]=i;//index
            activities[i][1]=start[i];//start time
            activities[i][2]=end[i];//end time
            
        }
        //lambda fuction to sort 2d array 
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        int maxact=0;
        ArrayList<Integer> ans=new ArrayList<>();
        //ist activity we take te first  one so
        maxact=1;
        ans.add (activities[0][0]);
        int lastend=activities[0][2];
        for(int i=0;i<end.length;i++){
            if(activities[i][1]<=lastend){
                //activity selected
                maxact++;
                ans.add(activities[i][0]);//adding te index in ans
                lastend=activities[i][2];
            }
        }
        System.out.println("te maximum number of activities "+maxact);
        for (int i=0;i<ans.size();i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();

    }

}