package homework;

import java.util.*;
import java.io.*;

public class Main_bj_4485_녹색옷입은애가젤다지_서울_20반_곽서현 {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static boolean visit[][];
	static int map[][];
	static int size[][];

	private static final int INF = Integer.MAX_VALUE / 4;
	static int N, nowX, nowY;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int size;

		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int count = 1;

		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			visit = new boolean[N][N];
			size = new int[N][N];

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
		
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					size[i][j] = INF;
				}
			}

			BFS(0, 0, map[0][0]);
			sb.append("Problem " + count + ": " + size[N-1][N-1]).append('\n');
			count++;
		}

		System.out.println(sb);

	} 

	static void BFS(int x, int y, int roopy) {
		PriorityQueue<Node> q= new PriorityQueue<>();
		visit[x][y] = true;
		q.offer(new Node(x, y, roopy));

		while( !q.isEmpty() ) {
	
			Node node = q.poll();

			for(int i=0; i<4; i++) {
				nowX = node.x + dx[i];
				nowY = node.y + dy[i];

				if( nowX >= 0 && nowY >= 0 && nowX < N && nowY < N && !visit[nowX][nowY] && size[nowX][nowY] > (map[nowX][nowY] + node.size) ) {
					size[nowX][nowY] = map[nowX][nowY] + node.size;
					visit[nowX][nowY] = true;
					q.offer( new Node( nowX, nowY, size[nowX][nowY] ));
				}

			}
		}

	} 
} 