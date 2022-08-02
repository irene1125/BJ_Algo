package algostudy;
import java.io.*;
import java.util.*;

public class BJ11399 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int total = 0;
        for(int i = 0; i<arr.length; i++) {
        	total += arr[i]*(N-i);
        }
        System.out.println(total);
	}

}
