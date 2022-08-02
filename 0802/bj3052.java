package BJ;
import java.io.*;
import java.util.*;

public class bj3052 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int [] arr = new int[42];
        for(int i = 0; i<10; i++) {
        	int N = Integer.parseInt(br.readLine());
        	arr[N%42]++;
        }
        Arrays.sort(arr);
        int idx = 0;
        for(int i = 0; i<arr.length; i++) {
        	if(arr[i] != 0) {
        		idx = i;
        		break;
        	}	
        }
        System.out.println(arr.length-idx);
	}

}
