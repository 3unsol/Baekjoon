import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        if(B > A){
            long tmp = A;
            A = B;
            B = tmp;
        }

        long gcd = getGCD(A, B);

        System.out.println((A * B) / gcd);
    }

    static long getGCD(long A, long B){
        while(B > 0){
            long tmp = A;
            A = B;
            B = tmp % B;
        }
        return A;
    }
}