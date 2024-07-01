//network of nodes,ec node is called vertex(vertices),and connection is called edge
//types of Graph(dirction)->undirectinal,bidirectional,directional
//types of Graph(Types of edge)->weighted,unweighted
//Graph can be reprsented as-.ArrayList<ArrayList>,Array<Arraylist>,HashMap<Integer,List>(Vertex,value)
import java.util.*;
public class Graphcreate{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;

        }
    }
    public static void create(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
    //undirectiona graph
        graph[0].add(new Edge(0,1, 1));
        graph[1].add(new Edge(1, 0,1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2,4,1));
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,2,1));
        graph[4].add(new Edge(4,2,1));
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices=5;//number of nodes
        @SuppressWarnings("uncecked")
        ArrayList<Edge> graph[]=new ArrayList[vertices];
        create(graph);
        //1s neighbour
        for (int i = 0; i < graph[1].size(); i++) {
            Edge e=graph[1].get(i);
            System.out.println(e.dest);
        }

        
        
    }

}
