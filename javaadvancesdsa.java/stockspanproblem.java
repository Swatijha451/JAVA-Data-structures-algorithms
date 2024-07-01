import java.util.Stack;

public class stockspanproblem {
    public static void stockspanproblem(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;//first eement will aways be 1
        for (int i = 1; i < stocks.length; i++) {
            int currprice=stocks[i];
            while (!s.isEmpty() && currprice>stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i]=i+1;//for last eement
            }
            else{
                int prevhigh=s.peek();
                span[i]=i-prevhigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int stock[]={100,80,60,70,85,100};
        int span[]={1,1,1,2,1,5,6};
        System.out.println(stockspanproblem(stock, span));
    }
    
}
