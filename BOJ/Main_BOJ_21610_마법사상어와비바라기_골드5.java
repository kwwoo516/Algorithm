package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시간 660ms
//메모리 34284kb
//코드길이 3115b

public class Main_BOJ_21610_마법사상어와비바라기_골드5{
	static class Loc{
		int r;
		int c;
		
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Loc> cloud;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 비바라기 시전
		cloud = new ArrayList<>();
		cloud.add(new Loc(N-1,0));
		cloud.add(new Loc(N-1,1));
		cloud.add(new Loc(N-2,0));
		cloud.add(new Loc(N-2,1));
		
		for (int i = 0; i < M; i++) {
			// 구름 기록 초기화
			visit = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken())-1;
			int S = Integer.parseInt(st.nextToken());
			
			// 1. 모든 구름이 d 방향으로 s칸 이동
			for (int j = 0; j < cloud.size(); j++) {
				int nr = cloud.get(j).r; 
				int nc = cloud.get(j).c; 
				for (int s = 0; s < S; s++) {
					nr += dr[D];
					nc += dc[D];
					if(nr > N-1) nr = 0;
					else if(nr < 0) nr = N-1;
					if(nc > N-1) nc = 0;
					else if(nc < 0) nc = N-1;
				}
				cloud.get(j).r = nr;
				cloud.get(j).c = nc;
			}
			
			// 2. 비가 내린다.
			for (Loc cd : cloud) {
				map[cd.r][cd.c] += 1;
				visit[cd.r][cd.c] = true;
			}
			
			// 3. 구름이 사라진다.
			cloud.clear();
			
			
			// 4. 물복사 버그를 쓴다. 
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(visit[r][c]) {
						int cnt = 0;
						for (int d = 1; d < 8; d+=2) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							
							if(!check(nr,nc)) continue;
							if(map[nr][nc] > 0) {
								cnt++;
							}
						}
						map[r][c] += cnt;
					}
				}
			}
			
			// 5. 물이 2 이상이면 구름 생긴다.
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(!visit[r][c]) {
						if(map[r][c] >= 2) {
							map[r][c] -= 2;
							cloud.add(new Loc(r,c));
						}
					}
				}
			}
			
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
