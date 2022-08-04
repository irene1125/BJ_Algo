package algoStudy;
import java.io.*;
import java.util.*;
public class BJ2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i =1; i<=N; i++) { // queue 초기화
			q.add(i);
		}
		
		while(q.size() != 1) { // 큐 사이즈가 1이 될때까지
			q.poll(); // 맨 위 버림
			
			int tmp = q.poll(); // 그 다음 위 뽑아서
			q.add(tmp); // 넣기
			
		}
		System.out.print(q.peek());
	}
}
