import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_sw_1953_탈주범검거 {
	static int T, N, M, L;
	static int[][] map;
	
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	static int[][] dd = {{0},{0,1,2,3},{0,-1,2,-1},{-1,1,-1,3},{-1,1,2,-1},{0,1,-1,-1},{0,-1,-1,3},{-1,-1,2,3}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = 0, c = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+bfs(r,c));
		}
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {r,c,1});
		visited[r][c] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int time = curr[2];
			if(time == L) {
				return cnt;
			}
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(!(nr >= 0 && nr < N && nc >= 0 && nc < M)) continue;
				if(visited[nr][nc] || map[nr][nc] == 0) continue;
				if(dd[map[curr[0]][curr[1]]][d] == -1 || dd[map[nr][nc]][(d+2)%4] == -1) continue;
				q.offer(new int[] {nr,nc,time+1});
				visited[nr][nc] = true;
				cnt++;
			}
		}
		return cnt;
	}

}
