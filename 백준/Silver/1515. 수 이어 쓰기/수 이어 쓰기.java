import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 0;
        int idx = 0;

        while(true) {
            cnt++;
            
            // cnt를 String으로 변경
            String cntStr = String.valueOf(cnt);

            // cnt 자릿수만큼 확인
            for(int i = 0; i < cntStr.length(); i++) {
                if(cntStr.charAt(i) == str.charAt(idx)) idx++;
                if(idx == str.length()) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }
}