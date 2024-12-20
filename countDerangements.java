package DP;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class countDerangements {
    static int mod=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int dp[]=new int[n+1];
        Arrays.fill(dp,0);
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            int start=dp[i-1]%mod;
            int end=dp[i-2]%mod;
            int sum=(start+end)%mod;
            dp[i]=((i-1)*sum)%mod;
        }
        System.out.println(dp[n]);
    }
}
