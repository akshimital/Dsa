package DP;

public class RodCutting {
    public static void main(String[] args) {
        int n=8;
        int ar[]={3,5,8,9,10,17,17,20};
        //tc-O(n)
        System.out.println(rodCutting(ar,n-1,n));
    }
    static int rodCutting(int ar[],int index,int n){
        if(index==0){
            return n*ar[0];
        }
        int notCut=rodCutting(ar,index-1,n);
        int cut=Integer.MIN_VALUE;
        int rodLen=index+1;
        if(rodLen<=n){
            cut=ar[index]+rodCutting(ar,index,n-rodLen);
        }
        return Math.max(cut,notCut);
    }
}
