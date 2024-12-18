package BinaryTree;

public class BST {
    private static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    public static Node build(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(root.data>data){
            root.left=build(root.left,data);
        }
        if(root.data<data){
            root.right=build(root.right,data);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        return search(root.right,key);
    }

    public static int floor(Node root,int key){
        if(root==null){
            return -1;
        }
        int floor=-1;
        while(root!=null){
            if(root.data==key){
                return key;
            }else if(root.data>key){
                root=root.left;
            }else{
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }

    public static int ceil(Node root,int key){
        if(root==null){
            return -1;
        }
        int ceil=-1;
        while (root!=null){
            if(root.data==key){
                return key;
            }else if(root.data<key){
                root=root.right;
            }else{
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;
    }

    public static int lca(Node root,int p,int q){
        if(root==null){
            return 0;
        }
        if(root.data<p && root.data<q){
            return lca(root.right,p,q);
        }
        if(root.data>p && root.data>q){
            return lca(root.left,p,q);
        }
        return root.data;
    }

    public static Node delete(Node root,int key){
        if(root==null){
            return null;
        }
        if(root.data<key){
            root.right=delete(root.right,key);
        }
        else if(root.data>key){
            root.left=delete(root.left,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node temp=findMin(root.right);
            root.data=temp.data;
            root.right=delete(root.right,temp.data);
        }
        return root;
    }

    public static Node findMin(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[]={4 ,2 ,7 ,1 ,3 ,5};
        int n=arr.length;
        Node root=null;
        for(int i=0;i<n;i++){
            root=build(root,arr[i]);
        }
//        inorder(root);
//        System.out.println();
//        System.out.println(search(root,9));
//        int key=6;
//        System.out.println(floor(root,key));
//        System.out.println(ceil(root,key));
//        int p=1;
//        int q=3;
//        int temp=lca(root,p,q);
//        System.out.println(temp);
//        int key=7;
//        root=delete(root,key);
//        inorder(root);

    }

}
