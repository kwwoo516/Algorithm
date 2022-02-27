import java.util.*;

class Solution {
    public class C{
        String wear;
        int cnt;
        
        public C(String wear, int cnt){
            this.wear = wear;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[][] clothes) {
        int answer = 1;
        ArrayList<C> list = new ArrayList<>();
        
        for(String[] cloth : clothes){
            boolean flag = false;
            
            for(C c : list){
                if(c.wear.equals(cloth[1])){
                    c.cnt += 1;
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                list.add(new C(cloth[1],1));
            }
        }
        
        for(C c : list){
            answer *= c.cnt+1;
        }
        
        answer -= 1;
        
        return answer;
    }
}