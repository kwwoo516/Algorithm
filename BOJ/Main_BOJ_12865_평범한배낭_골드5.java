import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_12865_평범한배낭_골드5 {
//dp
	static int N, K;
	static int[][] stock;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stock = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			stock[i][0] = Integer.parseInt(st.nextToken());
			stock[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if(w >= stock[i][0]) { // 물건을 넣을 수 있다면
					// 이전 물건까지의 최대값 vs 현재 물건 넣고 최대값
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-stock[i][0]] + stock[i][1]);
				}else { // 못넣으면
					//이전 물건까지만 고려했을 때 같은 무게의 최대값
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
