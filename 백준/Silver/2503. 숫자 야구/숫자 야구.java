import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	boolean[] check = new boolean[988];
    	
    	for(int i=123; i<= 987; i++) {
    		String num = String.valueOf(i);
    		
    		if(num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0') continue; // 숫자에 0 인됨
    		if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) continue; // 3개의 숫자가 겹쳐도 안됨
    	    check[i] = true;	
    	}
    	
    	for(int i=0; i<N; i++) {
    		
    		st = new StringTokenizer(br.readLine());
    		int num = Integer.parseInt(st.nextToken()); // 입력 숫자
    		int s = Integer.parseInt(st.nextToken()); // 스트라이크
    		int b = Integer.parseInt(st.nextToken()); // 볼
    		
    		for(int a=123; a <= 987; a++) {
    			if(check[a]) { // 정답일 수 있는 수라면 탐색
    				
    				int sn = 0;
    				int bn = 0;
    				
    				// 입력 받은 숫자
    				for(int one=0; one<3; one++) {
    					char num_split = Integer.toString(num).charAt(one);
    					
    					// 정답일 수 있는 숫자
    					for(int two=0; two<3; two++) {
    						char a_split = Integer.toString(a).charAt(two);
    						
    						if(num_split == a_split && one == two) sn++; // 둘의 숫자가 같으면서 위치도 같다면 스트라이크
    						else if(num_split == a_split && one != two) bn++; // 둘의 숫자는 같은데 위치는 다르면 볼
    					}
    				}
    				
    				if(sn == s && bn == b) check[a] = true; // 입력받은 스트라이크와 볼의 갯수와 같아진다면 가능성 있는 수로 판별
    				else check[a] = false; // 아니라면 가능성 박탈
    			}
    		}
    	}
    	
    	int a = 0;
    	for(int i=123; i<=987; i++) {
    		if(check[i]) a++;
    	}
    	System.out.println(a);
    	
    }
}