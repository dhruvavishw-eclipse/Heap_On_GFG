import java.util.*;
public class _15_GFG_Median_in_Stream {
    
    public static ArrayList<Double> getMedian(int[] arr) {
      ArrayList<Double> ans= new ArrayList<>();
      PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> min=new PriorityQueue<>();
     
      for(int x: arr){
          if(max.isEmpty() || x<=max.peek()) max.add(x);
          else min.add(x);
          
          if(max.size() > min.size() +1) min.add(max.remove());
          else if(min.size() > max.size() ) max.offer(min.poll());
         
         double median;
         
         if(max.size() > min.size()) median=max.peek();
          
          else median= (max.peek() + min.peek())/2.0;
          
          ans.add(median);
      }
      
     return ans;
      
    }

    public static void main(String RCB []){
    //   Input: arr[] = [5, 15, 1, 3, 2, 8]
      int arr[] = {5, 15, 1, 3, 2, 8};

      System.out.println(getMedian(arr));  //Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0] 
    }
}
