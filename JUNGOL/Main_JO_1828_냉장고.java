import java.util.Arrays;
import java.util.Scanner;

public class Main_JO_1828_냉장고 {
	
	static class C implements Comparable<C>{
		int start;
		int end;
		
		public C(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(C o) {
			return this.end - o.end;
		}
		
	}
	
	static int N;
	static C[] chemi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		chemi = new C[N];
		for (int i = 0; i < N; i++) {
			chemi[i] = new C(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(chemi);

		int cnt = 1;
		int ed = chemi[0].end;
		
		for (int i = 1; i < N; i++) {
			if(ed < chemi[i].start) {
				// 새로운 냉장고
				cnt++;
				ed = chemi[i].end;
			}
		}
		
		System.out.println(cnt);
		
	}

}
