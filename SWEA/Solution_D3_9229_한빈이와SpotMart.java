import java.util.Scanner;

public class Solution_D3_9229 {
	static int T;
	static int N;
	static int W;
	static int[] snak;
	static int sum = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			snak = new int[N];
			for (int i = 0; i < N; i++) {
				snak[i] = sc.nextInt();
			}
			combi(0,0,0,new boolean[N]);
			
			System.out.println("#"+t+" "+sum);
			sum = -1;
		}
	}
	
	public static void combi(int start, int cnt, int sum_w, boolean[] v) {
		if(cnt == 2) {
			if(sum_w > W) {
				return;
			}
			sum = Math.max(sum, sum_w);
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			combi(i+1, cnt+1, sum_w+snak[i], v);
			v[i] = false;
		}
		
	}
}
