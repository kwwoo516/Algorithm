import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//완
public class Solution_D4_1865_동철이의일분배 {
	static int T;
	static int N;
	static int[][] map;
	static double max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			perm(0,new int[N], new boolean[N], 1);
			
			System.out.print("#"+t+" ");
			System.out.printf("%.6f\n",max);
		}
		
	}

	private static void perm(int cnt, int[] nums, boolean[] v, double val) {
		if(cnt == N) {
			val *= 100;
			if(max < val) {
				max = val;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			nums[cnt] = i;
			v[i] = true;
			if(val*(map[cnt][i]/100.0)*100 > max) {
				perm(cnt+1,nums, v, val*(map[cnt][i]/100.0));
			}
			v[i] = false;
		}
	}
}
