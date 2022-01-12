import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기2 {
	
	static int T;
	static int N;
	static int[][] map;
	static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j]-'0';
				}
			}
			sum = 0;
			int a = N/2;
			int bound = a;
			for (int i = 0; i < N; i++) {
				for (int j = bound; j < N-bound; j++) {
					sum += map[i][j];
				}
				a--;
				bound = Math.abs(a);
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}
}
