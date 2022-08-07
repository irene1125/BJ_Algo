import java.io.*;
import java.util.*;
/*
 * for-loop 시간초과뜸
 * stack 사용해야 풀 수 있는 문제
 */
public class BJ17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 수열 크기
		int [] arr = new int[N];
		int [] ans = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>(); // 오큰수 인덱스 저장할 스택
		stack.push(0); // 초기화
	
		
		for(int i = 1; i<N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;

		}
		for(int i: ans) {
			sb.append(i+" ");
		}
		System.out.print(sb.toString());
	}

}