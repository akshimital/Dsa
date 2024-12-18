package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgo {
    static class Graph{
        int v;
        ArrayList<ArrayList<Pair>>adj;
        Graph(int v){
            this.v=v;
            adj=new ArrayList<>();
            for(int i=0;i<v;i++){
                adj.add(new ArrayList<Pair>());
            }
        }
        void addEdge(int src,int des,int wt){
            adj.get(src).add(new Pair(des,wt));
            adj.get(des).add(new Pair(src,wt));
        }
        static class Pair{
            int node;
            int wt;
            Pair(int node,int wt){
                this.node=node;
                this.wt=wt;
            }
        }
        int MinSpanningTree(){
            PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(o->o.wt));
            int visited[]=new int[v];
            pq.add(new Pair(0,0));

            int minCost=0;
            while (!pq.isEmpty()){
                Pair curr=pq.poll();
                int ver=curr.node;
                int wt=curr.wt;
                if(visited[ver]==0){
                    minCost+=wt;
                    visited[ver]=1;
                    for(Pair p:adj.get(ver)){
                        if(visited[p.node]==0){
                            pq.add(new Pair(p.node, p.wt));
                        }
                    }
                }
            }
            return minCost;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e= sc.nextInt();
        Graph g=new Graph(v);
        for(int i=0;i<e;i++){
            int src=sc.nextInt();
            int des=sc.nextInt();
            int wt=sc.nextInt();
            g.addEdge(src,des,wt);
        }

        System.out.println(g.MinSpanningTree());
    }
}
