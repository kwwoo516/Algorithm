import java.util.*;

class Solution {
    static boolean[] visit;
    static boolean check;
    static String[] answer;
    static class Comp implements Comparator<String[]>{
        @Override
        public int compare(String[] a, String[] b){
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        }
    }
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        
        Arrays.sort(tickets, new Comp());
        
        check = false;
        dfs(0, tickets, "ICN", "ICN");
        
        return answer;
    }
    
    public void dfs(int cnt, String[][] tickets, String start, String list){
        if(cnt == tickets.length){
            if(!check){
                check = true;
                answer = list.split(" ");
            }
            return;
        }    
        for(int i = 0; i < tickets.length; i++){
            if(visit[i]) continue;
            if(tickets[i][0].equals(start)){
                visit[i] = true;    
                dfs(cnt+1, tickets, tickets[i][1], list+" "+tickets[i][1]);
                visit[i] = false;
            }            
        }
    }
}