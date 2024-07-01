//nearby cars robem- we are goven n points on a 2d plane ehich are locations of N cars. If we are at the origin
//print the nearest k cars

import java.util.PriorityQueue;

public class heapsproblemNearsetKCars {
    static class point implements Comparable<point>{
        int x;
        int y;
        int distanceSQ;
        point(int x,int y,int distamceSQ){
            this.x=x;
            this.y=y;
            this.distanceSQ=distamceSQ;
        }
        @Override
        public int compareTo(point p2){
            return this.distanceSQ-p2.distanceSQ;//ascending order sorting
        }
    }
    public static void main(String[] args) {
        int pts[][]={{3,3},{5,-1},{2,4}};
        int k=2;
        PriorityQueue<point>pq= new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distSQ=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new point(pts[i][0], pts[i][1], distSQ));
        }
        //nearsdt k cars
        for(int i=0;i<k;i++){
            System.out.println("c"+pq.remove().x);
        }
    }


}
                                                                
































    





































































    
