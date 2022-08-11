package algoStudy;
import java.io.*;
import java.util.*;

public class BJ_12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] a = new int[N];
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		arr[0] = a[0];
		int idx = 1;

		for(int i = 1; i<N; i++) {
			
			int tmp = a[i];
			
			if(arr[idx -1] < tmp) {
				idx++;
				arr[idx-1] = tmp;
			}else {
				int l = 0;
				int r = idx;
				
				while(l<r) {
					int mid = (l+r)/2;
					
					if(arr[mid] < tmp) {
						l = mid+1;
					}
					else
						r = mid;
				}
				arr[l] = tmp;
			}
		}
		int cnt = 0;
		for(int i: arr) {
			if(i != 0)
				cnt++;
			else if(i == 0)
				break;
		}
		System.out.println(cnt);
	
	}

}
