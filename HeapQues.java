package Heap;

import java.util.Scanner;

public class HeapQues {

    static boolean minHeap(int arr[],int n){
        for(int i=0;i<=(n-2)/2;i++){
            int left=2*i+1;
            int right=2*i+2;
            if(left<n && arr[left]>arr[i]){
                return false;
            }
            if(right<n && arr[right]>arr[i]){
                return false;
            }
        }
        return true;
    }

    static boolean maxHeap(int arr[],int n){
        for(int i=0;i<=(n-2)/2;i++){
            int left=2*i+1;
            int right=2*i+2;
            if(left<n && arr[left]<arr[i]){
                return false;
            }
            if(right<n && arr[right]<arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        if(maxHeap(arr,n)){
            System.out.println("Max Heap");
        }else if(minHeap(arr,n)){
            System.out.println("Min Heap");
        }else{
        System.out.println("-1");}
    }
}
