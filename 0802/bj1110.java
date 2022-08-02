package BJ;
import java.io.*;
import java.util.*;

public class bj1110 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int copy = n;
        int count = 0;
        do {
        	n = ((n%10)*10)+(((n/10)+(n%10))%10);
        	count++;
        }while(copy!=n);
        System.out.println(count);
        br.close();
		
	}

}
