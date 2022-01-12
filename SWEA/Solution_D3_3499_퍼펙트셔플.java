import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_3499 {
	
	static int T;
	static int N;
	static String[] s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			s = new String[N];
			for (int i = 0; i < N; i++) {
				s[i] = sc.next();
			}
			
			String[] up = Arrays.copyOfRange(s, 0, (int)Math.ceil((float)N/2));
			String[] down = Arrays.copyOfRange(s, (int)Math.ceil((float)N/2), N);
			
			int ucnt = 0;
			int dcnt = 0;
			
			for (int i = 0; i < N; i++) {
				if(i%2 == 0) {
					s[i] = up[ucnt++];
				}else if(i%2 != 0) {
					s[i] = down[dcnt++];
				}
			}
			
			System.out.print("#"+t+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(s[i]+" ");
			}
			System.out.print("\n");
		}
	}
}

