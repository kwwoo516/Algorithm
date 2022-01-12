import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17472_다리만들기2_골드2 {
	static int N,M;
	static int[][] map;
	static boolean[] v;
	static int[][] len;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static int[] minEdge;
	
	public static void main(String[] args) throws IOException {
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
		int Inum = 0; // 섬 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					Inum++;
					fill(i,j,Inum+1);
				}
			}
		}
		
		// 섬사이 최단거리 저장배열
		len = new int[Inum][Inum];
		for (int i = 0; i < Inum; i++) {
			Arrays.fill(len[i], Integer.MAX_VALUE);
			len[i][i] = 0; // 나 자신은 0
		}
		
		// 최단거리 배열 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					cal(i,j,map[i][j]);
				}
			}
		}
		
		// 최단거리 배열 MST
		v = new boolean[Inum];
		minEdge = new int[Inum];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		int result = 0; // 비용누적
		minEdge[0] = 0; // 시작점
		
		boolean isConn = true;
		
		for (int i = 0; i < Inum; i++) {
			// 1. 신장트리에 포함안된 최소간선비용 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int j = 0; j < Inum; j++) {
				if(!v[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			v[minVertex] = true;
			result += min;
			// 2. 선택한 정점 기준으로 minEdge 갱신
			for (int j = 0; j < Inum; j++) {
				if(!v[j] && len[minVertex][j] != 0 && minEdge[j] > len[minVertex][j]) {
					minEdge[j] = len[minVertex][j];
				}
			}
		}
		
		for (int i = 0; i < Inum; i++) {
			if(minEdge[i] == Integer.MAX_VALUE){
				isConn = false;
				break;
			}
		}
		
		System.out.println(isConn ? result : -1);
	}

	private static void cal(int r, int c, int g) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] == 0) {
				distance(r,c,d,g);
			}
		}
	}

	private static void distance(int r, int c, int d, int g) {
		int dis = 0;
		int nr = r;
		int nc = c;
		while(true) {
			nr+=dr[d];
			nc+=dc[d];
			if(!check(nr,nc)) return;
			if(map[nr][nc] != 0) break;
			dis++;
		}
		if(dis >= 2) { // 섬과의 거리가 2이상이면
			int ng = map[nr][nc];
			if(ng == g) return; // 같은 섬이었다면 return
			if(len[g-2][ng-2] > dis) { // 최소거리 갱신
				len[g-2][ng-2] = dis;
				len[ng-2][g-2] = dis;
			}
		}
	}

	private static void fill(int r, int c, int cnt) {
		map[r][c] = cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] == 1) {
				fill(nr,nc,cnt);
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
