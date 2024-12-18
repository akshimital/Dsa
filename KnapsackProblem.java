package DP;

public class KnapsackProblem {
    public static void main(String[] args) {
        int profit[]={60,100,120};
        int weight[]={10,20,30};
        int sack=55;
        int n=profit.length;
        //recursive approach tc-O(2^n)
        System.out.println(knapsack(sack,weight,profit,n));

        //memoization approach


    }
    static int knapsack(int s,int wt[],int pr[],int n){
        if(n==0 || s==0)
            return 0;
        if(wt[n-1]>s){
            return knapsack(s,wt,pr,n-1);
        }else{
            return Math.max(knapsack(s,wt,pr,n-1),pr[n-1]+knapsack(s-wt[n-1],wt,pr,n-1));
        }
    }
}
