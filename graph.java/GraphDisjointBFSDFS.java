//two componenets of graph not connected by edge is called disJoint graph

import java.util.*;

public class GraphDisjointBFSDFS {
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
        graph[1].add(new Edge(1, 2));
        

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2, 1));
        

        
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
        graph[6].add(new Edge(6,7));
        graph[7].add(new Edge(7,6));
    } 
    public static void BFS(ArrayList<Edge> graph[]){
        boolean visited[]= new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if (!visited[i]) {
                BFSutil(graph, visited);
            }
        }
    }
    public static void BFSutil(ArrayList<Edge>graph[],boolean visited[]){
        Queue <Integer> q= new LinkedList<>();
        //add source in queue
        q.add(0);
        while (!q.isEmpty()) {
            int curr=q.remove();
            if (!visited[curr]) {
                System.out.print(curr+" ");
                visited[curr]=true;
                 for (int i = 0; i < graph[curr].size(); i++) {
                Edge e= graph[curr].get(i);
                q.add(e.dest);
            }
            }
           
        }

    }
    public static void DFS(ArrayList<Edge>graph[]){
        boolean visited[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSutil(graph, i, visited);
            }
        }


    }
    public static void DFSutil(ArrayList<Edge>graph[],int curr,boolean visited[]){
        System.out.print(curr+" ");
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if (!visited[e.dest]) {
                DFSutil(graph, e.dest, visited);
            }
        }

    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Edge> graph[]=new ArrayList[8];
        create(graph);
        BFS(graph);
    }
}

