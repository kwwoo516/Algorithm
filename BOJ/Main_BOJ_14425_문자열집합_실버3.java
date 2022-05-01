
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 324ms
// 38920kb

public class Main_BOJ_14425_문자열집합_실버3 {
	static int N, M;
	static HashMap<String, Integer> map;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			if(map.get(br.readLine()) != null) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
