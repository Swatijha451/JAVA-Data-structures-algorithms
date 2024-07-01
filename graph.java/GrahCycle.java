//

import java.util.*;

public class GrahCycle {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void create(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
    //undirectional graph
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
        graph[6].add(new Edge(6,7));
        graph[7].add(new Edge(7,6));
    }
    /*
     * cases
     * 1visited[neighbour] but its not parent
     * visited[neighbour] but it is parent then continue-> do nothing
     * !visited[neighbour]->dfs-visited true->
     */
    public static boolean detectCycle(ArrayList<Edge>graph[]){
        boolean visited[]= new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if (!visited[i]) {
                detectCycleUtil(graph, visited, i, -1);//ther is no parent of source so -1
            }
        }
        return false;

    }
    public static boolean detectCycleUtil(ArrayList<Edge>graph[],boolean visiited[],int curr,int parent){
        visiited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            //case 3
            if (!visiited[e.dest]) {
                if (detectCycleUtil(graph, visiited, e.dest, curr)) {
                    return true;
                }
            }
            //case 1
            else if (visiited[e.dest]&&e.dest!=parent) {
                return true;
            }

        }
        return false;
        //for case 2 -> do nothing

    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge> graph[]=new ArrayList[8];
        create(graph);
        System.out.println(detectCycle(graph));
    }
}
