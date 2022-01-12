import java.util.Scanner;

public class Main_JO_1707_달팽이사각형 {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		int r = 0;
		int c = 0;
		int d = 0;
		
		for (int i = 0; i < N*N; i++) {
			map[r][c] = i+1;
			int nr = r+dr[d%4];
			int nc = c+dc[d%4];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
				d++;
			}else if(map[nr][nc] != 0){
				d++;
			}
			r+=dr[d%4];
			c+=dc[d%4];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
