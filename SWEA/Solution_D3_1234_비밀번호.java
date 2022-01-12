import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1234_비밀번호_IM {
	static int T = 10;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			
			char[] pw = sc.next().toCharArray();
			for (int i = 0; i < N; i++) {
				if(stack.isEmpty()) {
					stack.push(pw[i]);
				}else {
					if(stack.peek() == pw[i]) {
						stack.pop();
					}else {
						stack.push(pw[i]);
					}
				}
			}
			
			int n = stack.size();
			char[] c = new char[n];
			
			while(!stack.isEmpty()) {
				c[n-1] = stack.pop();
				n--;
			}
			
			System.out.println("#"+t+" "+String.valueOf(c));
		}
	}
}
