

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10815_숫자카드_실버4 {
	
	static int N, M;
	static int[] card;
	static int[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		check = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(card);
		for (int i = 0; i < M; i++) {
			bs(check[i]);
		}
		System.out.println();
	}

	private static void bs(int find) {
		int left = 0;
		int right = card.length-1;
		int mid;
		
		while(left <= right) {
			mid = (left + right)/2;
			
			if(find == card[mid]) {
				System.out.print(1+" ");
				return;
			}
			
			if(find > card[mid]) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.print(0+" ");
	}
}
