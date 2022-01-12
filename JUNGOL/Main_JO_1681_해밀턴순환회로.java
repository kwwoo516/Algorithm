import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {
	static int N;
	static int[][] map;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		
		int[] nums = new int[N];
		nums[0] = 0;
		perm(1, 0, new boolean[N], nums);
		
		System.out.println(min);
	}

	private static void perm(int cnt, int sum, boolean[] v, int[] nums) {
		if(sum > min) {
			return;
		}
		if(cnt == N) {
			//마지막집에서 회사
			if(map[nums[N-1]][nums[0]] == 0) return;
			int dis = map[nums[N-1]][nums[0]];
			min = Math.min(min, sum+dis);
			return;
		}
		for (int i = 1; i < N; i++) {
			if(v[i]) continue;
			if(map[nums[cnt-1]][i] == 0) continue;
			v[i] = true;
			nums[cnt] = i;
			perm(cnt+1,sum + map[nums[cnt-1]][nums[cnt]],v,nums);
			v[i] = false;
		}
	}
}
