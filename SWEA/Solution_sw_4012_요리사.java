import java.util.Scanner;

public class Solution_sw_4012_요리사 {
	static int T;
	static int N;
	static int [][] map;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			combi(0,0,new boolean[N]);
			
			System.out.println("#"+t+" "+min);
		}
		
	}
	private static void combi(int start, int cnt, boolean[] v) {
		if(cnt == N/2) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < N; i++) {
				if(v[i]) {
					for (int j = 0; j < N; j++) {
						if(v[j]) a += map[i][j];
					}
					
				}else {
					for (int j = 0; j < N; j++) {
						if(!v[j]) b += map[i][j];
					}
				}
			}
			min = Math.min(Math.abs(a-b), min);
			return;
		}
		for (int i = start; i < N; i++) {
			v[i] = true;
			combi(i+1, cnt+1, v);
			v[i] = false;
		}
	}
}
