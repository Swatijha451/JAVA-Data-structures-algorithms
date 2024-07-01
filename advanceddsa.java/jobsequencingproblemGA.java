//given an array of jobs where every job has a deadine and profit. I is aso given that every job takes atleastsingle
//unit of time,so the minimum possible deadline for any job is 1.maximize te tota profit schedued at atime
import java.util.*;
public class jobsequencingproblemGA {
    //creting a class 
    static class Job{
        int deadline;
        int profit;
        int id;
         Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs=new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));//index//deadine//profit

        }
        //short form of comparator function
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);//descending order of profit
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if (curr.deadline>time) {
                seq.add(curr.id);
                time++;
            }
        }
        //print sequence
        System.out.println("max job "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
