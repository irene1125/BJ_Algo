package BJ;
import java.io.*;
import java.util.*;

public class bj2577 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        long total = A*B*C;
        
        String s = String.valueOf(total);
        int[] num = new int[10];
        for(int i = 0; i<s.length(); i++) {
        	num[s.charAt(i)-'0']++;
        }
        for(int i: num) {
        	sb.append(i+"\n");
        }
		System.out.println(sb.toString());
	}

}
