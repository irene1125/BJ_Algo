package BJ;
import java.io.*;
import java.util.*;

public class BJ11659 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 수열 크기
		int M = Integer.parseInt(st.nextToken()); // 수열 크기
		
		int [] arr = new int[N];
		int [] a_sum = new int[N+1];
		//a_sum[0] = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			a_sum[i+1] += a_sum[i]+arr[i];
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(a_sum[e]-a_sum[s-1]).append("\n");
			
		}
		System.out.print(sb.toString());
	}

}
