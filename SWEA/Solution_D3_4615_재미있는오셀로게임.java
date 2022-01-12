import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_4615_재미있는오셀로게임 {
	
	static int T;
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N+2][N+2];
			
			//초기화
			Arrays.fill(map[0], 3);
			Arrays.fill(map[N+1], 3);
			for (int i = 0; i < N+2; i++) {
				map[i][0] = 3;
				map[i][N+1] = 3;
			}
			map[N/2][N/2] = 2;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2] = 1;
			map[N/2+1][N/2+1] = 2;
			
			cnt = 4;
			
			for (int i = 0; i < M; i++) {
				int ir = sc.nextInt();
				int ic = sc.nextInt();
				int color = sc.nextInt();
				
				if(cnt == N*N) break;
				cnt++;
				go(ir,ic, color);
			}
			
			int bcnt = 0;
			int wcnt = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 1) bcnt++;
					else if(map[i][j] == 2) wcnt++;
				}
			}
			
			System.out.println("#"+t+" "+bcnt+" "+wcnt);
		}
	}

	private static void go(int r, int c, int color) {
		map[r][c] = color;
		int oppColor;
		if(color == 1) {
			oppColor = 2;
		}else {
			oppColor = 1;
		}
		
		for (int d = 0; d < 8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(map[nr][nc] == 3) continue;
			
			//내 돌 사이에 다른 돌이 있을 때
			if(map[nr][nc] == oppColor) {
				int nnr = nr; // 적 돌의 위치
				int nnc = nc;
				while(map[nnr][nnc] != 3 && map[nnr][nnc] != 0) {
					// 적 돌이 내 돌 사이에 있었다면
					if(map[nnr][nnc] == color) {
						int rr = nr;
						int cc = nc;
						// 사이에 있는 돌은 내 돌로 바뀜
						while(rr != nnr || cc != nnc) { // **좌표는 크기와 상관없다. 값이 같냐 아니냐로 비교해야 함
							map[rr][cc] = color;
							rr+=dr[d];
							cc+=dc[d];
						}
						break;
					}
					nnr+=dr[d];
					nnc+=dc[d];
				}
			}
		}
		
	}
}
