package DP;

public class SubsetSum {
    public static void main(String[] args) {
        int n=5;
        int ar[]={1,2,3,4,5};
        int sum=5;
        //tc-n*sum;
        System.out.println(subsetSum(ar,n,sum));
    }
    static int subsetSum(int ar[],int n,int sum){
        int count=0;
        boolean dp[]=new boolean[sum+1];
        dp[0]=true;
        for(int i=0;i<n;i++){

            for(int j=sum;j>=ar[i];j--){
                dp[j]=dp[j] || dp[j-ar[i]];

            }
            if(dp[sum]==true){
                count++;
                dp[sum]=false;
            }
        }

        return count;
    }
}
