import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_sw_프로세서연결하기 {
	static int T;
	static int N;
	static int[][] map;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static ArrayList<int[]> core;
	static int maxCore;
	static int minLine;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<int[]>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(inPower(i, j)) continue;
						core.add(new int[] {i,j});
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;
			conn(0, 0, 0);
			
			System.out.println("#"+t+" "+minLine);
		}
	}
	
	private static void conn(int cnt, int ccnt, int lcnt) {
		if(cnt == core.size()) {
			if(maxCore < ccnt) {
				maxCore = ccnt;
				minLine = lcnt;
			}else if(maxCore == ccnt) {
				minLine = Math.min(minLine, lcnt);
			}
			return;
		}
		int r = core.get(cnt)[0];
		int c = core.get(cnt)[1];
		
		for (int d = 0; d < 4; d++) {
			int len = 0;
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(!check(nr,nc)) break;
				if(map[nr][nc] != 0) {
					len = 0;
					break;
				}
				len++;
			}
			int fr = r;
			int fc = c;
			
			for (int i = 0; i < len; i++) {
				fr += dr[d];
				fc += dc[d];
				map[fr][fc] = 2;
			}
			
			if(len == 0) {
				conn(cnt+1, ccnt, lcnt);
			}else {
				conn(cnt+1, ccnt+1, lcnt+len);
				
				fr = r;
				fc = c;
				for (int i = 0; i < len; i++) {
					fr += dr[d];
					fc += dc[d];
					map[fr][fc] = 0;
				}
			}
			
		}
		
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static boolean inPower(int r, int c) {
		return r == 0 || r == N-1 || c == 0 || c == N-1;
	}
}
