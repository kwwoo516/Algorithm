import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1541_잃어버린괄호_실버2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] list = str.split("-");
		int sum = 0;
		String[] pluslist = list[0].split("\\+");
		for(String temp : pluslist) {
			sum += Integer.parseInt(temp);
		}
		if(list.length > 0) {
			for (int i = 1; i < list.length; i++) {
				String[] temp = list[i].split("\\+");
				int minus = 0;
				for (String t : temp) {
					minus += Integer.parseInt(t);
				}
				sum -= minus;
			}
		}
		
		System.out.println(sum);
	}
}
