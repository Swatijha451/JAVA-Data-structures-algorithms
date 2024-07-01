//implement union find algorithm to check whether an undirected graph contains cycle or not

public class GraphHomeworkUnionFindDetectCycle {
    static int V;
    Edge edge[];
    static class Edge{
        int src,dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    static int parent[]=new int[V];
    static int rank[]=new int[V];// initiay rank of every eement is 0
    //intilizing parnt for every element wit itself
    public static void init(){
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
    }
    public static int find(int x){
        if (parent[x]==x) {
            return x;
        }
        return find( parent[x]);
    }
    public static void union(int a,int b){
        int parentA=find(a);
        int parentB=find(b);
        if (rank[parentA]==rank[parentB]) {
            parent[parentB]=parentA;//b as now become parent of a
            rank[parentA]++;
        }
        else if (rank[parentA]<rank[parentB]) {
            parent[parentA]=parentB;
        }
        else{
            parent[parentB]=parentA;
        }
    }
    public static boolean isCycle( )

}
