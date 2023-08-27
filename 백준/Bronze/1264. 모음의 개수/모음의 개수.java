import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals("#")){
                break;
            }
            char[] chars = str.toCharArray();
            int cnt = 0;
            for(int i = 0; i < chars.length; i++){
                if(chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U' || chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' ||chars[i] == 'u'){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}