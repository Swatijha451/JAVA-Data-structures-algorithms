//Bridge is an edge whose deetion increases the graph's number of connected components, it is mostly eformed in 
//undirected graph. we use TARJAN's Algorithm->we need two arrays ->dt[] for discovery time of each vertex ->
//lo[] for lowest discovery time of a neighbours. discovery time of source is 0.

import java.util.ArrayList;

public class graphBridge {
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
public static void dfs(ArrayList<Edge>graph[],int curr,int parent,boolean visited[],int discvertT[],
 int lowDiscovery[],int sourceT){
    visited[curr]=true;
    discvertT[curr]=lowDiscovery[curr]=++sourceT;
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e= graph[curr].get(i);
        int neighbour= e.dest;
        if(parent==neighbour){
            continue;//ignoore
        }
        else if(!visited[neighbour]){
            dfs(graph, neighbour, curr, visited, discvertT, lowDiscovery, sourceT);
            lowDiscovery[curr]=Math.min(lowDiscovery[curr],lowDiscovery[neighbour]);
            if (discvertT[curr]<lowDiscovery[neighbour]) {
                System.out.println("Bridge:"+curr+"---->"+neighbour);
            }
        }
        else{
            lowDiscovery[curr]=Math.min(lowDiscovery[curr], discvertT[neighbour]);
        }
    }
}
public static void TarjanAlgorithm(ArrayList<Edge>graph[],int v){
    int discvertT[]=new int[v];int[] lowDiscovery=new int[v];boolean[] visited=new boolean[v];
    int sourceT=0;
    for (int i = 0; i < v; i++) {
        if (!visited[i]) {
            dfs(graph,i,-1, visited, discvertT, lowDiscovery, sourceT);
        }
    }
    

}
public static void main(String[] args) {
    int v=5;
    @SuppressWarnings("unchecked")
    ArrayList<Edge>graph[]=new ArrayList[v];
    TarjanAlgorithm(graph,v);
}
}
