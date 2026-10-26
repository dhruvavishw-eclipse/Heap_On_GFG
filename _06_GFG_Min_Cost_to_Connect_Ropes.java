import java.util.*;
public class _06_GFG_Min_Cost_to_Connect_Ropes {
    public static void main(String RCB []){
      // Input: arr[] = [4, 2, 7, 6, 9]

      int arr[] = {4, 2, 7, 6, 9};

       System.out.println(minCost(arr)); // Output: 62 

     // Explanation: First, connect ropes 4 and 2, which makes the array [6, 7, 6, 9]. Cost of this 
     //operation 4 + 2 = 6. Next, add ropes 6 and 6, which results in [12, 7, 9]. Cost of this operation 6 + 6 = 12. 
     //Then, add 7 and 9, which makes the array [12,16]. Cost of this operation 7 + 9 = 16. And finally,
     // add these two which gives [28]. Hence, the total cost is 6 + 12 + 16 + 28 = 62.
    }

    
    public static int minCost(int[] arr) {
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       int n=0;
       
       for(int ele: arr){
            pq.add(ele);
       }
         
       while(pq.size()>1){
           int a=pq.poll();
           int b=pq.poll();
          
          pq.add(a+b);
           n+=(a+b);
       }
       
       return n;
        
    }

}
