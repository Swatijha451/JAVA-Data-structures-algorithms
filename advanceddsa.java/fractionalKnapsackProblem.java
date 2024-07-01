//givem the weights and the value of N items, put these items in a knapsack of capacity wto get the maximum total 
//value in the knapsack 
import java.util.*;
public class fractionalKnapsackProblem {
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;
        //2d array of ratio

        double ratio[][]=new double[val.length][2];
        //0yh column->index , 1th coumn->ration=value/weight
        for (int i = 0; i < val.length; i++) {
            ratio[i][0]=i;//index
            ratio[i][1]=val[i]/(double)weight[i];//finding ratio
        }
        //sorting in ascending order
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=w;
        int finaval=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if (capacity>=weight[idx]) {//include full value
                finaval+=val[idx];
                capacity-=weight[idx];
                
            } else{
                //iclude fraiona item
                finaval+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("the final value "+finaval);
    }

    
}
