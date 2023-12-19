import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int[] arr = new int[number.length()];
        for(int i = 0; i < number.length(); i++){
            arr[i] = number.charAt(i) - '0';
        }
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}