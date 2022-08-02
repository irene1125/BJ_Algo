package BJ;
import java.io.*;
import java.util.*;

public class bj2525 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int total = M+t;
		while(total >=60) {
			H += 1;
			total -= 60;
			if(H >= 24) {
				H -= 24;
			}
		}
		
		sb.append(H+" "+total);
		System.out.println(sb.toString());
	}

}
