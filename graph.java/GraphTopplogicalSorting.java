/*Directed acyclic Graph(DAG) is a directed Graph that does not have any cycle.Topologica sorting is used 
 * only for DAGs. it is a inera order of vertices such that every directed edge u->v, te vertex U comes aftr
 * v in the order
 * this is bacicay dependancy uing dfs
 */
import java.util.*;
public class GraphTopplogicalSorting {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static  void topologicalSort(ArrayList<Edge>graph[]){
        boolean[]visited=new boolean[graph.length];
        Stack<Integer>s= new Stack<>();
        for(int i=1;i<graph.length;i++){
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, s);
            }
        }
        while (!s.empty()) {
            System.out.print(s.pop()+" ");
        }
    }
    public static void topologicalSortUtil(ArrayList<Edge>graph[],int curr,boolean visited[],Stack<Integer>s){
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSortUtil(graph, e.dest, visited, s);
            }
        }
        s.push(curr);

    }
    public static void create(ArrayList<Edge>graph[]){
        for (int i = 0; i <graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[1].add(new Edge(1, 2));
         graph[1].add(new Edge(1, 3));
          graph[2].add(new Edge(2, 4));
           graph[3].add(new Edge(3, 4));


    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>graph[]=new ArrayList[5];
        create(graph);
        topologicalSort(graph);
    }
}
