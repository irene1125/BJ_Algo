package algostudy;
import java.io.*;
import java.util.*;

public class BJ2630 {
	static int cnt_white, cnt_blue;

	static int N;
	static int [][] arr;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        findSquare(0, 0, N);
        sb.append(cnt_white+"\n"+cnt_blue);
        System.out.print(sb.toString());
	}
	public static void findSquare(int r, int c, int n) {
		if(colorCheck(r, c, n)) {
			if(arr[r][c] == 0)
				cnt_white++;
			else
				cnt_blue++;
			return;
		}
		int nSize = n/2;
		findSquare(r, c, nSize); //2사분면
		findSquare(r, c+nSize, nSize); // 1사분면
		findSquare(r+nSize, c, nSize); //3사분면
		findSquare(r+nSize, c+nSize, nSize); //4사분면
		
	}
	public static boolean colorCheck(int r, int c, int size) {
		int color = arr[r][c]; // 첫번째 원소 기준으로 체크
		
		for(int i = r ; i<r+size; i++) {
			for(int j = c; j<c+size; j++) {
				if(arr[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
