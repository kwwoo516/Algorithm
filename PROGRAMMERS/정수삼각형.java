class Solution {
    public int solution(int[][] triangle) {
        if(triangle.length <= 1){
            return triangle[0][0];
        }
        
        for(int i = 1; i < triangle.length; i++){
            int len = triangle[i].length;
            
            for(int j = 0; j < len; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == len-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                
            }
        }
        
        int max = 0;
        for(int i = 0; i < triangle[triangle.length-1].length; i++){
            max = Math.max(max, triangle[triangle.length-1][i]);
        }
        
        return max;
    }
}