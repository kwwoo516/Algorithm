
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1600_말이되고픈원숭이_골드4 {
	static class Loc{
		int r;
		int c;
		int cnt;
		int k;
		
		public Loc(int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	static int K, W, H;
	static int[][] map;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int[] hdr = {-2,-1,1,2,2,1,-1,-2};
	static int[] hdc = {1,2,2,1,-1,-2,-2,-1};
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Loc> q = new LinkedList<>();
		boolean[][][] visit = new boolean[K+1][H][W]; // 점프 횟수에 따른 접근 여부 확인
		q.offer(new Loc(0,0,0,K));
		visit[K][0][0] = true;
		
		while(!q.isEmpty()) {
			Loc curr = q.poll();
			if(curr.r == H-1 && curr.c == W-1) {
				result = curr.cnt;
				return;
			}
			
			// 경우 1. 그냥 가기
			for (int d = 0; d < 4; d++) {
				int nr = curr.r+dr[d];
				int nc = curr.c+dc[d];
				
				// 범위검사, 장애물검사, 방문검사
				if(!check(nr,nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(visit[curr.k][nr][nc]) continue;
				q.offer(new Loc(nr,nc,curr.cnt+1, curr.k));
				visit[curr.k][nr][nc] = true;
			}
			// 경우 2. 말처럼 가기
			if(curr.k > 0) {
				for (int d = 0; d < 8; d++) {
					int nr = curr.r+hdr[d];
					int nc = curr.c+hdc[d];
					
					// 범위검사, 장애물검사, 방문검사
					if(!check(nr,nc)) continue;
					if(map[nr][nc] == 1) continue;
					if(visit[curr.k-1][nr][nc]) continue;
					q.offer(new Loc(nr,nc,curr.cnt+1, curr.k-1));
					visit[curr.k-1][nr][nc] = true;
				}
			}
		}
		
		result = -1;
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
