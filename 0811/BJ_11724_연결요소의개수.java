package algoStudy;
import java.io.*;
import java.util.*;

public class BJ_11724_연결요소의개수 {
	static boolean [] isVisited;
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 개수
		int M = Integer.parseInt(st.nextToken()); // 엣지의 수
		isVisited = new boolean[N+1];
		arr = new ArrayList<>();
		
		for(int i = 0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a); // 양방향 그래프이니까!
		}
		
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			if(!isVisited[i]) {
				cnt++;
				DFS(i);
			}
		}
		System.out.println(cnt);
	}
	static void DFS(int n) {
		if(isVisited[n]) return;
		
		isVisited[n] = true;
		for(int i : arr.get(n)) {
			if(!isVisited[i]) {
				DFS(i);
			}
		}
	}
}
