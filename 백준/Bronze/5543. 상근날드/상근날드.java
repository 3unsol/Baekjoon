import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bugger = Integer.parseInt(br.readLine());
        for(int i = 0; i < 2; i++) {
            bugger = Math.min(bugger, Integer.parseInt(br.readLine()));
        }

        int drink = Integer.parseInt(br.readLine());
        drink = Math.min(drink, Integer.parseInt(br.readLine()));

        System.out.println(bugger + drink - 50);
    }
}
