package GreedyAlgo;

import java.util.*;

public class KnapSack {

    public static void main(String[] args) {
        int profit[]={120,100,60};
        int weight[]={17,13,8};
        int sack=20;
        double res=  FractionalKnapsack(profit,weight,sack);
        System.out.println(res);
    }
    static double FractionalKnapsack(int profit[],int weight[],int sack){
        double res=0;
        TreeMap<Double, List<Integer>>hm=new TreeMap<Double,List<Integer>>(Collections.reverseOrder());
        int n=profit.length;
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<Integer>();
            list.add(profit[i]);
            list.add(weight[i]);
            hm.put((double)profit[i]/weight[i],list);
        }
        for(Map.Entry<Double,List<Integer>>x:hm.entrySet()){
            if(x.getValue().get(1)<=sack){
                res+=(x.getValue().get(0));
                sack-=(x.getValue().get(1));
            }
            else{
                res+= (sack* x.getKey());
                break;
            }
        }
        return res;
    }
}
