import java.util.Scanner;
//DP
public class Solution_5215_D3_햄버거다이어트_DP {
	static int T, N, L;
	static int[][] ingre;
	static int[][] DP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			ingre = new int[N+1][2];
			DP = new int[N+1][L+1];
			for (int i = 1; i <= N; i++) {
				ingre[i][0] = sc.nextInt();
				ingre[i][1] = sc.nextInt();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= L; w++) {
					if(w >= ingre[i][1]) {
						DP[i][w] = Math.max(DP[i-1][w], DP[i-1][w - ingre[i][1]] + ingre[i][0]);
					}else {
						DP[i][w] = DP[i-1][w];
					}
				}
			}
			
			System.out.println("#"+t+" "+DP[N][L]);
		}
	}
}
