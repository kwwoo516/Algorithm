import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16935 {
	
	static int N;
	static int M;
	static int R;
	static int[][] map;
	static int[] cal_num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cal_num = new int[R];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			cal_num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			switch(cal_num[i]){
			case 1: cal_1(); break;
			case 2: cal_2(); break;
			case 3: cal_3(); break;
			case 4: cal_4(); break;
			case 5: cal_5(); break;
			case 6: cal_6(); break;
			}
		}
		
		print();
	}

	private static void cal_1() {
		int[] temp = new int[M];
		for (int i = 0; i < N/2; i++) {
			temp = map[i];
			map[i] = map[N-1-i];
			map[N-1-i] = temp;
		}
	}
	
	private static void cal_2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][M-1-j];
				map[i][M-1-j] = temp;
			}
		}
	}
	
	private static void cal_3() {
		int [][] turn = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				turn[i][j] = map[N-1-j][i];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		map = turn;
	}
	
	private static void cal_4() {
		int [][] turn = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				turn[i][j] = map[j][M-1-i];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		map = turn;
	}
	
	
	private static void cal_5() {
		int[][] temp = new int[N][M];
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j+M/2] = map[i][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i+N/2][j+M/2] = map[i][j+M/2];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i+N/2][j] = map[i+N/2][j+M/2];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j] = map[i+N/2][j];
			}
		}
		
		map = temp;
	}
	
	private static void cal_6() {
		int[][] temp = new int[N][M];
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i+N/2][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i+N/2][j+M/2] = map[i+N/2][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j+M/2] = map[i+N/2][j+M/2];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j] = map[i][j+M/2];
			}
		}
		
		map = temp;
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
}
