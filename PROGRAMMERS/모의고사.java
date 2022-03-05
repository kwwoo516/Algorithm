import java.lang.*;
import java.util.*;

class Solution {
    static int[] s1 = {1,2,3,4,5};
    static int[] s2 = {2,1,2,3,2,4,2,5};
    static int[] s3 = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == s1[i%5]){
                cnt1++;
            }
            if(answers[i] == s2[i%8]){
                cnt2++;
            }
            if(answers[i] == s3[i%10]){
                cnt3++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        if(max == cnt1){
            list.add(1);
        }
        if(max == cnt2){
            list.add(2);
        }
        if(max == cnt3){
            list.add(3);
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
    
}