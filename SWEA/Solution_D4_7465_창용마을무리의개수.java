import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	
	static int T;
	static int N, M;
	static int[] people;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			int cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == find(j)) {
						cnt++;
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}
	
	public static void make() {
		people = new int[N+1];
		for (int i = 1; i <= N; i++) {
			people[i] = i;
		}
	}
	
	public static int find(int a) {
		if(a == people[a]) return a;
		return people[a] = find(people[a]);
	}
	
	public static void union(int a,int b) {
		int ar = find(a);
		int br = find(b);
		if(ar == br) return;
		people[br] = ar;
	}

}
