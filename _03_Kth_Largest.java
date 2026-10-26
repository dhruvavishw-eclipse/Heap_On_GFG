import java.util.*;
public class _03_Kth_Largest {
    public static void main(String RCB []){
      // Input: arr[] = [3, 5, 4, 2, 9], k = 3

      int arr[] = {3, 5, 4, 2, 9};
      int k=3;

       System.out.println(largest(arr, k)); // Output: 4
       // Explanation: Third largest element in the array is 4.
    }
   
    static int largest(int arr [], int k){
       PriorityQueue<Integer> pq=new PriorityQueue<>();

       for(int ele: arr){   // n log k
                pq.add(ele);  // log k

                if(pq.size()>k) pq.remove();  // log k
                              
            }
            return pq.peek();
    }

}
