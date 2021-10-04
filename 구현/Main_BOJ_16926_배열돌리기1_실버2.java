import java.util.Scanner;

public class Main_BOJ_16926_배열돌리기1_실버2 {
	
	static int N, M, R;
	static int[][] map;
	static int[] dr = {0,1,0,-1};	
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int wrap = N > M ? M/2 : N/2;
		for (int turn = 0; turn < R; turn++) {
			for (int w = 0; w < wrap; w++) {
				int temp = map[w][w];
				int r = w;
				int c = w;
				int d = 0;
				while(!(r+dr[d] == w && c+dc[d] == w)) {
					if(!check(r+dr[d],c+dc[d],w)) {
						d++;
						continue;
					}
					map[r][c] = map[r+dr[d]][c+dc[d]];
					r = r+dr[d];
					c = c+dc[d];
				}
				map[r][c] = temp;
			}
		}
		
		print();
	}
	
	public static boolean check(int r,int c, int wrap) {
		return r >= wrap && r < (N-wrap) && c >= wrap && c < (M-wrap);
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
