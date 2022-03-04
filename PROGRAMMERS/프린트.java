import java.util.*;

class Solution {
    static class Print{
        int p;
        int loc;
        
        public Print(int p, int loc){
            this.p = p;
            this.loc = loc;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Print> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new Print(priorities[i], i));
        }
        
        int answer = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Print paper = q.poll();
            boolean check = false;
            for(Print temp : q){
                if(paper.p < temp.p){
                    q.add(paper);
                    check = true;
                    break;
                }
            }
            if(!check){
                cnt++;
                if(paper.loc == location){
                    break;
                }
            }
        }
        
        return cnt;
    }
}