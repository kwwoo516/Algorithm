
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7569_토마토_골드5 {
	static class Loc{
		int h;
		int r;
		int c;
		
		public Loc(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, H;
	static int[][][] map;
	static boolean[][][] visit;
	static int[] dh = {0,0,0,0,1,-1};
	static int[] dr = {0,1,0,-1,0,0};
	static int[] dc = {1,0,-1,0,0,0};
	static Queue<Loc> q;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		visit = new boolean[H][N][M];
		q = new LinkedList<>();
		
		int emptycnt = 0;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if(map[h][n][m] == 1) {
						q.offer(new Loc(h,n,m));
						visit[h][n][m] = true;
					}else if(map[h][n][m] == -1) {
						emptycnt++;
					}
				}
			}
		}
		
		if(q.size() == H*M*N - emptycnt) {
			System.out.println(0);
			System.exit(0);
		}
		
		count = 0;
		bfs();
		
		boolean flag = false;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(map[h][n][m] == 0) {
						flag = true;
						break;
					}
				}
			}
		}
		
		System.out.println(flag ? -1 : count);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int len = q.size();
			int cnt = 0;
			while(cnt < len) {
				Loc temp = q.poll();
				for (int d = 0; d < 6; d++) {
					int nh = temp.h + dh[d];
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];
					
					if(!check(nh,nr,nc) || visit[nh][nr][nc]) continue;
					if(map[nh][nr][nc] == 0) {
						visit[temp.h][temp.r][temp.c] = true;
						q.offer(new Loc(nh,nr,nc));
						map[nh][nr][nc] = 1;
					}
				}
				cnt++;
			}
			if(q.size() > 0) {
				count++;
			}
		}
	}
	
	public static boolean check(int h, int r, int c) {
		return h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M;
	}
}
