import java.util.Scanner;

public class Main_BOJ_2941_크로아티아알파벳_실버5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		char[] in = sc.next().toCharArray();
		for (int i = 0; i < in.length; i++) {
			if(i < in.length-1) {
				if(in[i] == 'c' && in[i+1] == '=') {
					cnt++;
					i++;
					continue;
				}else if(in[i] == 'c' && in[i+1] == '-') {
					cnt++;
					i++;
					continue;
				}else if(in[i] == 'd' && in[i+1] == 'z') {
					if(i < in.length-2 && in[i+2] == '=') {
						cnt++;
						i+=2;
						continue;
					}
				}else if(in[i] == 'd' && in[i+1] == '-') {
					cnt++;
					i++;
					continue;
				}else if(in[i] == 'l' && in[i+1] == 'j') {
					cnt++;
					i++;
					continue;
				}else if(in[i] == 'n' && in[i+1] == 'j') {
					cnt++;
					i++;
					continue;
				}else if(in[i] == 's' && in[i+1] == '=') {
					cnt++;
					i++;
					continue;
				}else if(in[i] == 'z' && in[i+1] == '=') {
					cnt++;
					i++;
					continue;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
