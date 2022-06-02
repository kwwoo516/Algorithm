
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_11779_최소비용구하기2_골드3 { // ㄴㄴ
	
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M, start, end;
	static int[] dist;
	static int[] route;
	static boolean[] visit;
	static ArrayList<Node>[] list;
	static final int INF = 1000000001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken()); 
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, cost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		route = new int[N+1];
		visit = new boolean[N+1];
		dijkstra();
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		ArrayList<Integer> router = new ArrayList<>();
		int curr = end;
		while(curr != 0) {
			router.add(curr);
			curr = route[curr];
		}
		sb.append(router.size()).append("\n");
		for (int i = router.size()-1; i >= 0; i--) {
			sb.append(router.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		route[start] = 0;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			if(visit[temp.end]) continue;
			visit[temp.end] = true;
			for (int i = 0; i < list[temp.end].size(); i++) {
				Node n = list[temp.end].get(i);
				if(dist[n.end] > dist[temp.end] + n.cost) { // n 에서 목적지로 가는 가는 비용 > temp에서 n을 경유해서 목적지로 가는 비용
					dist[n.end] = dist[temp.end] + n.cost;
					pq.add(new Node(n.end, dist[n.end]));
					route[n.end] = temp.end; // 직전 방문 노드 temp.end를 방문
				}
			}
		}
	}
}
