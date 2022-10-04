package homework;
import java.io.*;
import java.util.*;
public class Solution_5656_벽돌깨기_서울_20반_곽서현 {
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int N, W, H, min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int [][] map = new int[H][W];
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			dropCrush(0, map);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void dropCrush(int cnt, int [][] map) {
		
		if(cnt == N) {
			int res = getBlock(map);
			min = Math.min(min, res);
			return;
			
		}
		int [][] deepMap = new int[H][W];
		
		for(int y = 0; y<W; y++) {
			int x = 0;
			while(x<H && map[x][y] == 0) ++x;
			if(x == H) {
				dropCrush(cnt+1, map);
			}else {
				// 이전 배열 복사
				for(int i = 0; i<H; i++) {
					for(int j = 0; j<W; j++) {
						deepMap[i][j] = map[i][j];
					}
				}
				
				// 구슬 던지기
				goCrush(deepMap, x, y);
				
				dropBrick(deepMap);
				dropCrush(cnt+1, deepMap);
			}
		}
	}
	private static void dropBrick(int[][] deepMap) {
		for(int y = 0; y<W; y++) {
			Queue<Integer> b = new ArrayDeque<Integer>();
			int x = H-1;
			while(x >=0) {
				if(deepMap[x][y] > 0) {
					b.offer(deepMap[x][y]);
					deepMap[x][y] = 0;
				}x--;
			}
			x = H-1;
			while(!b.isEmpty()) {
				deepMap[x][y] = b.poll();
				x--;
			}
		}
		
	}
	private static void goCrush(int [][] deepMap, int x, int y) {
		Queue<int []> q = new ArrayDeque<int[]>();
		if(deepMap[x][y] > 1) q.offer(new int[] {x, y, deepMap[x][y]});
		
		deepMap[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			x = tmp[0]; y = tmp[1]; int c = tmp[2];
			
			for(int d = 0; d<4; d++) {
				int nx = x;
				int ny = y;
				for(int k = 1; k<c; k++) { // 해당 범위에 들어오는 블럭 crush
					nx +=dx[d];
					ny +=dy[d];
					if(nx>=0 && ny>=0 && nx<H && ny<W && deepMap[nx][ny] != 0) {
						if(deepMap[nx][ny] >1)
							q.offer(new int[] {nx,ny,deepMap[nx][ny]});
						deepMap[nx][ny] = 0;
					}
				}
			}
		}
	}
	private static int getBlock(int [][] map) {
		int cnt = 0;
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		return cnt;
	}

}
