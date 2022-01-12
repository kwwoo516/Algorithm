import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808 {

	static int T;
	static int N = 9;
	static int[] Gu_card;
	static int[] In_card;
	static int gu_win;
	static int gu_lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Gu_card = new int[N];
			In_card = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Gu_card[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean isIn = false;
			int c = 0;
			
			for (int i = 1; i <= N*2; i++) {
				for (int j = 0; j < N; j++) {
					if(Gu_card[j] == i) isIn = true;
				}
				if(!isIn) {
					In_card[c++] = i;
				}
				isIn = false;
			}
			
			gu_win = 0;
			gu_lose = 0;
			
			perm(0,new boolean[N], new int[N]);
			
			System.out.println("#"+t+" "+gu_win+" "+gu_lose);
		}
	}

	private static void perm(int cnt, boolean[] v, int[] nums) {
		if(cnt == N) {
			int insum = 0;
			int gusum = 0;
			for (int i = 0; i < N; i++) {
				if(Gu_card[i] > nums[i]) {
					gusum = gusum + Gu_card[i] + nums[i];
				}else {
					insum = insum + Gu_card[i] + nums[i];
				}
			}
			
			if(gusum>insum) gu_win++;
			else if(gusum<insum) gu_lose++;
			
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			nums[cnt] = In_card[i];
			perm(cnt+1,v,nums);
			v[i] = false;
		}
	}
}
