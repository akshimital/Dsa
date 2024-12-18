package DP;

public class MAxCostToReachEndOfMatrix {
    public static void main(String[] args) {
        int ar[][]={{1,2,3},{4,5,6},{7,8,9}};
        int n=ar.length;
        int m=ar[0].length;
        System.out.println(maxCost(ar,n,m));
    }
    static int maxCost(int ar[][],int n,int m){
        int dp[][]=new int[n][m];
        dp[0][0]=ar[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+ar[i][0];
        }
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+ar[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=ar[i][j]+Math.max(dp[i][j-1],Math.max(dp[i-1][j],dp[i-1][j-1])); //check left,upper and diagonal
            }
        }
        return dp[n-1][m-1];
    }
}
