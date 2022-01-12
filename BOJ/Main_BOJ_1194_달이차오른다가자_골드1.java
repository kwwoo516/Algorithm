import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1194_달이차오른다가자_골드1 {
//q, dfs변형체
	static class Cell{
		int r;
		int c;
		int cnt;
		int key;
		
		public Cell(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	static int N, M;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] map;
	static boolean[][][] visited;
	static Cell start;
	static int mincnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j];
				if(map[i][j] == '0') {
					start = new Cell(i,j,0,0);
				}
			}
		}
		mincnt = Integer.MAX_VALUE;
		System.out.println(bfs(start.r, start.c) ? mincnt : -1);
	}
	
	private static boolean bfs(int r, int c) {
		Queue<Cell> q = new LinkedList<>();
		q.offer(new Cell(r,c,0,0));
		visited[0][r][c] = true;

		while(!q.isEmpty()) {
			Cell curr = q.poll();
			int key = curr.key;
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				int tempkey = key;
				
				if(!check(nr,nc)) continue; // 범위
				if(map[nr][nc] == '#' || visited[curr.key][nr][nc]) continue; // 벽, 방문여부
				else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') { // 문
					if(((1 << map[nr][nc]-'A') & key) <= 0) continue;
				}
				else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 열쇠
					tempkey = key | (1 << map[nr][nc]-'a');
				}else if(map[nr][nc] == '1') { // 탈출
					mincnt = curr.cnt+1;
					return true;
				}
				visited[tempkey][nr][nc] = true;
				q.offer(new Cell(nr,nc,curr.cnt+1,tempkey));
			}
		}
		return false;
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
