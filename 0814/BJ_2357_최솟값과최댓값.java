package algoStudy;
import java.io.*;
import java.util.*;
public class BJ_2357_최솟값과최댓값 {
	static int size;
	static int[] treeMax;
	static int[] treeMin;
	static int max, min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		size = 1;
		while(size<N) {
			size*=2;
		}
		int [] nums = new int[N+1];
		treeMax = new int[2*size+1];
		treeMin = new int[2*size+1];
		
		for(int i = 1; i<=N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i<=N; i++) {
			updateMaxTree(i, nums[i]);
			updateMinTree(i, nums[i]);
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			max = -1;
			min = 1_000_000_000;
			query(a, b);
			sb.append(min+" "+max).append("\n");
		}
		System.out.print(sb.toString());
	}
	static void updateMaxTree(int idx, int num) { // 트리 갱신
		idx = size+idx-1;
		treeMax[idx] = num;
		
		idx /=2;
		while(idx >0) {
			treeMax[idx] = Math.max(treeMax[idx*2], treeMax[idx*2+1]);
			idx/=2;
		}
	}
	static void updateMinTree(int idx, int num) { // 트리 갱신
		idx = size+idx-1;
		treeMin[idx] = num;
		
		idx /=2;
		while(idx >0) {
			if(treeMin[idx*2] != 0 && treeMin[idx*2+1]!= 0) {
				treeMin[idx] = Math.min(treeMin[idx*2], treeMin[idx*2+1]);
			}else {
				treeMin[idx] = Math.max(treeMin[idx*2], treeMin[idx*2+1]);
			}
			idx/=2;
		}
	}
	static void query(int s, int e) {
		s = size+s-1;
		e = size+e-1;
		while(s <= e) {
			if(s%2 == 1) {
				max = Math.max(treeMax[s], max);
				min = Math.min(treeMin[s], min);
			}
			if(e%2 == 0) {
				max = Math.max(treeMax[e], max);
				min = Math.min(treeMin[e], min);
			}
			s =(s+1)/2;
			e =(e-1)/2;
		}
	}
}
