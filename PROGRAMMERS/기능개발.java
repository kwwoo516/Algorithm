import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] restday = new int[speeds.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < speeds.length; i++){
            if((100 - progresses[i])%speeds[i] == 0){
                restday[i] = (100 - progresses[i])/speeds[i];   
            }else{
                restday[i] = (100 - progresses[i])/speeds[i] + 1;
            }
        }
        
        int headidx = 0;
        int cnt = 1;
        for(int i = 1; i < speeds.length; i++){
            if(restday[headidx] >= restday[i]){
                cnt++;
            }else{
                list.add(cnt);
                headidx = i;
                cnt = 1;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}