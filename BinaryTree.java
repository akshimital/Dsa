package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
   static private class Node{
       int data;
       Node left,right;
       Node(int data){
           this.data=data;
           this.left=null;
           this.right=null;
       }
   }

   public static Node build(int arr[],int n,int i){
       if(i<n){
           Node temp=new Node(arr[i]);
           temp.left=build(arr,n,2*i+1);
           temp.right=build(arr,n,2*i+2);
           return temp;
       }
       return null;
   }

   public static void inorder(Node root){
       if(root==null){
           return;
       }
       inorder(root.left);
       System.out.print(root.data+" ");
       inorder(root.right);
   }

   public static void postorder(Node root){
       if(root==null){
           return;
       }
       postorder(root.left);
       postorder(root.right);
       System.out.print(root.data+" ");
   }

   public static void preorder(Node root){
       if(root==null){
           return;
       }
       System.out.print(root.data+" ");
       preorder(root.left);
       preorder(root.right);
   }

   public static void levelorder(Node root){
       if(root==null){
           return;
       }
       Queue<Node>q=new LinkedList<>();
       q.add(root);
       q.add(null);
       while (!q.isEmpty()){
            Node temp=q.poll();
            if(temp==null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
       }
   }
    static int diameter1=0;
   public static int height(Node root){
       if(root==null){
           return 0;
       }
       int leftAns=height(root.left);
       int rightAns=height(root.right);
       diameter1=Math.max(diameter1,leftAns+rightAns);
       int ans=Math.max(leftAns,rightAns)+1;
       return ans;
   }

   static int diameter(Node root){
         height(root);
         return diameter1;
   }

   public static int checkHeight(Node root){
       if(root==null){
           return 0;
       }
       int leftAns=checkHeight(root.left);
       if(leftAns==-1)return -1;

       int rightAns=checkHeight(root.right);
       if(rightAns==-1)return -1;

       if(Math.abs(leftAns-rightAns)>1){
           return -1;
       }
       return 1+Math.max(leftAns,rightAns);
   }
   public static boolean balance(Node root){
       return checkHeight(root)!=-1;
   }
   static int maxlevel=0;
   public static void rightView(Node root,int level){
       if(root==null){
           return;
       }
       if(maxlevel<level){
           System.out.print(root.data+" ");
           maxlevel=level;
       }
       rightView(root.right,level+1);
       rightView(root.left,level+1);
   }

   public static List<List<Integer>> zigzag(Node root){
       List<List<Integer>>ls=new ArrayList<>();
       if(root==null){
           return ls;
       }
       Queue<Node>q=new LinkedList<>();
       q.add(root);
       boolean leftToRight=true;
       while(!q.isEmpty()){
           int s=q.size();
           List<Integer>ans=new ArrayList<>(s);
           for(int i=0;i<s;i++){
               Node temp=q.poll();
               if(leftToRight==true){
                   ans.add(temp.data);
               }else{
                   ans.add(0,temp.data);
               }
               if(temp.left!=null)q.add(temp.left);
               if(temp.right!=null)q.add(temp.right);
           }
           ls.add(ans);
           leftToRight=!leftToRight;
       }
       return ls;
   }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int n=arr.length;
        Node root=null;
        root=build(arr,n,0);
//        inorder(root);
//        System.out.println();
//        preorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();
//        levelorder(root);
//        System.out.println();
//        System.out.println(height(root));
//        System.out.println(diameter(root));
//        System.out.println(balance(root));
//        int level=1;
//        rightView(root,level);
        List<List<Integer>>ans=zigzag(root);
        System.out.println(ans);
        }
}
