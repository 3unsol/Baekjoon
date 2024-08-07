import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;
        int num = 0;

        for(int i = 0; i < 3; i++) {
            String str = br.readLine();
            if(!str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz")) {
                index = i;
                num = Integer.parseInt(str);
            }
        }

        int ans = num + (3 - index);

        if(ans % 5 == 0 && ans % 3 == 0) {
            System.out.println("FizzBuzz");
        } else if(ans % 3 == 0) {
            System.out.println("Fizz");
        } else if(ans % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(ans);
        }
    }
}