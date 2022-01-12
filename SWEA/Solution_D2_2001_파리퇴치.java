import java.util.Scanner;

public class Solution_D2_2001 {
	
	static int T;
	static int N;
	static int M;
	static int[][] fly;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			fly = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			int kill = 0;
			int max = 0;
			
			for (int ij = 0; ij <= N-M; ij++) {
				for (int ik = 0; ik <= N-M; ik++) {
					for (int j = ij; j < M+ij; j++) {
						for (int k = ik; k < M+ik; k++) {
							kill += fly[j][k];
						}
					}
					max = Math.max(max, kill);
					kill = 0;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
