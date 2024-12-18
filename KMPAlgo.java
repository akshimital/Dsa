package String_algo;

public class KMPAlgo {
    static void KMPSearch(String str,String pat){
        int l1=str.length();
        int l2=pat.length();
        int lps[]=new int[l2];
        lps[0]=0;
        computelps(pat,lps,l2);
        int i=0;
        int j=0;
        while(i<l1){
            if(str.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==l2){
                System.out.println(i-j);
                j=lps[j-1];
            }
            else if(i<l1 && str.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }
    static void computelps(String pat,int lps[],int len){
        int i=1;
        int j=0;
        while(i<len){
            if(pat.charAt(i)==pat.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    lps[i]=j;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String str="AABBABABD";
        String pat="ABABD";
        KMPSearch(str,pat);
    }
}
