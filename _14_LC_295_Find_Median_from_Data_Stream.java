import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> min=new PriorityQueue<>();
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       if(max.size()==0) max.add(num);
       else{
         if(num < max.peek()) max.add(num);
          else min.add(num);
       }

       if(max.size() == min.size()+2) min.add(max.remove());

        if(min.size() == max.size() +2) max.add(min.remove());
    }
    
    public double findMedian() {
       if(max.size() == min.size() +1) return max.peek();
       else if(min.size() == max.size() +1) return min.peek();
       else return (max.peek() + min.peek())/2.0;   // This code did not get any error while returning the value in double
         
       
    }
}
  

public class _14_LC_295_Find_Median_from_Data_Stream {

    public static void main(String RCB []){

    }
}




