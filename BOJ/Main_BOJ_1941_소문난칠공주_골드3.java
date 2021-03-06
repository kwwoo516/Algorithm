package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//시간 360ms
//메모리 68496kb
//코드길이 1881

public class Main_BOJ_1941_소문난칠공주_골드3 {
	static int N = 5;
	static char[][] map;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		count = 0;
		combi(0,0,new int[7], 0);
		System.out.println(count);
	}

	private static void combi(int start, int cnt, int[] nums, int ycnt) {
		if(cnt == 7) {
			if(bfs(nums)) {
				count++;
			}
			return;
		}
		for (int i = start; i < 25; i++) {
			nums[cnt] = i;
			int y = 0;
			if(map[i/5][i%5] == 'Y') {
				if(ycnt+1 > 3) continue;
				y = 1;
			}
			combi(i+1, cnt+1, nums, ycnt+y);
		}
	}
	
	private static boolean bfs(int[] nums) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[7];
		q.offer(nums[0]);
		visited[0] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			int r = curr/5;
			int c = curr%5;
			
			for (int i = 0; i < 7; i++) {
				if(visited[i]) continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(!check(nr, nc)) continue;
					if(nr == nums[i]/5 && nc == nums[i]%5) {
						q.offer(nums[i]);
						visited[i] = true;
						break;
					}
				}
			}
		}
		
		//check
		boolean closed = true;
		for (int i = 0; i < 7; i++) {
			if(!visited[i]) {
				closed = false;
				break;
			}
		}
		return closed;
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
