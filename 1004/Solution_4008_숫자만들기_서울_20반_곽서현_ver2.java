import java.io.*;
import java.util.*;
public class Solution_4008_숫자만들기_서울_20반_곽서현_ver2 {
	static int N;
	static int[] operators, numbers;
	static int max, min;
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
 
			operators = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}
 
			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(1, numbers[0]);
			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	static void dfs(int depth, int sum) {
		if(depth >= N) {
			if(sum > max) max = sum;
			if(sum < min) min = sum;
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(operators[i] > 0) {
				operators[i] -= 1;
				if(i == 0)			dfs(depth + 1, sum + numbers[depth]);
				else if(i == 1) 	dfs(depth + 1, sum - numbers[depth]);
				else if(i == 2) 	dfs(depth + 1, sum * numbers[depth]);
				else				dfs(depth + 1, sum / numbers[depth]);	
				operators[i] += 1;
			}
		}
	}
}