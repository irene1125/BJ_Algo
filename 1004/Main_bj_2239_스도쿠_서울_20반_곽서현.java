package homework;
import java.io.*;
import java.util.*;

public class Main_bj_2239_스도쿠_서울_20반_곽서현 {
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y =y;
		}
	}
	static int [][] arr;
	static ArrayList<Point> parr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[9][9];
		parr = new ArrayList<>();
		for(int i = 0; i<9; i++) {
			char [] c = br.readLine().toCharArray();
			for(int j = 0; j<9; j++) {
				arr[i][j] = c[j]-'0';
				if(arr[i][j] == 0) {
					parr.add(new Point(i, j));
				}
			}
		}
		makeSedoku(0);
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				sb.append(arr[i][j]);
			}sb.append("\n");
		}
		System.out.print(sb.toString());

	}
	private static boolean makeSedoku(int cnt) {

		if(parr.size() == cnt) {
			return true;
		}

		int x = parr.get(cnt).x;
		int y = parr.get(cnt).y;
		

		for(int i = 1; i<10; i++) {
			arr[x][y] = i;
			if(isValid(x, y) &&makeSedoku(cnt+1))
				return true;
				
		}
		arr[x][y] = 0;
		return false;
			
	}
	private static boolean isValid(int x, int y) {
		// 가로 세로 3*3 칸 중 하나라도 같은 값이 있다면 false를 반환한다.
		
		//같은 행
		for(int j = 0; j<9; j++) {
			if(j != y && arr[x][j] == arr[x][y]) {
				return false;
			}
		}
		//같은 열
		for(int i = 0; i<9; i++) {
			if(i != x && arr[i][y] == arr[x][y] ) {
				return false;
			}
		}
		//포함된 사각형
		//그 칸의 첫 번째 위치를 알아야 한다. 
		// i를 3으로 나눈 몫에 3을 다시 곱하면 첫번째 위치가 된다.
		int sx = (x/3) *3;
		int sy = (y/3) *3;
			
		for(int r = sx; r<sx+3; r++) {
			for(int c = sy; c<sy+3; c++) {
				if(r!=x && c!=y && arr[r][c] == arr[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

}
