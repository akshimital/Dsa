package DP;

import java.lang.reflect.Array;

public class LCS {
    public static void main(String[] args) {
        String s1="ABC";
        String s2="ADC";
        int l1=s1.length();
        int l2=s2.length();
        //using recursion  //tc-O(2^(n+m))
        System.out.println(lcs(s1,s2,l1,l2));
        int dp[][]=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                dp[i][j]=-1;
            }
        }
        //tc -O(n+m)
        System.out.println(lcsdp(s1,s2,l1,l2,dp));
    }
    static int lcs(String s1,String s2,int l1,int l2){
        if(l1==0 || l2==0){
            return 0;
        }
        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            return 1+lcs(s1,s2,l1-1,l2-1);
        }else{
            return Math.max(lcs(s1,s2,l1-1,l2),lcs(s1, s2, l1, l2-1));
        }
    }

    static int lcsdp(String s1,String s2,int l1,int l2,int dp[][]){
        if(l1==0 || l2==0){
            return 0;
        }
        if(dp[l1][l2]!=-1){
            return dp[l1][l2];
        }
        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            dp[l1][l2]=1+lcsdp(s1,s2,l1-1,l2-1,dp);
            return dp[l1][l2];
        }
        dp[l1][l2]=Math.max(lcsdp(s1,s2,l1-1,l2,dp),lcsdp(s1,s2,l1,l2-1,dp));
        return dp[l1][l2];
    }
}
