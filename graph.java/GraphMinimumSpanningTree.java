/*a minimum spanning tree (MST) or minimum weight spanning tree is a subset  of the edges of connectred edge
 * weighted undirected grah that connects a the vertices together without any cycles and wit minimum possible
 * total edge weight
 * prims algoritm for MST
 */
import java.util.*;
public class GraphMinimumSpanningTree {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;

        }
    }
    public static void create(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
    //undirectiona graph
        graph[0].add(new Edge(0,1, 10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void primsAlgorithm(ArrayList<Edge>graph[]){
        boolean visited[]= new boolean[graph.length];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finacost=0;//total minimum cost
        while (!pq.isEmpty()) {
            Pair curr= pq.remove();
            if (!visited[curr.v]) {
                visited[curr.v]=true;
                finacost+=curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.println(finacost);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>graph[]=new ArrayList[4];
        create(graph);
        primsAlgorithm(graph);
    }
}
