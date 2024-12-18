import java.util.Scanner;

public class StringsPr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Check if string is palindrome or not
//        String str=sc.nextLine();
//        int n=str.length();
//        boolean flag=true;
//        int left=0;
//        int right=n-1;
//        while(left<=right){
//            if(str.charAt(left)!=str.charAt(right)){
//                flag=false;
//                break;
//            }
//            else{
//                left++;
//                right--;
//            }
//        }
//        if(flag){
//            System.out.println("Yess");
//        }else{
//            System.out.println("No");
//        }

//        //reverse a string
//        String str=sc.nextLine();
//        int n=str.length();
//        int left=0;
//        int right=n-1;
//        char[] ar=str.toCharArray();
//        while(left<=right){
//            char temp=ar[left];
//            ar[left]=ar[right];
//            ar[right]=temp;
//            left++;
//            right--;
//        }
//        String ans=new String(ar);
//        System.out.println(ans);

        //change the character in string with another inputed character
        String str=sc.nextLine();
        char ch = sc.next().charAt(0);
        char ar[]=str.toCharArray();
        for(int i=0;i<ar.length;i++){
            if(ar[i]==ch){

            }
        }

    }
}
