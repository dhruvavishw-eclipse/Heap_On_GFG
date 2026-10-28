import java.util.*;
    
   class Pair implements Comparable<Pair> {
        int ele;
        int absV;

        Pair(int ele,int absV){
            this.ele=ele;
            this.absV=absV;
        }
     
       public int compareTo(Pair p){
           if (this.absV != p.absV)    return Integer.compare(this.absV, p.absV);
    
         return Integer.compare(this.ele, p.ele);

       }
    }

public class _10_LC_658_Find_K_Closest_Elements {
    public static void main (String RCB []){
        // Input: arr = [1,1,2,3,4,5], k = 4, x = -1      
        int [] arr = {1,1,2,3,4,5};
        int  k = 4, x = -1;
        //  LC 
        System.out.println(findClosestElements(arr, k, x));  // Output: [1,1,2,3]

         // GFG 
        System.out.println(findKClosest(arr, k, x));  //

     
    }

    
      public static  List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;

         for(int  ele: arr){
            int temp=Math.abs(x-ele);
            pq.add(new Pair(ele,temp));
         }
        
        while(pq.size()>k)   pq.remove();
            
        while(!pq.isEmpty()){
             Pair top= pq.remove();
             ans.add(top.ele);       
        }

        Collections.sort(ans);       
        return ans;
    }


    public static ArrayList<Integer> findKClosest(int[] arr, int k, int x) {

            PriorityQueue<Pair> pq =
                new PriorityQueue<>(Collections.reverseOrder());

            for (int ele : arr) {

                // Exclude x itself.
                if (ele == x) {
                    continue;
                }

                int temp = Math.abs(x - ele);
                pq.add(new Pair(ele, temp));

                if (pq.size() > k) {
                    pq.remove();
                }
            }

            ArrayList<Pair> selected = new ArrayList<>(pq);

            // Closest first; on ties, larger element first.
            selected.sort((a, b) -> {
                if (a.absV != b.absV) {
                    return Integer.compare(a.absV, b.absV);
                }

                return Integer.compare(b.ele, a.ele);
            });

            ArrayList<Integer> ans = new ArrayList<>();

            for (Pair p : selected) {
                ans.add(p.ele);
            }

            return ans;
        }


}
