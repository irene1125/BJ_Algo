package algoStudy;

import java.io.*;
import java.util.*;
/*
 * 현재 위치를 청소한다.
 * 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
 * 	1.	왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 * 	2.	왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 * 	3.	네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
 * 	4.	네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 */
public class BJ_14503_로봇청소기 {
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};// 북동남서
	static int N, M;
	static int [][] map;
	static int cnt = 1;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 시작 x
		int y = Integer.parseInt(st.nextToken()); // 시작 y
		int d = Integer.parseInt(st.nextToken()); // 바라보는 방향
		
		for(int i = 0; i<N; i++) { // 빈칸 0 벽 1
			// 현재 상태 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		startRobo(x, y, d);
		
		System.out.print(cnt);
		
	}

	public static void startRobo(int x, int y, int d) {

		map[x][y] = -1;
		
		for(int i = 0; i<4; i++) {
			
			d = (d+3) % 4;
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(map[nx][ny] == 0 && CheckRange(nx, ny)) { // 벽이 아니고, 범위 확인
				
				cnt++;
				startRobo(nx, ny, d);
				
				return;
			}

		}
		// back 해야하는 경우 
		int tmpd = (d+2) % 4;
		int tmpx = x+dx[tmpd];
		int tmpy = y+dy[tmpd];
		
		if(CheckRange(tmpx,tmpy) && map[tmpx][tmpy] != 1) { // 벽이 아니고, 범위 맞으면 후진하도록 설정

			startRobo(tmpx, tmpy, d);
		}
	}
	public static boolean CheckRange(int nx, int ny) {
		if(nx>=0 && nx<N&& ny>=0 && ny <M) 
			return true;
		return false;
	}

}
