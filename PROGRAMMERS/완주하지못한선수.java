import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String result = participant[participant.length-1];
        
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                result = participant[i];                
                break;
            }
        }
        
        return result;
    }
}