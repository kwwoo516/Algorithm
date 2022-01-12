

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2615_오목_실버2 {
	static int N = 19;
	static int[][] map;
	static boolean[][][] visitD;
	static int[] dr = {0,1,-1,1};
	static int[] dc = {1,0,1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		visitD = new boolean[N][N][4];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[j][i] != 0) {
					//오목이 있다면
					for (int d = 0; d < 4; d++) {
						int nr = j+dr[d];
						int nc = i+dc[d];
						if(!check(nr, nc)) continue;
						if(map[nr][nc] != map[j][i]) continue;
						//visit check
						if(visitD[j][i][d]) continue;
						visitD[j][i][d] = true;
						int result = cal(j,i,d);
						if(result > 0) {
							System.out.println(result);
							System.out.println((j+1)+" "+(i+1));
							return;
						}
					}
					
				}
			}
		}
		System.out.println(0);
	}

	private static int cal(int r, int c, int d) {
		int count = 1;
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(!check(nr, nc)) break;
			if(map[nr][nc] != map[r][c]) break;
			if(visitD[nr][nc][d]) {
				return 0;
			}
			visitD[nr][nc][d] = true;
			count++;
		}
		if(count == 5) {
			return map[r][c];
		}else {
			return 0;
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
