package String_algo;

public class manacharsAlgo {
//    static String longestPalindrome(String str){
//        int strlen=2*str.length()+3;
//        char ch[]=new char[strlen];
//        ch[0]='@';
//        ch[strlen-1]='*';
//        int t=1;
//        for(char c:str.toCharArray()){
//            ch[t++]='#';
//            ch[t++]=c;
//        }
//        ch[t]='#';
//        int start=0;
//        int p[]=new int[strlen];
//        int maxlen=0;
//        for(int i=1;i<strlen-1;i++){
//            while (ch[i+p[i]+1]==ch[i-p[i]-1]){
//                p[i]++;
//            }
//            if(p[i]>maxlen){
//                start=(i-p[i]-1)/2;
//                maxlen=p[i];
//            }
//        }
//        String s=new String();
//        char chStr[]=str.toCharArray();
//        for(int i=start;i<start+maxlen;i++){
//            s+=chStr[i];
//        }
//        return s;
//    }
    static  String longestPalindrome(String str){
        int strlen=2*str.length()+3;
        char ch[]=new char[strlen];
        ch[0]='*';
        ch[strlen-1]='%';
        int t=1;
        for(Character c:str.toCharArray()){
            ch[t++]='#';
            ch[t++]=c;
        }
        ch[t]='#';
        int maxLen=0;
        int start=0;
        int p[]=new int[strlen];
        for(int i=1;i<strlen-1;i++){
            while(ch[i+p[i]+1]==ch[i-p[i]-1]){
                p[i]++;
            }
            if(p[i]>maxLen){
                start=(i-p[i]-1)/2;
                maxLen=p[i];
            }
        }
        String s="";
        char newCh[]=str.toCharArray();
        for(int i=start;i<maxLen+start;i++){
            s+=newCh[i];
        }
        return s;
    }
    public static void main(String[] args) {
        String str="AZZA";
        System.out.println(longestPalindrome(str));
    }
}
