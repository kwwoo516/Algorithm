import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_sw_1249_보급로 {
	static int T, N;
	static int[][] map;
	static int[][] minlen;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Cell implements Comparable<Cell>{
		int r;
		int c;
		int cost;
		
		public Cell(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Cell o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			minlen = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j <  N; j++) {
					map[i][j] = c[j]-'0';
					minlen[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(0,0);
			System.out.println("#"+t+" "+minlen[N-1][N-1]);
		}
	}

	private static void bfs(int r, int c) {
		PriorityQueue<Cell> q = new PriorityQueue<>();
		q.offer(new Cell(r,c,map[r][c]));
		minlen[r][c] = map[r][c];
		
		while(!q.isEmpty()) {
			Cell curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(!check(nr,nc)) continue;
				if(minlen[nr][nc] > minlen[curr.r][curr.c] + map[nr][nc]) {
					minlen[nr][nc] = minlen[curr.r][curr.c] + map[nr][nc];
					q.offer(new Cell(nr,nc,minlen[nr][nc]));
				}
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
