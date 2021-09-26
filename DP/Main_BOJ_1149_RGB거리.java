import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리 {
	static int N;
	static int[][] cost;
	static int[][] house;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		house = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		// R G B
		house[0][0] = cost[0][0];
		house[0][1] = cost[0][1];
		house[0][2] = cost[0][2];
		
		for (int i = 1; i < N; i++) {
			house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + cost[i][0];
			house[i][1] = Math.min(house[i-1][0], house[i-1][2]) + cost[i][1];
			house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + cost[i][2];
		}
		//n번째 집의 색의 경우마다 최소값의 최소값
		System.out.println(Math.min(house[N-1][0], Math.min(house[N-1][1], house[N-1][2])));
	}
}
