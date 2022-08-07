import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;
public class BJ_14889_스타트와링크 {
	static int N;
	static int [][] arr;
	static boolean [] isSelected;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		isSelected = new boolean[N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(1, 0);
		System.out.print(Min);
	}
	static void check(int idx, int d) {
		if(d == N/2) {
			diff();
			return;
		}
		for(int i = idx; i<=N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				check(i+1, d+1);
				isSelected[i] = false;
			}
		}
	}
	static void diff() {
		int s_score = 0;
		int l_score = 0;
		
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				if(isSelected[i] && isSelected[j]) {
					s_score += arr[i][j]+arr[j][i];
				}
				else if(!(isSelected[i]) && !(isSelected[j])) {
					l_score += arr[i][j]+arr[j][i];
				}
			}
		}
		int val = Math.abs(s_score - l_score);
		
		if(val == 0) {
			System.out.print(0);
			System.exit(0);
		}
		Min = Math.min(val, Min);
	}
}
