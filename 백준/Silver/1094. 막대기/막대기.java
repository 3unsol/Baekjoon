import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int count = 0;
        int stick = 64;

        while(X > 0) {

            if(stick > X) {
                stick >>= 1;
            } else {
                count++;
                X -= stick;
            }
        }

        System.out.println(count);
    }
}