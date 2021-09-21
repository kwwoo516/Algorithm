import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_골드5_14502_연구소 {
	
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static int[][] copy;
	static ArrayList<int[]> zeros = new ArrayList<>();
	static int N,M,K;
	static int wall = 3;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					zeros.add(new int[] {i,j});
				}
			}
		}
		K = zeros.size();
		max = Integer.MIN_VALUE;
		combi(0,0,new int[wall]);
		System.out.println(max);
	}

	private static void combi(int start, int cnt, int[] nums) {
		if(cnt == wall) {
			copy = copymap();
			int w1[] = zeros.get(nums[0]);
			int w2[] = zeros.get(nums[1]);
			int w3[] = zeros.get(nums[2]);
			copy[w1[0]][w1[1]] = 1;
			copy[w2[0]][w2[1]] = 1;
			copy[w3[0]][w3[1]] = 1;
			
			ArrayList<int[]> virus = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copy[i][j] == 2) {
						virus.add(new int[] {i,j});
					}
				}
			}
			
			for (int i = 0; i < virus.size(); i++) {
				int r = virus.get(i)[0];
				int c = virus.get(i)[1];
				fillvirus(r, c);
			}
			max = Math.max(max, countSafe(copy));
			return;
		}
		
		for (int i = start; i < K; i++) {
			nums[cnt] = i;
			combi(i+1, cnt+1, nums);
		}
	}
	
	public static void fillvirus(int r, int c){
		copy[r][c] = 2;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(copy[nr][nc] == 0) {
				fillvirus(nr, nc);
			}
		}
	}
	
	public static int countSafe(int[][] a){
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(a[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	public static int[][] copymap(){
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp; 
	}
	
	public static void print(int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
