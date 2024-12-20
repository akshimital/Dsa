package DP;

import java.util.Scanner;

public class houseRobber1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        if(n==0) System.out.println("0");
        if(n==1) {System.out.println(arr[0]);
        return;}
        int dp[]=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int incl=dp[i-2]+arr[i];
            int excl=dp[i-1];
            dp[i]=Math.max(incl,excl);
        }
        System.out.println(dp[n-1]);
    }
}
