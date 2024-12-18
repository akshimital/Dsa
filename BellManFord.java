package Graph;

import java.util.*;

public class BellManFord {
    static int[] solve(int v,int edges[][],int src){
        int dis[]=new int[v];
        Arrays.fill(dis,(int)1e8);
        dis[src]=0;
        for(int i=0;i<v;i++){
            for(int a[]:edges){
                int v1=a[0];
                int v2=a[1];
                int v3=a[2];
                if(dis[v1]!=(int)1e8 && dis[v2]>dis[v1]+v3){
                    if(i==v-1){
                        return new int[0];
                    }
                    dis[v2]=dis[v1]+v3;
                }
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int edges[][]=new int[e][3];
        for(int i=0;i<e;i++){
            for(int j=0;j<3;j++){
                edges[i][j]=sc.nextInt();
            }
        }
        int src=sc.nextInt();
        int res[]=solve(v,edges,src);
        if (res.length > 0) { // Only print if no negative weight cycle
            for (int i = 0; i < v; i++) {
                System.out.println(i + " -> " + (res[i] == (int) 1e8 ? "Infinity" : res[i]));
            }
        }
    }
}
