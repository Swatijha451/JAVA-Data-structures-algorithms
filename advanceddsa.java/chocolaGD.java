/*we are fiven a bar of choclate composed of m*n squares peices. one shuld break te choclate into single squares.
 * each break is charged a cost expressed by a positive integer . the cost does not depend on thesize of choclate 
 * but only on the line te line te break goes along. let us denote the the costt of breaking the aong the consequtive 
 * vertical lines with x1,x2,x3,x4....xn-1 and along horizontal lines y1,y2,...yn-1.compute the minimal cost
 * of breaking the whoe choclre into single pieces
 */
import java.util.*;
public class chocolaGD {
    public static void main(String[] args) {
        Integer costVer[]={2,1,3,1,4};
        Integer costHorz[]={4,1,2};
        //soring in descending order
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costVer,Collections.reverseOrder());
        int h=0,v=0;//taking pointers horizontal and vertical
        int hp=1,vp=1;//intiaizing price
        int cost=0;
        while (h<costHorz.length&&v<costVer.length) {
            if (costVer[v]<=costHorz[h]) {
                cost+=(costHorz[h]*hp);
                hp++;
                h++;

            }else{
                cost+=(costVer[v]*vp);
                vp++;
                v++;
            }
        }
        //for the rest after te comparison 
        while (h<costHorz.length) {
            cost+=(costHorz[h]*hp);
                hp++;
                h++;
        }
        while (v<costVer.length) {
             cost+=(costVer[v]*vp);
                vp++;
                v++;
        }
        System.out.println("te minimum cost of the cuts is "+cost);
    }
}
