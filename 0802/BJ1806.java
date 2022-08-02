package algostudy;
import java.io.*;
import java.util.*;

public class BJ1806 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int S = Integer.parseInt(st.nextToken()); // 합
        
        int [] num = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        int min_len = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        int total = 0;
        
		while(s <= N && e <= N) {
			if(total >= S && min_len > e-s) min_len = e-s;
			
			if(total < S) total += num[e++];
			else total -= num[s++];
		}
		if(min_len == Integer.MAX_VALUE) 
			System.out.print("0");
		else 
			System.out.print(min_len);
	}

}
