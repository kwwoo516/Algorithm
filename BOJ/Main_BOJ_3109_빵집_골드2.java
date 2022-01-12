import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집_골드2 {
	
	static int R, C;
	static char[][] map;
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		cnt = 0;
		for (int i = 0; i < R; i++) {
			pipe(i,0);
		}
		
		System.out.println(cnt);
	}

	private static boolean pipe(int r, int c) {
		//끝에 도달했다면 종료
		if(c == C-1) {
			cnt++;
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] != '.') continue; 
			map[nr][nc] = 'P'; // 얘가 못가면 다른애들도 못가는 것이다. 라는 것. 조건만 맞으면 무조건 갈수있다.. 
			if(pipe(nr,nc)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
