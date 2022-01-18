

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 참고 - https://st-lab.tistory.com/269
public class Main_BOJ_1654_랜선자르기_실버3 {
	static int K, N;
	static int[] lenline;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lenline = new int[K];
		for (int i = 0; i < K; i++) {
			lenline[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lenline[i]);
		}
		System.out.println(bs());
	}

	private static int bs() {
		int left = 0;
		int right = max+1; // upper bound를 수행하기 위해 +1 / ex) left가 0, right가 0이어도 left < right 이어야 하기 때문에 임의의 1을 더해줌
		
		int mid;
		while(left < right) {
			mid = (left+right)/2;
			int count = 0;
			for (int i = 0; i < K; i++) {
				count += lenline[i]/mid;
			}
			
			if(count >= N) { // mid로 N개 이상 나눠졌다면 -> 최대 랜선의 길이를 구하는 것이므로 더 크게 자르기 위해 left를 크게 함
				left = mid + 1;
			}else { // mid로 나눠도 N개가 나오지 않는다면 -> 더 잘게 나누기 위해 right를 작게 함.
				right = mid;
			}
		}
		
		return right-1; // 임의로 더한 1을 빼줌
	}
}
