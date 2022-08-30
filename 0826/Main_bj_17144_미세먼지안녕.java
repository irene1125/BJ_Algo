package homework;
import java.io.*;
import java.util.*;
public class Main_bj_17144_미세먼지안녕_서울_20반_곽서현 {
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int R, C, cx1 = -1, cx2= -1;
	static int [][] map, dust;
	static int res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(cx1 == -1) cx1 = i;
					cx2 = i;
				}
			}
		}

		
		for(int i = 0; i<T; i++) {
			dust = new int[R][C];
			res = 0;
			cleaner();
		}
		System.out.println(res);
	}

	static void cleaner() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] > 0) {
					int t = map[i][j]/5;
					int cnt = 0;
					for(int d = 0; d<4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx >= 0 && nx<R && ny>=0 && ny<C && map[nx][ny] != -1) {
							cnt++;
							dust[nx][ny] += t;
						}
					}
					map[i][j] -= cnt*t;
					
 				}
			}
		}
		for(int i =0 ; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(dust[i][j] != 0) {
					map[i][j] += dust[i][j];
				}
			}
		}
		rotateMap1(0, cx1, 0,C-1); // 반시계회전
		rotateMap2(cx2, R-1, 0,C-1); // 시계회전
		
		cntDust();

	}

	static void cntDust() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if((i == cx1 && j == 0) || ((i == cx2) && j == 0)) continue;
				res+=map[i][j];
			}
		}
	}

	static void rotateMap1(int x1, int x2, int y1, int y2) {
		
		int [] tmp = new int[3];
		tmp[0] = map[x1][y1];
		tmp[1] = map[x2][y1];
		tmp[2] = map[x2][y2];
		// 왼쪽으로 밀기
		for(int i = y1; i<y2; i++) {
			map[x1][i] = map[x1][i+1];
		}
		// 아래로 밀기
		for(int i = x2-1; i>x1; i--) {
			if(i == x1+1) map[i][y1] = tmp[0];
			else map[i][y1] = map[i-1][y1];
		}
		// 오른쪽으로 밀기
		for(int i = y2; i>y1+1; i--) {
			//if(i == y1+1) map[x2][i] = tmp[1];
			map[x2][i] =map[x2][i-1];
		}
		map[x2][y1+1] = 0;
		// 위로 밀기
		for(int i = x1; i<x2; i++) {
			if(i == x2-1) map[i][y2] = tmp[2];
			else map[i][y2] = map[i+1][y2];
		}
	}
	static void rotateMap2(int x1, int x2, int y1, int y2) {
		
		int [] tmp = new int[3];
		tmp[0] = map[x1][y2];
		tmp[1] = map[x2][y2];
		tmp[2] = map[x1][y2];
		// 위로 밀기
		for(int i = x1+1; i<x2; i++) {
			if(i == x2-1) map[i][y1] = tmp[2];
			map[i][y1] = map[i+1][y1];
		}
		// 왼쪽으로 밀기
		for(int i = y1; i<y2; i++) {
			if(i == y2-1) map[x2][i] = tmp[1];
			map[x2][i] = map[x2][i+1];
		}
		// 아래로 밀기
		for(int i = x2; i>x1; i--) {
			if(i == x1+1) map[i][y2] = tmp[0];
			else map[i][y2] = map[i-1][y2];
		}
		// 오른쪽으로 밀기
		for(int i = y2; i>y1+1; i--) {
			map[x1][i] =map[x1][i-1];
		}
		map[x1][y1+1] = 0;
	}
}
