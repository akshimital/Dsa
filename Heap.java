package Heap;

public class Heap {
    void sort(int arr[],int n){
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr,i,0);
        }
    }

    void heapify(int arr[],int n,int i){
        int large=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n && arr[left]>arr[large]){
            large=left;
        }
        if(right<n && arr[right]>arr[large]){
            large=right;
        }

        if(large!=i){
            int temp=arr[i];
            arr[i]=arr[large];
            arr[large]=temp;
            heapify(arr,n,large);
        }

    }

    public static void main(String[] args) {
        int arr[]={12,11,13,5,6,7};
        int n=arr.length;
        Heap h=new Heap();
        h.sort(arr,n);
        for(int i:arr)
            System.out.println(i);
        //WAP to display the product  of min adn amx element from array using heap sort
//        System.out.println(arr[0]*arr[n-1]);
    }
}
