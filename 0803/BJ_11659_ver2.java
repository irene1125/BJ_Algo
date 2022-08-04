package BJ;
import java.io.*;
import java.util.*;

public class BJ_11659_ver2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 수열 크기
		int M = Integer.parseInt(st.nextToken()); // 수열 크기
		
		int [] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(arr[e]-arr[s-1]).append("\n");
			
		}
		System.out.print(sb.toString());
	}

}
