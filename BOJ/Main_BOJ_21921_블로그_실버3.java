
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//시간 292ms
//메모리 37636kb
public class Main_BOJ_21921_블로그_실버3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] visits = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			visits[i] = Integer.parseInt(st.nextToken());
		}
		
		int nowsum = 0;
		int max = 0;
		for (int i = 0; i < X; i++) {
			nowsum += visits[i];
		}
		max = nowsum;
		int cnt = 1;
		for (int i = 1; i < N-(X-1); i++) { 
			nowsum -= visits[i-1];
			nowsum += visits[i+(X-1)];
			if(max < nowsum) {
				max = nowsum;
				cnt = 1;
			}else if(max == nowsum) {
				cnt++;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
