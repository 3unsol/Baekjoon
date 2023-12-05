import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int zeroCount, oneCount;
    public static void main(String[] args) throws Exception {
        tanos();
    }

    static void tanos() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') {
                zeroCount++;
            }
        }

        oneCount = (str.length() - zeroCount) / 2;
        zeroCount /= 2;
        int oneCnt = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(zeroCount != 0 && str.charAt(i) == '0') {
                sb.append('0');
                zeroCount--;
            }else if(str.charAt(i) == '1') {
                if(oneCnt != oneCount) {
                    oneCnt++;
                } else {
                    sb.append('1');
                }
            }
        }

        System.out.println(sb);
    }
}