import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {
	static int T, N;
	static int[] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxidx = N-1;
			int max = price[maxidx];
			long sum = 0;
			
			for (int i = N-1; i >= 0; i--) {
				if(max <= price[i]) {
					for (int j = i+1; j <= maxidx; j++) {
						sum += max - price[j];
					}
					max = price[i];
					maxidx = i;
				}
			}
			for (int i = 0; i <= maxidx; i++) {
				sum += max - price[i];
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

}
