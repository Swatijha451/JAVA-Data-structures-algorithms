//A bipartite(two paritions) graph  is ehere vertices can be divided into two independebt sets U and v such that every edge(u,v)
//either connects a vertex from U to V or vertex from V to U . In oter words for every edge (u,v) either u beong 
// to U and v belongs to V or vertex from U to V.we can aso say that there is no edge that conncets vertices of same set
//graph coloring concept->-1-no color,0-yellow color,1-blue color
//cases for neighbour-has color(same)->false,has color(differnt)->do nothing continue,no color-color it yello

//graph coloring algorithm
import java.util.*;
public class GraphBiartite {//O(V+E)
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>graph[]){
        int col[]=new int[graph.length];//to add corrsponding color for each vertex
        for(int i=0;i<col.length;i++){
            col[i]=-1;//initializing evey vertex with no color
        }
        Queue<Integer>q= new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i]==-1) {//bfs
                q.add(i);
                col[i]=0;//yellow
                while (!q.isEmpty()) {
                    int curr=q.remove();
                    for (int j = 0; j <graph[curr].size(); j++) {
                        Edge e=graph[curr].get(j);
                        if (col[e.dest]==-1) {
                            int nextcol=col[curr]==0?1:0;
                            col[e.dest]=nextcol;
                            q.add(e.dest);
                        }
                        else if (col[e.dest]==col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void create(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        ArrayList<Edge>graph[]= new ArrayList[6];
        create(graph);
        System.out.println(isBipartite(graph));

    }

}
