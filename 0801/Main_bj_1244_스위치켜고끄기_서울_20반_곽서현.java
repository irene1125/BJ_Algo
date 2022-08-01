package homework;
import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기_서울_20반_곽서현 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] info = new int[N+1];
		
		st= new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++) {
			info[i] = Integer.parseInt(st.nextToken()); // 1 on 0 off
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int light_num = Integer.parseInt(st.nextToken());
			if(gender == 1) { // 남자
				for(int j =light_num; j<=N; j+=light_num) {
					info[j] = info[j] == 1 ? 0 : 1;
				}
				
			}else { // 여자
				int start= light_num;
				int end = light_num;
				for(int j =0; j<=light_num; j++) {
					if((light_num+j <= N) && (light_num-j > 0)&&(info[light_num+j] == info[light_num-j])) {
						start = light_num-j;
						end = light_num+j;
					}
					else
						break;
				}
				for(int k = start; k<=end; k++) {
					info[k] = info[k] ==1? 0: 1;
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			sb.append(info[i]+" ");
			if(i%20 == 0)
				sb.append("\n");
			
		}
			
		System.out.print(sb.toString());
	}

}
