import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	static int T;
	static int V,E;
	static ArrayList<Node>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				adj[start].add(new Node(end,weight));
				adj[end].add(new Node(start,weight));
			}
			long result = prim();
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static long prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[V+1];
		long weight = 0;
		//start
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node edge = pq.poll();
			
			if(visited[edge.v]) continue;
			weight += edge.w;
			visited[edge.v] = true;
			
			for (int i = 0; i < adj[edge.v].size(); i++) { // v의 인접리스트 탐색
				Node temp = adj[edge.v].get(i); 
				if(visited[temp.v]) continue;
				pq.offer(temp);
			}
		}
		return weight;
	}
}
