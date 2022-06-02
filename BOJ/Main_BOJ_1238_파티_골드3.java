import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//시간 ms
//메모리 kb
public class Main_BOJ_1238_파티_골드3 {
	static class Node implements Comparable<Node>{
		int idx;
		int dist;
		
		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	static final int INF = 1000000000;
	static int N, M, X;
	static int[] distList;
	static int[] rdistList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		List<List<Node>> list = new ArrayList<>();
		List<List<Node>> rlist = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			rlist.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			list.get(r).add(new Node(c, dist));
			rlist.get(c).add(new Node(r, dist));
		}
		
		distList = new int[N];
		rdistList = new int[N];
		Arrays.fill(distList, INF);
		Arrays.fill(rdistList, INF);
		
		dijkstra(list, X, distList);
		dijkstra(rlist, X, rdistList);
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, distList[i] + rdistList[i]);
		}
		System.out.println(max);
	}
	
	public static void dijkstra(List<List<Node>> list, int start, int[] distance) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N];
		pq.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			if(visit[temp.idx]) continue;
			visit[temp.idx] = true;
			
			for (Node n : list.get(temp.idx)) {
				if(distance[n.idx] > distance[temp.idx] + n.dist) {
					distance[n.idx] = distance[temp.idx] + n.dist;
					pq.add(new Node(n.idx, distance[n.idx]));
				}
			}
		}
	}
	
}
