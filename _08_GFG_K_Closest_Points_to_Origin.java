import java.util.*;
  
 class Triplet implements Comparable<Triplet>    {
     int dist;
     int x;
     int y;

      Triplet(int dist, int x, int y){
        this.dist=dist;
        this.x=x;
        this.y=y;
      }
   
      public int compareTo(Triplet t){
         return Integer.compare(this.dist, t.dist);
      }

 }

public class _08_GFG_K_Closest_Points_to_Origin {
  
    public static void main(String RCB [] ){

        //  points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
        int  points[] [] = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k=2;
       

        System.out.println(kClosest(points, k));  // [[-2, 2], [0, 1]]
    }

     

    public static ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
         // Time complexity: O(n log k)

        ArrayList<ArrayList<Integer>> arr =new ArrayList<>();
        PriorityQueue<Triplet> pq=new PriorityQueue<>(Collections.reverseOrder());

                 for(int [] point: points){
                     int x=point[0], y=point[1];
                     int dist= (x*x) + (y*y);
                     pq.add( new Triplet(dist,x,y));
                     if(pq.size()>k) pq.remove();
                 }             
               
                 while(!pq.isEmpty()){
                     
                    Triplet top=pq.remove();
                    
                      ArrayList<Integer> ans=new ArrayList<>();
                     ans.add(top.x);
                     ans.add(top.y);
                  
                     arr.add(ans);
                 
                 }                 
                 return arr;
    }

}
