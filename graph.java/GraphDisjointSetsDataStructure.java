//store and track overlapping setsa
//find(wihch set does eement belong to),union(join two elemnts )

public class GraphDisjointSetsDataStructure {
    static int n=7;
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
        if (x==parent[x]) {
            return x;
        }
        //recursion function for every parent
        return find(parent[x]);
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
    public static void main(String[] args) {
        init();
        union(1, 2);
        System.out.println(find(2));
    }
}
