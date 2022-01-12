import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218 {
	static int T = 10;
	
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= T; t++) {
			int len = sc.nextInt();
			String s = sc.next();
			char[] ss = s.toCharArray();
			
			int result = 1;
			
			for (int i = 0; i < len; i++) {
				if(ss[i] == '>') {
					if(stack.peek() == '<') {
						stack.pop();
					}else {
						result = 0;
						break;
					}
				}else if(ss[i] == ']') {
					if(stack.peek() == '[') {
						stack.pop();
					}else {
						result = 0;
						break;
					}
				}else if(ss[i] == ')') {
					if(stack.peek() == '(') {
						stack.pop();
					}else {
						result = 0;
						break;
					}
				}else if(ss[i] == '}') {
					if(stack.peek() == '{') {
						stack.pop();
					}else {
						result = 0;
						break;
					}
				}else {
					stack.push(ss[i]);
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
