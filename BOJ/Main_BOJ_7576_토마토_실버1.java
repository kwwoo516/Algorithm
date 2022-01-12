import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토_실버1 {
// bfs
	static int N,M;
	static int[][] map;
	
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new int[N][M];
		int cnt = 0;
		int tnum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]  == 1) {
					q.offer(new int[] {i,j});
				}else if(map[i][j]  == 0) {
					tnum++;
				}
			}
		}
		
		int qsize = 0;
		
		while(!q.isEmpty()) {
			qsize = q.size();
			boolean isIc = false;
			for (int i = 0; i < qsize; i++) {
				int[] tomato = q.poll();
				int r = tomato[0];
				int c = tomato[1];
				for (int d = 0; d < 4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(!check(nr,nc)) continue;
					if(map[nr][nc] == 0) {
						map[nr][nc] = 1;
						tnum--;
						isIc = true;
						q.offer(new int[] {nr,nc});
					}
				}
			}
			if(isIc) {
				cnt++;
			}
		}
		
		System.out.println(tnum>0?-1:cnt);
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M; 
	}

}
