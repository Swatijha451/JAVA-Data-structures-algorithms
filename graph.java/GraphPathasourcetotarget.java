////solve using DFS for directed graph
//exponential time complxity for worst case scenario
import java.util.*;
public class GraphPathasourcetotarget {
    static class Edge{
        int src;
        int dest;
        public Edge(int source,int destination){
            this.src=source;
            this.dest=destination;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        //adjacency list
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
         graph[5].add(new Edge(5, 0));
          graph[5].add(new Edge(5, 2));
        

    }
    public static void printAllath(ArrayList<Edge>graph[],int src,int dest,String path){
        if (src==dest) {
            System.out.println(path+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e= graph[src].get(i);
            printAllath(graph, e.dest, dest, path+src +" ");
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
       ArrayList<Edge>graph[]=new ArrayList[6];
       createGraph(graph);
       printAllath(graph, 5, 1, "");


    }
}
