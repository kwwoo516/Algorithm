import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2636_치즈_골드5 {
	
	static int R, C;
	static int[][] map;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	static int cnt;
	static int cheeseCnt;
	static int cheeseCntPre;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//initialize
		fill(0,0);
		
		while(edgeCut()) {
			cnt++;
			//fill 2
			cheeseCntPre = cheeseCnt;
			cheeseCnt = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] == 3) {
						for (int d = 0; d < 4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(map[nr][nc] == 2) {
								map[r][c] = 2;
								break;
							}
						}
					} 
				}
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] == 0) {
						for (int d = 0; d < 4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(map[nr][nc] == 2) {
								fill(r,c);
								break;
							}
						}
					} 
				}
			}
		}
		System.out.println(cnt);
		System.out.println(cheeseCntPre);
	}
	
	public static boolean edgeCut() {
		boolean flag = false;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 1) {
					cheeseCnt++;
					flag = true;
					for (int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(map[nr][nc] == 2) {
							map[r][c] = 3;
							break;
						}
					}
				}
			}
		}
		return flag;
	}
	
	public static void fill(int r, int c) {
		map[r][c] = 2;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] == 0) {
				fill(nr,nc);
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
