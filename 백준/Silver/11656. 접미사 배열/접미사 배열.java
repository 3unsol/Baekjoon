import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] suffix = new String[str.length()];

        for(int i = 0; i < suffix.length; i++) {
            suffix[i] = str.substring(i, str.length());
        }

        Arrays.sort(suffix);

        for(int i = 0; i < suffix.length; i++) {
            System.out.println(suffix[i]);
        }
    }
}