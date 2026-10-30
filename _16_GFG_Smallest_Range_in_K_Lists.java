import java.util.*;
public class _16_GFG_Smallest_Range_in_K_Lists {


      public static class Triplet implements Comparable <Triplet>{
        int ele;
        int row;
        int col;
        
      Triplet(int ele, int row, int col){
          this.ele=ele;
          this.row=row;
          this.col=col;
      }
      
      public int compareTo(Triplet t){
          return this.ele - t.ele;
      }
      
    }

    public static void main(String RCB []){
    //   Input: mat[][] = [[4, 7, 9, 12, 15], 
    //            [0, 8, 10, 14, 20], 
    //            [6, 12, 16, 30, 50]]

    //             Output: [6, 8]
// Explanation: Smallest range is formed by number 7 from the first list, 8 from second list and 6 from the third list.

    int mat[][] = {{4, 7, 9, 12, 15}, 
                  {0, 8, 10, 14, 20}, 
                  {6, 12, 16, 30, 50}};

        System.out.println(findSmallestRange(mat));  // Output [6, 8]
     
    }

     public static ArrayList<Integer> findSmallestRange(int[][] mat) {
       int k= mat.length;
       int n=mat[0].length;
       PriorityQueue<Triplet> pq=new PriorityQueue<>();
       int max=Integer.MIN_VALUE;
       int min=Integer.MAX_VALUE;
        
        for(int i=0;i<k;i++){
            max=Math.max(max,mat[i][0]);
            min=Math.min(min,mat[i][0]);
            pq.add( new Triplet (mat[i][0],i,0));
        }
        
        int a=min, b=max;
        
        while(true){ // When we dont know the stopping condition ,it will be stopped when it goes to end of arr
            
            Triplet top=pq.remove();
            int ele=top.ele, row=top.row , col=top.col;
            
            if(max - ele < b-a){
                a=ele;
                b=max;
            }
            if(col==n-1) break;
            int next=mat[row][col+1];
            max=Math.max(max,next);
            pq.add(new Triplet(next, row, col+1));
        }
           ArrayList<Integer> ans=new ArrayList<>();
            ans.add(a);
            ans.add(b);
            return ans;
    }

}
