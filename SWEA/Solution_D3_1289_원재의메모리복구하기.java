import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {
	
	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			int count = 0;
			//로직
			char[] ch = s.toCharArray();
			char flag = '0';
			for (char c : ch) {
				if(c != flag) {
					flag = c;
					count++;
				}
			}
			
			//출력
			System.out.println("#"+t+" "+count);
			
		}
	}
}
