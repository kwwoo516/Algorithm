import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳2_골드4 {
	
	static int R, C;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		max = 0;
		borad(0,0,0);
		System.out.println(max);
	}

	private static void borad(int r, int c, int cnt) {
		//알파벳이 들어있는지 확인
		if(visited[map[r][c]-'A']) {
			max = Math.max(cnt, max);
			return; //이미 들어있다면 return;
		}
		visited[map[r][c]-'A'] = true;
		cnt++;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(check(nr, nc)) {
				borad(nr, nc, cnt);
			}
		}
		visited[map[r][c]-'A'] = false;
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
