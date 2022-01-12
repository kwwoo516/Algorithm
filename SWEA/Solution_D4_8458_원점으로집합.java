import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8458_원점으로집합 {
	static int T;
	static int N;
	static int[] val;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			val = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			val[0] = Math.abs(x) + Math.abs(y);
			max = val[0];
			int cnt = 0;
			int sum = 0;
			
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				val[i] = Math.abs(x) + Math.abs(y);
				max = Math.max(max, val[i]);
				
				if(val[i]%2 != val[i-1]%2) {
					cnt = -1;
				}
			}
			if(cnt == 0) {
				while(true) {
					boolean isA = true;
					if(sum < max || (max - sum)%2 != 0) {
						isA = false;
					}
					if(isA) break;
					cnt++;
					sum += cnt;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}

