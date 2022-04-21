
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//시간 176ms
//메모리 74436kb
public class Main_BOJ_5582_공통부분문자열_골드5 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int len1 = str1.length;
		int len2 = str2.length;
		
		int[][] dp = new int[len1+1][len2+1];
		int max = 0;
		
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if(str1[i-1] == str2[j-1]) {					
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		System.out.println(max);
	}
}
