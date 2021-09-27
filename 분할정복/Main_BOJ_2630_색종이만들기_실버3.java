import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2630_색종이만들기_실버3 {
	
	static int N;
	static int [][] map;
	static int W;
	static int B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		W = 0;
		B = 0;
		color(0,0,N);
		System.out.println(W);
		System.out.println(B);
	}

	private static void color(int r, int c, int width) {
		if(width == 1 || sameColor(r,c,width)) {
			if(map[r][c] == 0) {
				W++;
			}else if(map[r][c] == 1) {
				B++;
			}
			return;
		}
		
		int w = width/2;
		color(r,c,w);
		color(r,c+w,w);
		color(r+w,c,w);
		color(r+w,c+w,w);
	}

	private static boolean sameColor(int r, int c, int width) {
		int temp = map[r][c];
		for (int i = r; i < r+width; i++) {
			for (int j = c; j < c+width; j++) {
				if(temp != map[i][j]) return false;
			}
		}
		return true;
	}
}
