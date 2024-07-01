// returns MST(minimum spanning tree) and greedy algorithm
//sort edges,take minimum cost edge,if not forming cycle incude in ans
//O(v+eloge)
import java.util.*;
public class GraphKruskalsAgoritm {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }
    public static void creategraph(ArrayList<Edge>edges){
        edges.add(new Edge(0, 1 ,10));
        edges.add(new Edge(0, 2 ,15));
        edges.add(new Edge(0, 3 ,30));
        edges.add(new Edge(1, 2 ,40));
        edges.add(new Edge(2, 3 ,50));

    }
    static int n=4;
    static int rank[]=new int[n];// initiay rank of every eement is 0
    static int parent[]=new int[n];
    //intilizing parnt for every element wit itself
    public static void init(){
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
    }
    //find returns arent of every element
    public static int find(int x){
        //base case
        if (parent[x]==x) {
            return x;
        }
        //recursion function for every parent
        return parent[x]=find(parent[x]);
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
    public static void kruskalsAgorithm(ArrayList<Edge>edges,int v){
        init();
        Collections.sort(edges);
        int mstCost=0;
        int count=0;
        for(int i=0;count<v-1;i++){
            Edge e=edges.get(i);
            int parentA=find(e.src);
            int parentB=find(e.dest);
            if (parentA!=parentB) {
                union(e.src,e.dest);
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        ArrayList<Edge>edges=new ArrayList<>();
        creategraph(edges);
        kruskalsAgorithm(edges, 4);

        }
    
}
