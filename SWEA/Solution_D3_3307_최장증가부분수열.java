import java.util.Arrays;
import java.util.Scanner;

public class Solution_3307_최장증가부분수열 {
	static int T;
	static int N;
	static int[] list;
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			list = new int[N];
			count = new int[N];
			Arrays.fill(count, 1);
			
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}
			
			int max = 0;
			for (int i = N-1; i >= 0; i--) {
				int base = count[i];
				for (int j = i+1; j < N; j++) {
					if(list[i] <= list[j]) {
						count[i] = Math.max(count[i], count[j]+base);
					}
				}
				max = Math.max(max, count[i]);
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}
