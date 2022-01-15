

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_10026_적록색약_골드5 {
	static class Loc{
		int r;
		int c;
		
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int count;
	static int bdcount;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 1. 일반
		visit = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					bfs(i,j, map[i][j], visit);
					count++;
				}
			}
		}
		
		// 적록색약 변환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		// 2. 적록색약
		bdcount = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					bfs(i,j, map[i][j], visit);
					bdcount++;
				}
			}
		}
		
		
		System.out.println(count+" "+bdcount);
		
	}

	private static void bfs(int r, int c, int color, boolean[][] visit) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(r,c));
		visit[r][c] = true;
		boolean alone = true;
		while(!q.isEmpty()) {
			Loc temp = q.poll();
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				
				if(!check(nr,nc)) continue;
				if(visit[nr][nc]) continue;
				if(map[nr][nc] == color) {
					alone = false;
					q.add(new Loc(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
