import java.util.*;
public class _01_Priority_Queue {
    
    public static void main(String RCB []){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(17);
        pq.add(18);
        pq.add(10);
        pq.add(7);

        System.out.println(pq.peek()); // To show smallest element in Heap(This is min Heap).

        System.out.println(pq.remove());  // Remove the smallest element. 

        System.out.println(pq.size()); // For knowing how much elements are in Priority Queue. 

        System.out.println(pq);  // To print the whole Priority Queue.

        for(int ele : pq){
            System.out.print(ele + " "); // It is also be print by Iterative met hod
        }
    }
}

  