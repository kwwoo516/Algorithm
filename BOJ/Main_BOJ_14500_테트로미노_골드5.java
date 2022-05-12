import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간 488ms
//메모리 31864kb
public class Main_BOJ_14500_테트로미노_골드5 {
	static int N, M;
	static int[][] map;
	static int[][] dr = {{0,0,0,0},{0,1,2,3},
			{0,0,1,1},
			{0,1,2,2},{1,0,0,0},{0,0,1,2},{1,1,1,0},{0,1,2,2},{0,1,1,1},{0,0,1,2},{0,0,0,1},
			{0,1,1,2},{1,1,0,0},{2,1,1,0},{0,0,1,1},
			{0,0,1,0},{1,1,0,1},{0,1,1,2},{0,1,1,2}
			};
	static int[][] dc = {{0,1,2,3},{0,0,0,0},
			{0,1,0,1},
			{0,0,0,1},{0,0,1,2},{0,1,1,1},{0,1,2,2},{1,1,1,0},{0,0,1,2},{1,0,0,0},{0,1,2,2},
			{0,0,1,1},{0,1,1,2},{0,0,1,1},{0,1,1,2},
			{0,1,1,2},{0,1,1,2},{1,1,0,1},{0,0,1,0}
			};
	
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
		int max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int i = 0; i < dr.length; i++) {
					int sum = 0;
					boolean flag = true;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[i][d];
						int nc = c + dc[i][d];
						if(!check(nr,nc)) {
							flag = false;
							break;
						}
						sum += map[nr][nc];
					}
					if(flag) {
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
