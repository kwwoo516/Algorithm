import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 우선순위 큐 한거
public class Main_BOJ_4485_녹색옷입은애가젤다지_골드4 {
	static int N;
	static int[][] map;
	static int[][] mincost;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			mincost = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] =  Integer.parseInt(st.nextToken());
					mincost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//초기화
			mincost[0][0] = map[0][0];
			bfs(0,0);
			
			sb.append("Problem "+t+":"+" "+mincost[N-1][N-1]+"\n");
			t++;
		}
		
		System.out.println(sb.toString());
	}
	
	private static void bfs(int r, int c) {
		PriorityQueue<Cell> q = new PriorityQueue<>();
		q.offer(new Cell(r,c,map[r][c]));
		
		while(!q.isEmpty()) {
			Cell temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				if(!check(nr,nc)) continue;
				if(mincost[nr][nc] > mincost[temp.r][temp.c]+map[nr][nc]) {
					mincost[nr][nc] = mincost[temp.r][temp.c]+map[nr][nc];
					q.offer(new Cell(nr,nc,mincost[nr][nc]));
				}
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
