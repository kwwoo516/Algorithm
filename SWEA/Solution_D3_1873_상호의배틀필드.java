import java.util.Scanner;

public class Solution_D3_1873_2 {
	
	static int T;
	static int H;
	static int W;
	static char[][] map;
	static int inputL;
	static char[] input;
	// 동서남북
	static int d;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static char[] dw = {'>','<','v','^'};
	static int r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			for (int h = 0; h < H; h++) {
				char[] ch = sc.next().toCharArray();
				for (int w = 0; w < W; w++) {
					map[h][w] = ch[w];
					if(map[h][w] == '>') {
						d = 0;
						r = h;
						c = w;
					}else if(map[h][w] == '<') {
						d = 1;
						r = h;
						c = w;
					}else if(map[h][w] == 'v') {
						d = 2;
						r = h;
						c = w;
					}else if(map[h][w] == '^') {
						d = 3;
						r = h;
						c = w;
					}
				}
			}
			inputL = sc.nextInt();
			String s = sc.next();
			input = s.toCharArray();
			
			for (char in : input) {
				if(in == 'S') {
					shoot();
				}else if(in == 'R') {
					move(0);
				}else if(in == 'L') {
					move(1);
				}else if(in == 'D') {
					move(2);
				}else if(in == 'U') {
					move(3);
				}
			}
			
			System.out.println("#"+(t+1)+" "+String.valueOf(map[0]));
			for (int i = 1; i < H; i++) {
				System.out.println(String.valueOf(map[i]));
			}
		}
	}

	private static void shoot() {
		int nr = r;
		int nc = c;
		
		//shoot
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
				break;
			}
			
			if(map[nr][nc] == '.' || map[nr][nc] == '-') {
				continue;
			}else if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				break;
			}else if(map[nr][nc] == '#') {
				break;
			}
		}
	}

	private static void move(int i) {
		// 방향 전환
		d = i; // 방향 저장
		int nr = r + dr[i];
		int nc = c + dc[i];
		// 맵을 벗어난다면
		if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
			map[r][c] = dw[i];
			return;
		}
		if(map[nr][nc] == '.') {
			//이전위치
			map[r][c] = '.';
			//이동한 위치
			map[nr][nc] = dw[i];
			r = nr;
			c = nc;
		}else {
			map[r][c] = dw[i];
		}
	}
}
