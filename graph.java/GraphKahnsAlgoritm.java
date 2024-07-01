//topologica sort using BFS->Kahn's Algorithm
/*Concet of indegree and outdegree 
 *  number of edges coming towards vertex are indgree and going out of vertex is outdegree
 * A dAG has at least 1 ertex with indegree 0 and outdegree 0
 */
import java.util.*;
public class GraphKahnsAlgoritm {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void topplogicaSort(ArrayList<Edge>graph[]){
        int inDegree[]=new int[graph.length];
        calcIndegree(graph, inDegree);
        Queue<Integer>q= new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0) {
                q.add(i);
            }
        }
        //BFS
        while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.print((curr)+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                inDegree[e.dest]--;
                if (inDegree[e.dest]==0) {
                    q.add(e.dest);
                }

            }
        }
        System.out.println();
        
    }
    public static void create(ArrayList<Edge>graph[]){
        for (int i = 0; i <graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
          graph[2].add(new Edge(2, 3));

           graph[3].add(new Edge(3, 1));

           graph[4].add(new Edge(4, 0));
           graph[4].add(new Edge(4, 1));

           graph[5].add(new Edge(5, 0));
           graph[5].add(new Edge(5, 2));
    }
    public static void calcIndegree(ArrayList<Edge>graph[],int inDegree[]){
        for (int i = 0; i <graph.length; i++) {
            int vertex=i;
            for (int j = 0; j < graph[vertex].size(); j++) {
                Edge e= graph[vertex].get(j);
                inDegree[e.dest]++;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge>graph[]=new ArrayList[6];
        create(graph);
        topplogicaSort(graph);
    }
}
