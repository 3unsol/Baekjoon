import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean flag = true;
        for(int i = 0; i < str.length() / 2; i++) {
            char front = str.charAt(i);
            char back = str.charAt(str.length() - i - 1);
            if(front != back){
                flag = false;
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}