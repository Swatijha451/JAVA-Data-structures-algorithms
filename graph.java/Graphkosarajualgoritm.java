//Strongly connected Component(scc) is a component of grah in which we can reach every vertex of te component
//from evry other vertex in that component. to find scc we need Kosarajus Agorithm-TC-O(V+E)
//it is a dfs based aggoritm, we wi do reverse dfs
//STEPS-get nodes in stack after topological sort->trnspose graph(copy graph) wher te edges direct opposite of 
//its original direction->do dfs according to stack nodes on te transpose graph
import java.util.*;
public class Graphkosarajualgoritm {
    static class Edge{
    int src;
    int dest;
 public Edge(int src,int dest){
        this.src=src;
        this.dest=dest;

    }
}
public static void create(ArrayList<Edge>graph[]){
    for (int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));
    graph[1].add(new Edge(1,0));
    graph[2].add(new Edge(2,1));
    graph[3].add(new Edge(3,4));

}
    public static void topsort(ArrayList<Edge>graph[],int curr,boolean visited[],Stack<Integer>s){
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if (!visited[e.dest]) {
                topsort(graph, e.dest, visited, s);
            }
        }
        s.push(curr);

    }
    public static void KosarajuAlgoritm(ArrayList<Edge>graph[],int v){
        //step 1
        Stack<Integer>s= new Stack<>();
        boolean visited[]= new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topsort(graph, i, visited, s);
            }
        }
        @SuppressWarnings("unchecked")
        //step 2
        ArrayList<Edge>transpose[]=new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            transpose[i]=new ArrayList<Edge>();//initialiszing transpose graph

        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j <graph[i].size();) {
                Edge e= graph[i].get(j);
                transpose[e.dest].
            }
        }
        //step 3
         while(!s.isEmpty()) {
           int curr=s.pop();
           if(!visited[curr]){
            dfs(transpose,curr,visited);
           } 
           System.out.println();
        }
        
    }
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean visited){
        visited[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph,e.dest,visited);
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        create(graph);
        KosarajuAlgoritm(graph,v);

    }
}
