import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS {
	static ArrayList<Integer>[] list;
	static int N;
	static int M;
	static int V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		for (int i = 1; i < N+1; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs();
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			for (int i : list[curr]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	private static void dfs(int curr, boolean[] visited) {
		visited[curr] = true;
		System.out.print(curr+" ");
		for (int i : list[curr]) {
			if(!visited[i]) {
				dfs(i, visited);
			}
		}
	}

}
