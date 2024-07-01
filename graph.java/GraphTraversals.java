//two types of graph traversals-.Breadth first Search(BFS),Deapth First Search(DFS);
//here Bfs-Go to immediate neighours of vertex ,create a queue,create a booleaan array visited

import java.util.*;

public class GraphTraversals {
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
public static void bfs(ArrayList<Edge>[]graph){
    Queue<Integer>q=new LinkedList<>();
    boolean visited[]= new boolean[graph.length];
    //add source in queue
    q.add(0); 
    while (!q.isEmpty()) {
        int curr=q.remove();

        if (!visited[curr]) {//if curr is not visiited then
            System.out.print(curr+" ");//rint curr amd make it true in visited
            visited[curr]=true;
            //add neighbours of curr in queue
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e= graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }
}
//dfs is a recursive function 
//keep going to the 1st neigtbour
//make a recursive cal for curr's neighbour
public static void dfs(ArrayList<Edge>graph[],int curr, boolean []visited){
    //visit
    System.out.print(curr+" ");
    visited[curr]=true;
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e= graph[curr].get(i);
        if (!visited[e.dest]) {
            dfs(graph, e.dest, visited);
        }
    }
}
//for a given source and destination, tell if a path exists from source to destination
//fact: for a disjoint graph path does not exist
public static boolean hasPath(ArrayList<Edge>graph[],int src,int dest,boolean visited[]){
    //base case
    if (src==dest) {
        return true;
    }
    visited[src]=true;
    //find edge
    for(int i=0;i<graph[src].size();i++){
        Edge e= graph[src].get(i);
    
    //e.dest=neighbour of curr
    if (!visited[e.dest]&&hasPath(graph, e.dest, dest, visited)) {
        return true;
    }
}
return false;
}
@SuppressWarnings("unchecked")
public static void main(String[] args) {
    ArrayList<Edge>[]graph= new ArrayList[8];
    create(graph);
    System.out.println(hasPath(graph, 0, 9,new boolean[graph.length]));
}
}
