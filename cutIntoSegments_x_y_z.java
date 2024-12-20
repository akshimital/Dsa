package DP;

import java.util.Arrays;
import java.util.Scanner;

public class cutIntoSegments_x_y_z {
    static int cut(int n,int x,int y,int z){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i-x>=0 && dp[i-x]!=-1){
                dp[i]=Math.max(dp[i],dp[i-x]+1);
            }
            if(i-y>=0 && dp[i-y]!=-1){
                dp[i]=Math.max(dp[i],dp[i-y]+1);
            }
            if(i-z>=0 && dp[i-z]!=-1){
                dp[i]=Math.max(dp[i],dp[i-z]+1);
            }
        }
        if(dp[n]==-1){
            return 0;
        }return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        System.out.println(cut(n,x,y,z));
    }
}
