import java.util.*;

class Solution {
    static class Truck{
        int weight;
        int loc;
        
        public Truck(int weight, int loc){
            this.weight = weight;
            this.loc = loc;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new LinkedList<>();
        
        int posWeight = weight;
        int idx = 0;
        int count = 0;
        while(idx < truck_weights.length){
            if(!q.isEmpty()){
                for(Truck t : q){
                    t.loc++;
                } 
                if(bridge_length < q.peek().loc){
                    posWeight += q.peek().weight;
                    q.poll();
                }
            }
            if(posWeight >= truck_weights[idx]){
                q.offer(new Truck(truck_weights[idx], 1));
                posWeight -= truck_weights[idx];
                idx++;
            }
            count++;
        }
        count += bridge_length;
        
        return count;
    }
}