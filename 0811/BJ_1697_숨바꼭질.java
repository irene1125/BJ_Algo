package algoStudy;
import java.io.*;
import java.util.*;

public class BJ_1697_숨바꼭질 {
	static int [] dx= {-1, 1, 2};
	static int [] road = new int[1000001]; // 수빈이가 갈 수 있는 직선거리

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N == K)
			System.out.println(0);
		else
			bfs(N, K);
		
	}
	static void bfs(int s, int des) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		road[s] = 1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 0; i<3; i++) {
				int nx;
				if(i == 2)
					nx = tmp*dx[i];
				else
					nx = tmp+dx[i];
				
				if(nx == des){
					System.out.print(road[tmp]);
					return;
				}
				if(nx>=0 && nx<road.length && road[nx] == 0) {
					q.add(nx);
					road[nx] = road[tmp]+1;
				}
			}
		}
 	}
}
