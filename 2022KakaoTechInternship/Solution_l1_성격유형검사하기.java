import java.util.*;

public class Solution_l1_성격유형검사하기 {
	   public String solution(String[] survey, int[] choices) {
	        StringBuilder sb = new StringBuilder();
	        Map<Character, Integer> res = new TreeMap<>();
	        
	        char [][] arr = new char[][] {{'R', 'T'},{'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
	        for(int i = 0; i<4; i++){
	            res.put(arr[i][0], 0);
	            res.put(arr[i][1], 0);
	        }
	        int loop = survey.length;

	        for(int i = 0; i<loop; i++){
	            int score = choices[i]-4;
	            if(score > 0) { // 양수면 뒤에 있는 문자에 diff만큼 점수 부여
	                char str = survey[i].charAt(1);
	                res.put(str, res.get(str)+score);
	              
	            }else if(score < 0) { // 음수면 앞에 있는 문자에 -diff만큼 점수 부여
	                char str = survey[i].charAt(0);
	                res.put(str, res.get(str)-score);
	            }
	        }


	        for(int i = 0; i<4; i++){
	            if(res.get(arr[i][0]) >= res.get(arr[i][1])) 
	                sb.append(arr[i][0]);
	            else sb.append(arr[i][1]);
	        }
	        return sb.toString();
	    }
}
