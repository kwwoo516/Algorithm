import java.util.Scanner;

public class Main_BOJ_1748_수이어쓰기1_실버3 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int len = String.valueOf(n).length();
		int sum = 0;
		int num = 9;
		
		for(int i = 1; i < len; i++) {
			sum += num*i; // i는 자리수, num은 갯수
			num *= 10;
		}
		sum += (n - Math.pow(10, len-1)+1)*len;
		System.out.println(sum);
	}
}
