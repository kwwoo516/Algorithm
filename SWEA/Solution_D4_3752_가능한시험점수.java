import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3752_D4_가능한시험점수 {
	// dp
	static int T, N;
	static int[] score;
	static boolean[] score_list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			score = new int[N];
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				sum += score[i]; 
			}
			score_list = new boolean[sum+1];
			
			score_list[0] = true;
			
			for (int i = 0; i < N; i++) {
				for (int j = sum; j >= 0; j--) { // 모든 합의 경우 탐색 -> 거꾸로 하는 이유? 오름차순이면 값이 누적되서 망함
					if(score_list[j]) {
						score_list[score[i]+j] = true;
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i <= sum; i++) {
				if(score_list[i]) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
