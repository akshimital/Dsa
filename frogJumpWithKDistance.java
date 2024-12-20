package DP;

import java.util.Map;
import java.util.Scanner;

public class frogJumpWithKDistance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int height[]=new int[n];
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            height[i]=sc.nextInt();
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int j = Math.max(0,i-k);j<i;j++){
                dp[i]=Math.min(dp[i],dp[j]+Math.abs(height[i]-height[j]));
            }
        }
        System.out.println(dp[n-1]);
    }
}
