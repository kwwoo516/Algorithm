import java.util.Scanner;

public class Solution_D4_1861 {
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int T;
	static int N;
	static int[][] room;
	static int[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			room = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			
			int roomNum = 0;
			int max = -1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j] == 0) {
						dfs(i,j);
						if(max < visited[i][j]) {
							max = visited[i][j];
							roomNum = room[i][j];
						}else if(max == visited[i][j]) {
							roomNum = Math.min(roomNum, room[i][j]);
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+roomNum+" "+max);
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!check(nr, nc)) continue;
			
			if(room[nr][nc] == room[r][c]+1) {
				//방문 안했을 때
				if(visited[nr][nc] == 0) {
					dfs(nr,nc);
				}
				//방문 끝나고 정산
				visited[r][c] = Math.max(visited[r][c], visited[nr][nc]+1); 
			}
		}
	}
	
	private static boolean check(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}
}
