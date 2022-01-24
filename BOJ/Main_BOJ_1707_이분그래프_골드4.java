import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// dfs
public class Main_BOJ_1707_이분그래프_골드4_dfs2 {
	static int K,V,E;
	static boolean isB;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		for (int k = 1; k <= K; k++) {
			V = sc.nextInt();
			E = sc.nextInt();
			ArrayList<Integer>[] adj = new ArrayList[V];
			int[] visited = new int[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt()-1; // 0부터 시작
				int end = sc.nextInt()-1;
				adj[start].add(end);
				adj[end].add(start); // 양방향
			}
			
			Arrays.fill(visited, -1); // 초기화
			
			isB = true;
			for (int i = 0; i < V; i++) {
				if(visited[i] == -1) {
					dfs(adj, visited, i);
					if(!isB) break;
				}
			}
			
			if(isB) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

	private static void dfs(ArrayList<Integer>[] adj, int[] visited, int from) {
		for (int i : adj[from]) {
			if(i == from) {
				isB = false;
				return;
			}
			if(visited[i] == -1) {
				visited[i] = 1 - visited[from]; // 다른 집합으로 set
				dfs(adj, visited, i);
			}else {
				if(visited[i] == visited[from]) { // 인접정점이 같은 집합이라면
					isB = false;
					return;
				}
			}
		}
		return;
	}
}
