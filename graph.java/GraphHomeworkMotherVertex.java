//in the given directed graph, find a mother vertex (if prsent). a mother vertex is a vertex whuch 
// we can reach every other vertexices of the graph
import java.util.*;
public class GraphHomeworkMotherVertex {
    public static void addEdge(ArrayList<ArrayList<Integer>>graph,int u,int v){
        graph.get(u).add(v);//add u to v
    }
    public static void DFsutil(ArrayList<ArrayList<Integer>>graph,int v,boolean[]visited){
        visited[v]=true;
        for (int x : graph.get(v)) {
            if (!visited[x]) {
                DFsutil(graph, x,visited);
            }
        }
    }
    public static int motherVertex(ArrayList<ArrayList<Integer>>graph,int V){
        boolean visited[]=new boolean[V];
        int v=-1;
            for(int i=0;i<V;i++){
                if (!visited[i]) {
                    DFsutil(graph,i,visited);
                    v=i;
                }
            }
            boolean check[]=new boolean[V];
            DFsutil(graph, v, check);
            for (boolean val: check) {
                if (!val) {
                    return -1;
                }
                
            }
            
        return v;
    }
    public static void main(String[] args) {
        int V=7;
        
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 1,3);
        addEdge(graph, 4,1);
        addEdge(graph, 6,4);
        addEdge(graph, 5,6);
        addEdge(graph, 5,2);
        addEdge(graph, 6,0);
        System.out.println("the mother vertex "+motherVertex(graph, V));
    }
}
