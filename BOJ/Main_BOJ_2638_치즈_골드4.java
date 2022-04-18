
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//시간 288ms
//메모리 42336kb
public class Main_BOJ_2638_치즈_골드4 {
	static class Loc{
		int r;
		int c;
		
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		while(true) {
			init();
			List<Loc> list = new ArrayList<>();
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != 1) continue;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(map[nr][nc] == 8) {
							cnt++;
						}
					}
					if(cnt >= 2) {
						flag = true;
						list.add(new Loc(i,j));
					}
				}
			}
			
			change(list);
			if(!flag) break;
			count++;
		}
		System.out.println(count);
	}
	
	private static void change(List<Loc> list) {
		int len = list.size();
		for (int i = 0; i < len; i++) {
			Loc temp = list.get(i);
			map[temp.r][temp.c] = 8;
		}
	}

	private static void init() {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0,0));
		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;
		map[0][0] = 8;
		
		while(!q.isEmpty()) {
			Loc temp = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				
				if(!check(nr,nc) || visit[nr][nc]) continue;
				if(map[nr][nc] == 0 || map[nr][nc] == 8) {
					q.add(new Loc(nr,nc));
					visit[nr][nc] = true;
					map[nr][nc] = 8;
				}
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
