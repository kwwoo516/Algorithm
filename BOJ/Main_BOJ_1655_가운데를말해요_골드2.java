
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//시간 384ms
//메모리 35392kb
public class Main_BOJ_1655_가운데를말해요_골드2 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqHead = new PriorityQueue<>();
		PriorityQueue<Integer> pqHalf = new PriorityQueue<>(Collections.reverseOrder());
		
		int num = Integer.parseInt(br.readLine());
		pqHalf.add(num);
		StringBuilder sb = new StringBuilder();
		sb.append(pqHalf.peek()).append("\n");
		
		for (int i = 0; i < N-1; i++) {
			int temp = Integer.parseInt(br.readLine());
			if((pqHalf.size() + pqHead.size())% 2 != 0) { // 홀				
				if(pqHalf.peek() < temp) {
					pqHead.add(temp);
				}else {
					pqHead.add(pqHalf.poll());
					pqHalf.add(temp);
				}
			}else { // 짝
				if(pqHead.peek() < temp) {
					pqHalf.add(pqHead.poll());
					pqHead.add(temp);
				}else {
					pqHalf.add(temp);
				}
			}
			sb.append(pqHalf.peek()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
