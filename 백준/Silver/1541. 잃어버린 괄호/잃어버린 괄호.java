import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-"); // 일단 -로 구분
        int sum = Integer.MAX_VALUE; // 첫번째 값인지 알기 위해 max값으로 설정
        while(st.hasMoreTokens()){ // 토큰이 있다면!
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+"); // +로 구분
            int tmp = 0;
            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken()); // +로 나눈 것들 더해준다.
            }
            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}