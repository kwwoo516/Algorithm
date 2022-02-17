class Solution {
    static int value; 
    static int Y;
    static int B;
    static int[] xy;
    public int[] solution(int brown, int yellow) {
        Y = yellow;
        B = brown;
        xy = new int[2];
        perm(0, new int[2], 1);
        return xy;
    }
    
    public void perm(int cnt, int[] nums, int tiles){
        if(cnt == 2){
            if(nums[0] < nums[1]){
                return;
            }
            if(Y == (nums[0])*(nums[1])){
                if(((nums[0]+2)*(nums[1]+2)-(nums[0]*nums[1])) == B){
                    xy[0] = nums[0]+2;
                    xy[1] = nums[1]+2; 
                }
            }
            return;
        }
        for(int i = 1; i <= Y; i++){
            if(tiles*i > Y) return;
            nums[cnt] = i;
            perm(cnt+1, nums, tiles*i);
        }
    }
}