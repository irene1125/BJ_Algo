import java.io.*;
import java.util.*;
public class Solution_d5_7793_오나의여신님_서울_20반_곽서현 {
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static char [][] map;
	static int N, M, ans;
	static Queue<int[]> evil, q;
	static boolean flag;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			evil = new ArrayDeque<int[]>();
			q = new ArrayDeque<int[]>();
			
			for(int i = 0; i<N; i++) {
				char [] c = br.readLine().toCharArray();
				for(int j = 0; j<M; j++) {
					map[i][j] = c[j];
					if(map[i][j] == 'S') q.offer(new int[] {i, j});
					if(map[i][j] == '*') evil.offer(new int[] {i, j});
				}
			}
			ans = 0;
			bfs();
			if(!flag) sb.append("#"+tc+" GAME OVER").append("\n");
			else sb.append("#"+tc+" "+ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static void bfs() {
		flag = false;
		int l = 0;
		while(true) {
			l = evil.size();
			for(int i = 0; i<l; i++) {
				int [] tmp = evil.poll();
				int x = tmp[0]; int y = tmp[1];
				for(int d = 0 ; d<4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx>= 0 && ny>=0 && nx<N && ny<M && (map[nx][ny] == '.' || map[nx][ny] == 'S') ) {
						map[nx][ny] = '*';
						evil.offer(new int[] {nx, ny});
					}
				}
				
			}
			l = q.size();
			for(int i = 0; i<l; i++) {
				int [] tmp = q.poll();
				int x = tmp[0]; int y = tmp[1];
				if(map[x][y] == 'D') {
					flag = true;
					break;
				}
				for(int d = 0 ; d<4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx>= 0 && ny>=0 && nx<N && ny<M && (map[nx][ny] == '.' || map[nx][ny] == 'D') ) {
						if(map[nx][ny] !='D') map[nx][ny] = 'S';
						q.offer(new int[] {nx, ny});
					}
				}
				
			}
			// 도착했거나 사람이 갈 곳이 없으면 멈춤
			if(flag || q.isEmpty()) break;
			ans++;
		}
		
	}

}
