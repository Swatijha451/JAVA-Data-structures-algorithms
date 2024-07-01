//a vertex in an undirected grap is an articulation point if removing it (and edges through it) increases
//the connected component of grapg bascally splitton one graph into more than one. It is aso called point of
//vulnerability in a network
//we use TARJANS Algoritm O(V+E)
import java.util.*;
public class GraphArticulationpoint {
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
    public static void dfs(ArrayList<Edge>graph[],int curr, int parent,int[] dt,int[] lowD,int sourceT,boolean visited[]){
        visited[curr]=true;
        dt[curr]=lowD[curr]=++sourceT;
        int children=0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int neighbour=e.dest;
            if (parent==neighbour) {
                continue;
            }
            else if(!visited[neighbour]){
                lowD[curr]=Math.min(lowD[curr],dt[neighbour]);
            }
            else{
                dfs(graph, neighbour, curr, dt, lowD, sourceT, visited);
                lowD[curr]=Math.min(lowD[curr], lowD[neighbour]);
                if (parent!=-1&&dt[curr]<=lowD[neighbour]) {
                    System.out.println("AP:"+curr);
                }
                children++;
            }
        }
        if (parent==-1&&children>1) {
            System.out.println("ap:"+curr);
        }

    }
    public static void getAP(ArrayList<Edge> graph[],int v){
        int dt[]=new int[v];
        int lowD[]=new int[v];
        int sourcet=0;
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if (!visited[i]) {
                //dfs
                dfs(graph, i, -1, dt, lowD, sourcet, visited);
            }

        }

    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>graph[]=new ArrayList[v];
        create(graph);
        getAP(graph, v);
        
    }
}
