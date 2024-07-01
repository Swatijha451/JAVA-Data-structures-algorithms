/*there are n cities connected by some number of flights.you are  given an array flights eher flights where
 * fights[i]= [from,to,price] indicates that there is a flight.
 * you are aso given three integers src,dest,k return the cheapest price from src with at most k stops.If
 * ther is no such route return -1;
 */
import java.util.*;
public class GrapCheapestFightwithKstops {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int source,int destination,int weight){
            this.src=source;
            this.dest=destination;
            this.wt=weight;
        }
    }
    public static void creteGraph(int flights[][],ArrayList<Edge>graph[]){
    for (int i = 0; i < graph.length; i++) {
        graph[i]=new ArrayList<>();

    }
    for (int i = 0; i <flights.length; i++) {
        int src=flights[i][0];
        int dest=flights[i][1];
        int wt= flights[i][2];
        Edge e= new Edge(src,dest,wt);
        graph[src].add(e);
    }
    }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int cost,int stops){
            this.v=v;
            this.cost=cost;
            this.stops=stops;
        }
    }
    @SuppressWarnings("unchecked")
    public static int cheapestFight(int n,int flights[][],int src,int dest,int k){
        ArrayList<Edge>graph[]=new ArrayList[n];
        creteGraph(flights, graph);
        int distance[]=new int[n];
        for (int i = 0; i < n; i++) {
            if (i!=src) {
                distance[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info>q= new LinkedList<>();
        q.add(new Info(src,0, 0));
        while (!q.isEmpty()) {
            Info curr= q.remove();
            if (curr.stops>k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e= graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                //relaxation steps
                if (distance[u]!=Integer.MAX_VALUE&&distance[u]+wt<distance[v]&&curr.stops<=k) {
                    distance[v]=distance[u]+wt;
                    q.add(new Info(v, distance[v], curr.stops+1));
                }
               
            }
        }
         if (distance[dest]==Integer.MAX_VALUE) {
                    return-1;
                }
                else{
                    return distance[dest];
                }
    }
    public static void main(String[] args) {
      int   flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
      System.out.println(cheapestFight(6, flights, 0, 3, 1));
        
    }
}
