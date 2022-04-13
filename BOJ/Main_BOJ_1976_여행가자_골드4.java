
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1976_여행가자_골드4 {
	
	static int N, M;
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		//
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i] = 1;
		}
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp > 0) {
					union(i,j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int value = find(Integer.parseInt(st.nextToken()) -1);
		boolean flag = true;
		for (int i = 1; i < M; i++) {
			if(value != find(Integer.parseInt(st.nextToken()) -1)) {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? "YES" : "NO");
	}
	
	public static int find(int target) {
		if(parent[target] == target) {
			return target;
		}
		else {
			return parent[target] = find(parent[target]);
		}
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return;
		if(rank[pa] >= rank[pb]) {
			parent[pb] = pa;
			rank[pa] += rank[pb];
		}else {
			parent[pa] = pb;
			rank[pb] += rank[pa];
		}
	}
}
