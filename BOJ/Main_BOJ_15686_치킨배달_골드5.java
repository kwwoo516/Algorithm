import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15686_치킨배달_골드5 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] distance;
	static int home;
	static int[][] home_loc;
	static int chicken;
	static int[][] chicken_loc;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home++;
				else if(map[i][j] == 2) chicken++;
			}
		}
		
		home_loc = new int[home][2];
		chicken_loc = new int[chicken][2];
		int hcnt = 0;
		int ccnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					home_loc[hcnt][0] = i;
					home_loc[hcnt++][1] = j;
				}else if(map[i][j] == 2) {
					chicken_loc[ccnt][0] = i;
					chicken_loc[ccnt++][1] = j;
				}
			}
		}
		
		distance = new int[home][chicken];
		for (int h = 0; h < home; h++) {
			for (int c = 0; c < chicken; c++) {
				int dis = Math.abs(home_loc[h][0] - chicken_loc[c][0]) + 
						Math.abs(home_loc[h][1] - chicken_loc[c][1]);
				distance[h][c] = dis;
			}
		}
		
		min = Integer.MAX_VALUE;
		combi(0,0, new int[M]);
		System.out.println(min);
		
	}

	private static void combi(int start, int cnt, int[] sel) {
		if(cnt == M) {
			int totdis = 0;
			
			for (int j = 0; j < home; j++) {
				int cdis = Integer.MAX_VALUE;
				for (int i : sel) {
					cdis = Math.min(cdis, distance[j][i]);
				}
				totdis += cdis;
			}
			
			min = Math.min(min, totdis);
			return;
		}
		
		for (int i = start; i < chicken; i++) {
			sel[cnt] = i; 
			combi(i+1, cnt+1, sel);
		}
	}
}
