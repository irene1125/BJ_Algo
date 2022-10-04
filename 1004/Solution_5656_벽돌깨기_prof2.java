
import java.io.*;
import java.util.*;
public class Solution_5656_벽돌깨기_prof2 {
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
			go(0, map);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	// 구슬던지기 게임
	private static boolean go(int cnt, int [][] map) {
		
		int result = getBlock(map);
		
		if(result == 0) {
			min = result;
			return true;
		}
		
		if(cnt == N) {
			int res = getBlock(map);
			min = Math.min(min, res);
			return false;
			
		}
		// 중복순열로 구슬 던지기
		int [][] newMap = new int[H][W];
		
		for(int c = 0; c<W; c++) {
			
			// 구슬에 맞는 시작벽돌 찾기
			int r = 0;
			while(r<H && map[r][c] == 0) ++r;
			if(r == H) { // 맞는 시작벽돌이 없음
				continue;
			}else { // 벽돌 찾음
				copy(map, newMap);
				// 제거될 벽돌 연쇄처리
				boomBFS(newMap, r, c);
				// 벽돌 중력 처리
				down(newMap);
				// 다음 구슬 던지기
				if(go(cnt+1, newMap)) 
					return true;
			}
			
		}
		return false;
		
	}
	static Stack<Integer> stack = new Stack<Integer>();
	private static void down(int[][] newMap) {
		// 윗행부터 남은 벽돌 스택에 넣기
		for(int c = 0; c<W; c++) {
			
			for(int r = 0; r<H; r++) {
				if(newMap[r][c] > 0) {
					stack.push(newMap[r][c]);
					newMap[r][c] = 0;
				}
			}
			int nr = H-1;
			while(!stack.isEmpty()) {
				newMap[nr--][c] = stack.pop();
			}
		}
		for(int c = 0; c<W; c++) {
			int r = H-1;
			while(r>0) {
				if(newMap[r][c] == 0) {
					int nr = r-1;
					while(nr > 0 && newMap[nr][c] == 0) nr--;
					newMap[r][c] = newMap[nr][c];
					newMap[nr][c] = 0;
				}--r;
			}
		}
	}
	private static void boomBFS(int[][] newMap, int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		
		// 1인 경우 주변에 영향을 주지 못하기 때문에 1보다 크면 큐에 넣음
		if(newMap[r][c] > 1) 
			q.offer(new Point(r, c, newMap[r][c]));
		
		newMap[r][c] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
						
			for(int d = 0; d<4; d++) {
				int nx = p.r;
				int ny = p.c;
				for(int k = 1; k<p.cnt; k++) { // 해당 범위에 들어오는 블럭 crush
					nx +=dx[d];
					ny +=dy[d];
					if(nx>=0 && ny>=0 && nx<H && ny<W && newMap[nx][ny] != 0) {
						// 초기 과정과 동일한 작업!!
						if(newMap[nx][ny] >1)
							q.offer(new Point(nx,ny,newMap[nx][ny]));
						newMap[nx][ny] = 0;
					}
				}
			}
		}
	}
	private static void copy(int[][] map, int[][] newMap) {
		// 이전 배열 복사
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				newMap[i][j] = map[i][j];
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
	static class Point{
		int r, c, cnt;
		public Point(int r, int c, int cnt) {
			this.c = c;
			this.r = r;
			this.cnt = cnt;
		}
	}

}
