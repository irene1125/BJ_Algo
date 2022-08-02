package algostudy;
import java.io.*;
import java.util.*;

public class BJ11660 {
	static int [][] a_arr;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [][] arr = new int[N][N];
        a_arr = new int[N][N+1];
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	for(int j = 0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        	a_arr[i][1] = arr[i][0];
        	for(int k = 1; k<N; k++) {
        		a_arr[i][k+1] = a_arr[i][k]+arr[i][k];
        	}
        }
        
        for(int i = 0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	sb.append(getSum(x1, y1, x2, y2)).append("\n");
        	
        }
        System.out.println(sb.toString());

	}
	public static int getSum(int x1, int y1, int x2, int y2) {
		int sum = 0;
		
		for(int i = x1-1; i<x2; i++) {
			sum += (a_arr[i][y2]-a_arr[i][y1-1]);
		}
		return sum;
	}

}
