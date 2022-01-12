import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥 {
	
	static int N, d, k, c;
	static int[] sushi;
	static int[] selected;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		selected = new int[d+1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		cal();
		
		System.out.println(max);
	}
	
	private static void cal() {
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if(selected[sushi[i]] == 0) {
				cnt++;
			}
			selected[sushi[i]]++;
		}
		max = cnt;
		
		for (int i = 1; i < N; i++) {
			if(max <= cnt) {
				if(selected[c] == 0) {
					max = cnt+1;
				}else {
					max = cnt;
				}
			}
			// 슬라이싱 윈도우
			selected[sushi[i-1]]--;
			if(selected[sushi[i-1]] == 0) {
				cnt--;
			}
			if(selected[sushi[(i+k-1)%N]] == 0) {
				cnt++;
			}
			selected[sushi[(i+k-1)%N]]++;
		}
	}

}
