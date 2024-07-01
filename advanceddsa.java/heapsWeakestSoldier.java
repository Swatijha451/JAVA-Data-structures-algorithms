import java.util.PriorityQueue;

public class heapsWeakestSoldier {
    //we are given m*n binary matrix of 1s soldier and 0s(civilians). the soldiers are positioned in front of civilians
    //tat is a the 1s will appear to the left of all the 0s in each row
    // a row i is weaeker than the row j ifa. the number of soldiers in 1is lss than the number of soldiers in j
    //bot rows have same number of soldiers and i<j;
    //find the k weakest rows
    static class Row implements Comparable<Row> {
    int soldiers;
    int idx;
    public Row(int soldiers,int idx){
        this.soldiers=soldiers;
        this.idx=idx;

    }
    @Override
    public int compareTo(Row r2){
        if (this.soldiers==r2.soldiers) {
            return this.idx-r2.idx;//lower index is weak
        }
        else{  
            return this.soldiers-r2.soldiers;//else less soldiers
        }
    }
        
    }
    public static void main(String[] args) {
        int army[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;
        
        PriorityQueue<Row>pq= new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            int count=0;
            for (int j = 0; j < army[0].length; j++) {
                count+=army[i][j]==1?1:0;
                
            }
            pq.add(new Row( count,i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R"+pq.remove().idx);
        }    
    }
    
}
