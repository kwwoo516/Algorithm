import java.util.ArrayList;
import java.util.Scanner;

public class Solution_sw_5644_무선충전 {
	
	static int T;
	static int N = 10;
	static int M, A;
	static int[][] map;
	static int[] manA;
	static int[] manB;
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	static int[][] ap;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			M = sc.nextInt();
			A = sc.nextInt();
			manA = new int[M];
			manB = new int[M];
			for (int i = 0; i < M; i++) {
				manA[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				manB[i] = sc.nextInt();
			}
			
			ap = new int[A][4];
			for (int i = 0; i < A; i++) {
				ap[i][0] = sc.nextInt();
				ap[i][1] = sc.nextInt();
				ap[i][2] = sc.nextInt();
				ap[i][3] = sc.nextInt();
			}
			
			max = 0;
			int ar = 1, ac = 1;
			int br = N, bc = N;
			int Acharge = 0;
			int Bcharge = 0;
			int charge = 0;
			
			for (int time = 0; time < M; time++) {
				ArrayList<Integer> connectA = new ArrayList<>();
				ArrayList<Integer> connectB = new ArrayList<>();
				boolean doubleAc = false;
				
				//무선충전 범위 탐색
				for (int j = 0; j < A; j++) {
					boolean aAccess = false;
					boolean bAccess = false;
					//범위 안의 충전기를 리스트에 넣음
					if(inDistance(ar, ac, j)) {
						aAccess = true; 
						connectA.add(j);
					}
					if(inDistance(br, bc, j)) {
						bAccess = true; 
						connectB.add(j);
					}
					
					//한 충전기 범위 안에 두 사람 모두 있을때
					if(aAccess && bAccess) {
						doubleAc = true;
					}
				}
				
				if(doubleAc) {
					// 둘 다 같은 범위에 있고 한개의 BC만 속해있을 때
					if(connectA.size() == 1 && connectB.size() == 1) {
						Acharge += ap[connectA.get(0)][3]/2;
						Bcharge += ap[connectB.get(0)][3]/2;
						//System.out.println("time "+time+ " ab cnt "+ap[connectA.get(0)][3]);
					//A는 2개이상, B는 1개만 속해있을 때
					}else if(connectA.size() > 1 && connectB.size() == 1) {
						int temp = connectB.get(0);
						
						for (int j = 0; j < connectA.size(); j++) {
							//b의 것과 같은 충전기라면
							if(connectA.get(j) == temp) {
								connectA.remove(j);
								break;
							}
						}
						int big = connectA.get(0);
						for (int j = 0; j < connectA.size(); j++) {
							if(ap[big][3] < ap[connectA.get(j)][3]) {
								big = connectA.get(j);
							}
						}
						Bcharge += ap[temp][3];
						//System.out.println("time "+time+ " bcnt "+ap[temp][3]);
						Acharge += ap[big][3];
						//System.out.println("time "+time+ " acnt "+ap[big][3]);
					//B는 2개이상, A는 1개만 속해있을 때
					}else if(connectA.size() == 1 && connectB.size() > 1) {
						int temp = connectA.get(0);
						for (int j = 0; j < connectB.size(); j++) {
							if(connectB.get(j) == temp) {
								connectB.remove(j);
								break;
							}
						}
						int big = connectB.get(0);
						for (int j = 0; j < connectB.size(); j++) {
							if(ap[big][3] < ap[connectB.get(j)][3]) {
								big = connectB.get(j);
							}
						}
						Acharge += ap[temp][3];
						//System.out.println("time "+time+ " acnt "+ap[temp][3]);
						Bcharge += ap[big][3];
						//System.out.println("time "+time+ " bcnt "+ap[big][3]);
					// 둘 다 2개이상 속해있을 때
					}else if(connectA.size() > 1 && connectB.size() > 1) {
						int abig1 = connectA.get(0);
						int bbig1 = connectB.get(0);
						//a의 최대 충전 구하기
						int idxa = 0;
						for (int j = 0; j < connectA.size(); j++) {
							if(ap[abig1][3] < ap[connectA.get(j)][3]) {
								abig1 = connectA.get(j);
								idxa = j;
							}
						}
						connectA.remove(idxa);
						int abig2 = connectA.get(0);
						//a의 두번째 큰 충전
						for (int i = 0; i < connectA.size(); i++) {
							if(ap[abig2][3] < ap[connectA.get(i)][3]) {
								abig2 = connectA.get(i);
							}
						}
						// b의 최대 충전 구하기
						int idxb = 0;
						for (int j = 0; j < connectA.size(); j++) {
							if(ap[bbig1][3] < ap[connectA.get(j)][3]) {
								bbig1 = connectA.get(j);
								idxb = j;
							}
						}
						connectB.remove(idxb);
						//b의 두번째 큰 충전
						int bbig2 = connectB.get(0);
						for (int j = 0; j < connectA.size(); j++) {
							if(ap[bbig2][3] < ap[connectA.get(j)][3]) {
								bbig2 = connectA.get(j);
							}
						}
						
						if(abig1 == bbig1) {
							if(ap[abig1][3] + ap[bbig2][3] > ap[abig2][3] + ap[bbig1][3]) {
								Acharge += ap[abig1][3];
								Bcharge += ap[bbig2][3];
							}else {
								Acharge += ap[abig2][3];
								Bcharge += ap[bbig1][3];
							}
						}else {
							Acharge += ap[abig1][3];
							Bcharge += ap[bbig1][3];
						}
					}
				}else {
					//A
					if(!connectA.isEmpty()) {
						if(connectA.size()>1) {
							int big = 0;
							for (int j = 0; j < connectA.size(); j++) {
								if(ap[big][3] < ap[connectA.get(j)][3]) {
									big = connectA.get(j);
								}
							}
							Acharge += ap[big][3];
							//System.out.println("time "+time+ " acnt "+ap[big][3]);
						}else {
							Acharge += ap[connectA.get(0)][3];
							//System.out.println("time "+time+ " acnt "+ap[connectA.get(0)][3]);
						}
					}
					//B
					if(!connectB.isEmpty()) {
						if(connectB.size()>1) {
							int big = 0;
							for (int j = 0; j < connectB.size(); j++) {
								if(ap[big][3] < ap[connectB.get(j)][3]) {
									big = connectB.get(j);
								}
							}
							Bcharge += ap[big][3];
							//System.out.println("time "+time+ " bcnt "+ap[big][3]);
						}else {
							Bcharge += ap[connectB.get(0)][3];
							//System.out.println("time "+time+ " bcnt "+ap[connectB.get(0)][3]);
						}
					}
				}
				
				if(time<M) {
					ar += dr[manA[time]];
					ac += dc[manA[time]];
					br += dr[manB[time]];
					bc += dc[manB[time]];
				}
				//System.out.println(time +" arac = "+ar+" "+ac +" acnt : "+Acharge + " bcnt " + Bcharge);
			}
			charge = Acharge + Bcharge;
			
			System.out.println("#"+t+" "+charge);
		}
	}
	
	public static boolean inDistance(int r, int c, int j) {
		int dis = Math.abs(c-ap[j][0]) + Math.abs(r-ap[j][1]);
		if(dis <= ap[j][2]) {
			return true;
		}
		return false;
	}

}
