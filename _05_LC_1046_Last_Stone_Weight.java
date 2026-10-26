import java.util.*;
public class _05_LC_1046_Last_Stone_Weight {
    public static void main(String RCB []){
     //  Input: stones = [2,7,4,1,8,1]
        
       int [] stones = {2,7,4,1,8,1}; 

        System.out.println(lastStoneWeight(stones)); // Output: 1
    }

    
     public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: stones){
            pq.add(ele);
        }

        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();

            if(x!=y){
                pq.add(y-x);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

}
