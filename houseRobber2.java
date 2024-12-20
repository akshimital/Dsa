package DP;

import java.util.Scanner;

public class houseRobber2 {
    static int houseRobbery(int arr[],int n){
        if(n==0)return 0;
        if(n==1)return arr[0];
        int dp[]=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int incl=dp[i-2]+arr[i];
            int excl=dp[i-1];
            dp[i]=Math.max(incl,excl);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int arr1[]=new int[n-1];
        int arr2[]=new int[n-1];
        int k=0;
        int m=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                arr1[k++]=arr[i];
            }
            if(i!=n-1){
                arr2[m++]=arr[i];
            }
        }
        int ans1=houseRobbery(arr1,n-1);
        int ans2=houseRobbery(arr2,n-1);
        System.out.println(Math.max(ans2,ans1));
    }
}
