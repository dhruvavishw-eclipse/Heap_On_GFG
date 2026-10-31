import java.util.*;
public class _17_LC_632_Smallest_Range_Covering_Elements_from_K_Lists {
    
    public static class Triplet implements Comparable<Triplet> {
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

    public static void main(String[] args) {
        // Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
     List<List<Integer>> nums = new ArrayList<>(Arrays.asList( new ArrayList<>(Arrays.asList(4, 10, 15,24,26)),
                                                               new ArrayList<>(Arrays.asList(0, 9, 12, 20)),
                                                               new ArrayList<>(Arrays.asList(5, 18, 22, 30)) ));
                  
        System.out.println(smallestRange(nums)); 
                                                                         
    }


    public static int[] smallestRange(List<List<Integer>> nums) {
        int ans []={0, Integer.MAX_VALUE};
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        int k=nums.size();
        int max=Integer.MIN_VALUE;

        for(int i=0; i<k;i++){
            int ele=nums.get(i).get(0);
            pq.add(new Triplet (ele,i,0));
            max=Math.max(max,ele);
        }
        
        while(true){
            Triplet top=pq.remove();
            int ele=top.ele;
            int row=top.row;
            int col=top.col;

            if((max - ele) < (ans[1] - ans[0])){
               ans[0]=ele;
               ans[1]=max;
            }

            if(col==nums.get(row).size()-1) break;
            int next=nums.get(row).get(col+1);
            max=Math.max(max,next);
            pq.add( new Triplet(next,row,col+1));
        }
       return ans;
    }

}
