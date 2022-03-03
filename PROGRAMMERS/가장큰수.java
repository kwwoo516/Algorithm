import java.util.*;

class Solution {
    public class Comp implements Comparator<String>{
        @Override
        public int compare(String p1, String p2){
            return (p2+p1).compareTo(p1+p2);
        }
    }
    
    public String solution(int[] numbers) {
        String[] numbers2 = new String[numbers.length];
        for(int i = 0; i< numbers.length; i++){
            numbers2[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numbers2, new Comp());
        if(numbers2[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< numbers.length; i++){
            sb.append(numbers2[i]);
        }
        
        return sb.toString();
    }
}