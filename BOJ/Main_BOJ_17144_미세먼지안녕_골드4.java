import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_17144_미세먼지안녕_골드4 {
	static int R, C, T;
	static int[][] map;
	static int[][] summap;
	
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	static int[] udr = {0,-1,0,1};
	static int[] udc = {1,0,-1,0};
	
	static int[] ddr = {0,1,0,-1};
	static int[] ddc = {1,0,-1,0};
	
	static ArrayList<int[]> list;
	static int machineR;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		summap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(machineR != 0) continue;
					machineR = i;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			// 1. 미세먼지 확산
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] >=5) {
						spread(r, c);
					}
				}
			}
			sumtable();
			// 2. 공기청정기 작동 - 위
			int ur = machineR;
			int uc = 0;
			int d = 0;
			int tempa = 0;
			int tempb = 0;
			while(true) {
				ur += udr[d];
				uc += udc[d];
				if(!check(ur,uc)) {
					//한칸 빠꾸
					ur -= udr[d];
					uc -= udc[d];
					//방향전환
					d++;
					continue;
				}
				if(map[ur][uc] == -1) {
					break; // 공기청정기로 돌아오면 끝
				}
				tempb = map[ur][uc];
				map[ur][uc] = tempa;
				tempa = tempb;
			}
			// 2. 공기청정기 작동 - 아래
			int dr = machineR+1;
			int dc = 0;
			d = 0;
			tempa = 0;
			tempb = 0;
			while(true) {
				dr += ddr[d];
				dc += ddc[d];
				if(!check(dr,dc)) {
					//한칸 빠꾸
					dr -= ddr[d];
					dc -= ddc[d];
					//방향전환
					d++;
					continue;
				}
				if(map[dr][dc] == -1) {
					break; // 공기청정기로 돌아오면 끝
				}
				tempb = map[dr][dc];
				map[dr][dc] = tempa;
				tempa = tempb;			
			}
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		sum += 2; // 공기청정기 값 더함
		System.out.println(sum);
	}

	private static void sumtable() { // 합산 테이블과 맵 값을 합침
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += summap[i][j];
				summap[i][j] = 0; // 쓴건 초기화
			}
		}
	}

	private static void spread(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue; // 칸이 없을 때
			if(map[nr][nc] == -1) continue; // 칸이 공기청정기일 때
			summap[nr][nc] += map[r][c]/5;
			cnt++;
		}
		map[r][c] -= (map[r][c]/5)*cnt;
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
