//shortest path from a single source to all vertices(weighted & directed graph)
//optimization probem->greedy algoritm
//relaxation step -distance[u]+weight(u->v)<distance[v] then distance[v]=ditance[u]+weight(u->v)
import java.util.*;
public class GraphDijakstraAlgorithm {
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
    public static void createGraph(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        //adjacency list
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));
        graph[1].add(new Edge(1, 2,1));
        graph[1].add(new Edge(1, 3,7));
        graph[2].add(new Edge(2,4,3));
         graph[3].add(new Edge(3,5,1));
          graph[4].add(new Edge(4,3,2));
          graph[4].add(new Edge(4,5,5));
        

    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
        
    }
    public static void Dijakstra(ArrayList<Edge>graph[],int src){
        int distance[]= new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i!=src) {
                distance[i]=Integer.MAX_VALUE;//intilizing every distance with infinity except src that is 0
            }
        }
        boolean visited[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();//min heap
        pq.add(new Pair(src, 0));
        //loop
        while (!pq.isEmpty()) {
            Pair curr= pq.remove();
            if (!visited[curr.n]) {
                visited[curr.n]=true;
            }
            //neighboiurs
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e= graph[curr.n].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if (distance[u]+wt<distance[v]) {
                    distance[v]=distance[u]+wt;
                    pq.add(new Pair(v, distance[u]));
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i]+" ");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
         ArrayList<Edge>graph[]=new ArrayList[6];
         createGraph(graph);
         Dijakstra(graph, 0);
    }
}
