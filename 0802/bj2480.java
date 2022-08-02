package BJ;
import java.io.*;
import java.util.*;

public class bj2480 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		if(A==B) {
			if(B == C) cnt = 3;
			else
				cnt = 2;
		}else if(A == C) {
			if(B == C) cnt = 3;
			else
				cnt = 2;
		}else if(B == C) {
			if(A == C) cnt = 3;
			else  cnt = 2;
		}
		int t = 0;
		switch(cnt) {
		case 1:
			int max = A>(t =(B>C ? B : C)) ? A: t;
			System.out.println(max*100);
			break;
		case 2:
			if(A == B) t = A;
			else t = C;
			System.out.println(1000+t*100);
			break;
		case 3:
			System.out.println(10000+A*1000);
			break;
		}
	}

}
