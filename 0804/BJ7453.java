package algoStudy;
import java.io.*;
import java.util.*;

public class BJ7453 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		long cnt = 0;
		
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		int [] B = new int[N];
		int [] C = new int[N];
		int [] D = new int[N];
		//int [][] arr = new int[4][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());

		}
		int [] arr1 = new int[N*N];
		int [] arr2 = new int[N*N];
		
		int idx = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				arr1[idx] = A[i]+B[j];
				arr2[idx] = C[i]+D[j];
				idx++;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		
		
		int p1 = 0;
		int p2 = arr2.length-1;
		
		while(p1 <arr1.length && p2 >=0) {
			int sum = arr1[p1]+ arr2[p2];
			int a = 1; int b = 1;
			
			if(sum == 0) {
				while(p1 <= arr1.length-2 && (arr1[p1] == arr1[p1+1])) {
					p1++;
					a++; // 중복 개수
				}
				while(p2 >= 1 && (arr2[p2] == arr2[p2-1])) {
					p2--;
					b++; // 중복 개수
				}cnt += (long) a*b;
			} 
			if(sum < 0)
				p1++;
			else
				p2--;
		}
		
		System.out.println(cnt);
	}

}
