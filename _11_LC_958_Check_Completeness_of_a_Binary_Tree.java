import java.util.*;

import org.w3c.dom.Node;
public class _11_LC_958_Check_Completeness_of_a_Binary_Tree {

   static class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
   
    static int s;
   public static void main(String[] args) {
      // input root [10, 20, 30, 40, 60, N, N];

      Node root=new Node(10);
      Node a=new Node(20);
      Node b=new Node(30);
      root.left=a;
      root.right=b;

      Node c=new Node(40);
      Node d=new Node(60);
      a.left=c;
      a.right=d;

      System.out.println(isHeap(root));

   }

   
    
    public static boolean isHeap(Node root) {
       s=size(root);      
       return check(root) && isCBT(root,1);        
    }
    
    
    public static int size(Node root){
        if(root==null) return 0;
        return 1+ size(root.left) + size(root.right);
    }
    
    
    public static boolean check(Node root){
        if(root==null) return true;
        int leftVal= (root.left != null) ? root.left.data : Integer.MIN_VALUE;
        int rightVal= (root.right != null) ? root.right.data : Integer.MIN_VALUE;
        if(root.data <= leftVal || root.data <= rightVal) return false;
        return check(root.left) && check(root.right);
    }
    
    public static boolean isCBT(Node root, int  idx){
        if(root==null) return true;
        if(idx>s) return false;    
        return isCBT(root.left, 2*idx) && isCBT(root.right, 2 * idx +1);
    }

}
