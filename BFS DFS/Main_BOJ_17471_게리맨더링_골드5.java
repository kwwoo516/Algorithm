import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그래프, bfs
public class Main_BOJ_17471_게리맨더링_골드5 {
	static int N;
	static int[] pop;
	static ArrayList<Integer>[] adjlist;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N];
		adjlist = new ArrayList[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			adjlist[i] = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				adjlist[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		
		subset(0,new boolean[N]);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void subset(int cnt, boolean[] v) {
		if(cnt == N) {
			int anum = 0;
			int bnum = 0;
			
			// 선거구 나뉘었는지 확인
			for (int i = 0; i < N; i++) {
				if(v[i]) { // 하나라도 다르다면
					anum++;
				}else {
					bnum++;
				}
			}
			
			if(anum > 0 && bnum > 0) { // 나뉘었다면
				boolean[] visited = new boolean[N];
				//선거구끼리 연결상태 확인
				int A = -1;
				int B = -1;
				
				for (int i = 0; i < N; i++) {
					if(v[i]) { // 선거구 1
						A = i;
						break;
					}
				}
				for (int i = 0; i < N; i++) {
					if(!v[i]) { // 선거구 2
						B = i;
						break;
					}
				}
				if(search(A, anum, visited, v) && search(B, bnum, visited, v)) {
					int asum = 0;
					int bsum = 0;
					for (int i = 0; i < N; i++) {
						if(v[i]) {
							asum += pop[i];
						}else {
							bsum += pop[i];
						}
					}
					result = Math.min(result, Math.abs(asum - bsum));
				}
			}
			return;
		}
		v[cnt] = true;
		subset(cnt+1,v);
		v[cnt] = false;
		subset(cnt+1,v);
	}

	private static boolean search(int i, int num, boolean[] visited, boolean[] v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		int cnt = 0;
		//a그룹인지 b그룹인지
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(visited[temp] || v[temp] != v[i]) continue; //방문했거나 다른그룹이라면
			visited[temp] = true;
			cnt++;
			for (Integer integer : adjlist[temp]) {
				q.offer(integer);
			}
		}
		if(cnt == num) {
			return true;
		}else {
			return false;
		}
	}
	
}
