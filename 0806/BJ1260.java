package algoStudy;
import java.io.*;
import java.util.*;
public class BJ1260 {
	static boolean isVisited[];
	static String ans ="";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N+1];
		
		for(int i = 0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		DFS(arr, 1);
		sb.append(ans).append("\n");
		isVisited = new boolean[N+1];
		ans = "";
		BFS(arr, 1);
	
		sb.append(ans).append("\n");
		System.out.println(sb.toString());
	}
	static void DFS(ArrayList<ArrayList<Integer>> arr, int idx) {
		isVisited[idx] = true;
		ans += idx+" ";
		for(int i : arr.get(idx)) {
			if(!isVisited[i])
				DFS(arr, i);
		}
		
	}
	static void BFS(ArrayList<ArrayList<Integer>> arr, int idx) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		isVisited[idx] = true;
		q.add(idx);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			ans += tmp+" ";
			for(int t: arr.get(tmp)) {
				if(!isVisited[t]) {
					isVisited[t] = true;
					q.add(t);
				}
			}
		}
		
	}
}
