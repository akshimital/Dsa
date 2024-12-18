package Graph;

import java.util.*;

public class Dijkstra {
    static class Graph{
        int v;
        ArrayList<ArrayList<Pair>>adj;
        Graph(int v){
            this.v=v;
            adj=new ArrayList<>();
            for(int i=0;i<v;i++){
                adj.add(new ArrayList<>());
            }
        }

    void addEdge(int src,int des,int w){
        adj.get(src).add(new Pair(des,w));
        adj.get(des).add(new Pair(src,w));
    }
    static class Pair{
        int first;
        int second;
        Pair(int des,int w){
            first=des;
            second=w;
        }
    }
    void shortestPath(int src){
            int dist[]=new int[v];
            Arrays.fill(dist,Integer.MAX_VALUE);
            PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(o->o.first));
            pq.add(new Pair(src,0));
            dist[src]=0;
            while(!pq.isEmpty()){
                int node=pq.poll().first;
                for(Pair a:adj.get(node)){
                    if(dist[a.first]>dist[node]+a.second){
                        dist[a.first]=dist[node]+a.second;
                        pq.add(new Pair(a.first,dist[a.first]));
                    }
                }
            }
            for (int i=1;i<v;i++){
               if(dist[i]!=Integer.MAX_VALUE){
                   System.out.println(i+"->"+dist[i]);
               }else{
                   System.out.println(i+"->"+"Infinity");
               }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e= sc.nextInt();
        Graph g=new Graph(v);
        for(int i=0;i<e;i++){
            int src=sc.nextInt();
            int des= sc.nextInt();
            int w=sc.nextInt();
            g.addEdge(src,des,w);
        }
        g.shortestPath(0);
    }
}
