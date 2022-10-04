import java.io.*;
import java.util.*;
public class Solution_4008_숫자만들기_서울_20반_곽서현 {
	// 순열문제
	static int N, min, max;
	static int [] op, nums;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			nums = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			
			stack= new Stack<>();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			dfs(0);
			
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		System.out.print(sb.toString());
	}
	private static void dfs(int depth) {
		if(depth == N-1) {
			findMinMax();
			return;
		}
		for(int i =0 ; i<4; i++) {
			if(op[i]>0) {
				op[i]--;
				stack.push(i);
				dfs(depth+1);
				stack.pop();
				op[i]++;
			}
		}
	}
	private static void findMinMax() {
		int ret = nums[0];
		
		for(int i = 0; i<stack.size(); i++) {
			int op = stack.get(i);
			if(op == 0) {
				ret += nums[i+1];
			}else if(op == 1) {
				ret -= nums[i+1];
			}else if(op == 2) {
				ret *=nums[i+1];
			}else
				ret /=nums[i+1];
		}
		min = Math.min(min,  ret);
		max = Math.max(max, ret);
		
	}

}
