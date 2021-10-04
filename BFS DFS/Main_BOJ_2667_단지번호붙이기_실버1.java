import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2667 {
	
	static int N;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		count = new int[N*N];
		
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j]-'0';
			}
		}
		
		int num = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					num++;
					count[num+1]=1;
					dfs(r,c,num+1);
				}
			}
		}
		
		System.out.println(num);
		Integer[] ii = new Integer[num];
		for (int i = 0; i < num; i++) {
			ii[i] = count[i+2];
		}
		Arrays.sort(ii);
		for (int  i : ii) {
			System.out.println(i);
		}
		
	}

	private static void dfs(int r, int c, int group) {
		map[r][c] = group;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] == 1) {
				count[group]++;
				dfs(nr,nc,group);
			}
		}
	}
	
	public static boolean check(int nr,int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
