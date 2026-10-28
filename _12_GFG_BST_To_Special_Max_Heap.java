import java.util.*;
import org.w3c.dom.Node;
public class _12_GFG_BST_To_Special_Max_Heap {

     static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

    static int idx;

    public static void main(String RCB []){
    //    Input: root[] = [4, 2, 6, 1, 3, 5, 7]
         Node root=new Node(4);
         Node a=new Node(2);
         Node b=new Node(6);
         root.left=a;
         root.right=b;

         Node c=new Node(1);
         Node d=new Node(3);
         a.left=c;
         a.right=d;

         Node e=new Node(5);
         Node f=new Node(7);
         b.left=e;
         b.right=f;

         convertToMaxHeap(root);
         System.out.println(root);
    }


     public static void convertToMaxHeap(Node root) {
      
     ArrayList<Integer> arr=new ArrayList<>();
     idx=0;
     
     inOrder(root,arr);
     postOrder(root,arr);
     
    }
    
    static void inOrder(Node root, ArrayList<Integer> arr ){
        if(root==null) return ;
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
        
    }
    
    
    static void postOrder(Node root, ArrayList<Integer> arr){
        if(root==null) return;
        postOrder(root.left,arr);
        postOrder(root.right,arr);
        root.data= arr.get(idx++);
    }

}
