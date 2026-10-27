import java.util.*;

     class Pair implements Comparable<Pair> {
        int ele;
        int freq;

        Pair(int ele, int freq){
            this.ele=ele;
            this.freq=freq;
        }
     
        public int compareTo(Pair p){
            if(this.freq==p.freq) return this.ele - p.ele;
             return this.freq - p.freq;
        }

     }
   
public class _09_LC_347_Top_K_Frequent_Elements {
    
     public static void main(String[] args) {
        // Input: nums = [1,1,1,2,2,3], k = 2
        int [] nums = {1,1,1,2,2,3};  // LC
        int k=2; // LC        
        int ans []=topKFrequent(nums, k); // Output: [1,2]
        for(int ele:ans){
            System.out.print(ele +" ");  // for printing array
        }
     
        //Input: arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
        // int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        // int k=4;
        // System.out.println(topKFreq(arr, k));  // Output: [5, 11, 7, 10]
     }


      public static int[] topKFrequent(int[] nums, int k) {
        // This one for int [] return type;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int ele: nums){
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int ele: mp.keySet()){
            int freq= mp.get(ele);
            pq.add(new Pair(ele, freq));
            if(pq.size()>k) pq.remove();
        }

       int [] ans=new int [k];
        for(int i=0;i<k;i++){
            Pair top=pq.remove();
            ans[i]=top.ele;
        }

        return ans;

    }
    


     public static ArrayList<Integer> topKFreq(int[] arr, int k) {
       // This one for GFG because of ArrayList return type;
        HashMap<Integer,Integer> mp=new HashMap<>();
               for(int ele:arr){
                   mp.put(ele,mp.getOrDefault(ele,0)+1);
               }

               PriorityQueue<Pair> pq=new PriorityQueue<>();
               for(int ele: mp.keySet()){
                   int freq= mp.get(ele);
                   pq.add(new Pair(ele, freq));
                   if(pq.size()>k) pq.remove();
               }

               ArrayList<Integer> ans=new ArrayList<>();
               while(pq.size()>0){
                  Pair top=pq.remove();
                  ans.add(top.ele);
               }
               
               Collections.reverse(ans);
               return ans;
    }


}
