import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {
	
	static int T = 10;
	static int W = 100;
	static int[] map;
	static int dump;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			//초기화
			dump = sc.nextInt();
			map = new int[W];
			
			for (int j = 0; j < W; j++) {
				map[j] = sc.nextInt();
			}
			
			//로직
			int a = 0;
			for (int j = 0; j <= dump; j++) {
				int hmax = 0;
				int hmin = 101;
				int maxidx = 0;
				int minidx = 0;
				for (int i = 0; i < W; i++) {
					if(hmax < map[i]) {
						hmax = map[i];
						maxidx = i;
					}
					if(hmin > map[i]) {
						hmin = map[i];
						minidx = i;
					}
				}

				a = hmax - hmin;
				if(a <= 1) {
					break;
				}
				map[maxidx]--;
				map[minidx]++;
			}
			//출력
			System.out.println("#"+t+" "+a);
		}
	}
}
