import java.util.Scanner;

public class Main_BOJ_1463_1로만들기 {
	static int N;
	static int[] cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = new int[N+1];
		
		for (int i = 2; i <= N; i++) {
			cnt[i] = cnt[i-1]+1;
			if(i%2 == 0) {
				cnt[i] = Math.min(cnt[i], cnt[i/2]+1);
			}
			if(i%3 == 0) {
				cnt[i] = Math.min(cnt[i], cnt[i/3]+1); 
			}
		}
		System.out.println(cnt[N]);
	}
}
