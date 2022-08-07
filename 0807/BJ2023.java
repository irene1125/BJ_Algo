import java.io.*;
import java.util.*;

public class BJ2023 {
	static String [] nextNum = {"1", "3", "7", "9"}; // 2의배수, 5의 배수는 소수가 될 수 없음
	static StringBuilder sb= new StringBuilder();
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String [] alwaysPrime = {"2", "3", "5","7"};
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<4; i++) {
			makePrime(alwaysPrime[i], 1);
		}
		System.out.println(sb.toString());
		
	}
	static void makePrime(String s, int cnt) {
		
		if(cnt == N) {
			sb.append(s+"\n");
			return;
		}
		
		for(int i = 0; i<4; i++) {
			if(isPrime(s+nextNum[i]))
				makePrime(s+nextNum[i], cnt+1);
		}
	}
	static boolean isPrime(String s) {
		
		int tmp = Integer.parseInt(s);
		
		for(int i = 2; i<Math.sqrt(tmp); i++) {
			if(tmp % i == 0) return false;
		}
		return true;
	}
}
