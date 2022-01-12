import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225 {
	static int T = 10;
	static int num = 8;
	static int[] minus = {1,2,3,4,5};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			
			for (int i = 0; i < num; i++) {
				queue.offer(sc.nextInt());
			}
			
			int j = 0;
			while(true) {
				int temp = queue.poll();
				temp -= minus[j];
				if(temp <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(temp);
				j = (j+1)%5;
			}
			
			System.out.print("#"+t+" ");
			for (int i = 0; i < num; i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}
}
