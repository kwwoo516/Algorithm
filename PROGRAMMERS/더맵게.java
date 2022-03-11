import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int cnt = 0;
        for(int i = 0; i < scoville.length; i++){
            q.offer(scoville[i]);
        }
        while(!check(q,K)){
            if(q.size() < 2){
                return -1;
            }
            int a = q.poll();
            int b = q.poll();
            int mix = a + (b * 2);
            q.offer(mix);
            cnt++;
        }
        
        return cnt;
    }
    public boolean check(PriorityQueue<Integer> q, int K){
        boolean flag = true;
        for(Integer i : q){
            if(i < K){
                flag = false;
                break;
            }
        }
        return flag;
    }
}