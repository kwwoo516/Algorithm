import java.util.Scanner;

class Solution_D2_1954
{
    static int T;
	static int N;
	static int [][] map;
	static int [] dr= {0,1,0,-1};
	static int [] dc= {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			int r = 0;
			int c = 0;
			int d = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[r][c] = i*N+j +1;
					if( r+dr[d] < 0 || r+dr[d] >= N || c+dc[d] <0 || c+dc[d] >=N || map[r+dr[d]][c+dc[d]] != 0) {
						d = (d+1)%4;
					}
					r += dr[d];
					c += dc[d];
				}
			}
			
			System.out.println("#"+test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ",map[i][j]);
				}
				System.out.println();
			}
		}
	}
}