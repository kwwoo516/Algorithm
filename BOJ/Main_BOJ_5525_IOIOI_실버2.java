import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dp
public class Main_BOJ_5525_IOIOI_실버2 {
	static int N, M;
	static String S;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		dp = new int[M];
		int cnt = 0;
		for (int i = 1; i < M-1; i++) {
			if(S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
				dp[i+1] = dp[i-1] + 1;
				if(dp[i+1] >= N && S.charAt(i+1 - N*2) == 'I') {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
