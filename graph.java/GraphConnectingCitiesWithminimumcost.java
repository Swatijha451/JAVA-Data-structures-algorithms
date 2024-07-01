//coonecting cities with minimum cost for connecting all cities on the map
//use Prims Algorithm(mst-.minimum spanning tree)
import java.util.*;
public class GraphConnectingCitiesWithminimumcost {
    static class Edge implements Comparable<Edge>{
        int detsination;
        int cost;
        public Edge(int dest,int cost){
            this.detsination=dest;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge e2){
            return this.cost-e2.cost;
        }
    }
    public static int ConnectCities(int cities[][]){
        PriorityQueue<Edge>pq=new PriorityQueue<>();
        boolean visited[]=new boolean[cities.length];
        pq.add(new Edge(0, 0));//source
        int finacost=0;
        //prims algorithm
        while (!pq.isEmpty()) {
            Edge curr=pq.remove();
            if (!visited[curr.detsination]) {
                visited[curr.detsination]=true;
                finacost+=curr.cost;
                for (int i = 0; i < cities[curr.detsination].length; i++) {
                    if (cities[curr.detsination][i]!=0) {//where ther is 0 edge wil not exist
                        pq.add(new Edge(i, cities[curr.detsination][i]));
                    }
                }
            }
        }
        return finacost;
    }
   
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(ConnectCities(cities));
    }
}
