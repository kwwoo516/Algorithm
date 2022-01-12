import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1226_bfs {

	static int T = 10;
	static int N = 16;
	static int K;
	static int sr, sc, er, ec;
	static int [][] map;
	static int poss;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j]-'0';
					if(map[i][j] == 2) {
						sr = i;
						sc = j;
					}else if(map[i][j] == 3) {
						er = i;
						ec = j;
					}
				}
			}
			poss = 0;
			bfs();
			
			System.out.println("#"+t+" "+poss);
		}
	}

	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr,sc});
		map[sr][sc] = -1;
		
		// 큐에 넣고 빼서 검사하면서 탐색
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr, nc)) continue;
				if(nr == er && nc == ec) {
					poss = 1;
					return;
				}
				if(map[nr][nc] == 0) {
					map[nr][nc] = -1;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N);
	}
}
