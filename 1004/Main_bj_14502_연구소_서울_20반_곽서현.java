package homework;
import java.io.*;
import java.util.*;
public class Main_bj_14502_연구소_서울_20반_곽서현 {
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int [][] map;
	static int ans = Integer.MIN_VALUE;
	static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st  = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		int [][] v_map = new int[N][M];
		for(int i = 0 ; i<N; i++) {
			for(int j = 0; j<M; j++) {
				v_map[i][j] = map[i][j];
				if(v_map[i][j] == 2) q.add(new int[] {i, j});
			}
		}
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			int x = tmp[0]; int y = tmp[1];
			
			for(int d =0; d<4; d++) {
				int nx= x+dx[d];
				int ny = y+dy[d];
				if(nx >= 0 && ny>= 0 && nx<N && ny<M ) {
					if(v_map[nx][ny] == 0) {
						v_map[nx][ny] =2 ;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		cntSafeZone(v_map);
	}
	private static void cntSafeZone(int[][] v_map) {
		int cnt = 0;
		for(int i = 0 ; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(v_map[i][j] == 0) cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}
	

}
