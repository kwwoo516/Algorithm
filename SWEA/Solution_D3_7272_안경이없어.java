import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_D3_7272_안경이없어_IM {
	
	static int T;
	static char[] zero = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
	static char[] one = {'A','D','O','P','Q','R'};
	static char only = 'B';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			char[] first = st.nextToken().toCharArray();
			char[] second = st.nextToken().toCharArray();
			
			if(first.length != second.length) {
				System.out.println("#"+t+" "+"DIFF");
				continue;
			}
			
			boolean[] isSame = new boolean[10];
			
			//비교
			for (int i = 0; i < first.length; i++) {
				boolean[] isZero = {false,false};
				boolean[] isOne = {false,false};
				// zero 비교
				for (int j = 0; j < zero.length; j++) {
					if(zero[j] == first[i]) {
						isZero[0] = true;
					}
					if(zero[j] == second[i]) {
						isZero[1] = true;
					}
				}
				if(isZero[0] && isZero[1]) {
					isSame[i] = true;
					continue;
				}
				
				// one 비교
				for (int j = 0; j < one.length; j++) {
					if(one[j] == first[i]) {
						isOne[0] = true;
					}
					if(one[j] == second[i]) {
						isOne[1] = true;
					}
				}
				if(isOne[0] && isOne[1]) {
					isSame[i] = true;
					continue;
				}
				
				// B 비교
				if(first[i] == only && second[i] == only) {
					isSame[i] = true;
					continue;
				}
			}
			String result = "SAME";
			
			for (int i = 0; i < first.length; i++) {
				if(isSame[i] == false) {
					result = "DIFF";
					break;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
