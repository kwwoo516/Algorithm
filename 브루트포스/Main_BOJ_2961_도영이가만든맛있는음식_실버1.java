import java.util.Scanner;

public class Main_BOJ_2961_도영이가만든맛있는음식_실버1 {
	
	static int N;
	static long[][] taste;
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		taste = new long[N][2];
		
		for (int i = 0; i < N; i++) {
			taste[i][0] = sc.nextLong();
			taste[i][1] = sc.nextLong();
		}
		
		subset(0,new boolean[N]);
		
		System.out.println(min);
	}

	public static void subset(int cnt, boolean[] v) {
		if(cnt == N) {
			long s=1;
			long b=0;
			boolean nothing = true;
			for (int i = 0; i < N; i++) {
				if(v[i]) {
					s *= taste[i][0];
					b += taste[i][1];
					nothing = false;
				}
			}
			if(!nothing) {
				min = Math.min(Math.abs(s-b), min);
				return;
			}
			return;
		}
		
		v[cnt] = true;
		subset(cnt+1,v);
		v[cnt] = false;
		subset(cnt+1,v);
	}

}
