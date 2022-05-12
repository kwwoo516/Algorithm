
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간 372ms
//메모리 48576kb
public class Main_BOJ_1717_집합의표현_골드4 {
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(flag == 0) {
				union(a, b);
			}else {
				if(find(a) == find(b)) {
					sb.append("yes").append("\n");
				}
				else {
					sb.append("no").append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void init() {
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int n) {
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		parent[rootB] = rootA;
	}
}
