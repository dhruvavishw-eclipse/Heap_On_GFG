import java.util.*;
public class _02_Kth_Smallest {
    public static void main(String RCB []){
        // Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4

         int  arr[] = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
         int k=4;

         System.out.println(kthSmallest(arr, k)); // Output: 5
    }

   
     public static int kthSmallest(int[] arr, int k) {
           
           PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); // This is max Heap

            for(int ele: arr){   // n log k
                pq.add(ele);  // log k

                if(pq.size()>k) pq.remove();  // log k
                              
            }
            return pq.peek();
        }

}
