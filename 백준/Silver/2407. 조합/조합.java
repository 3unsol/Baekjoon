import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        BigInteger nFactorial = BigInteger.valueOf(1);
        BigInteger nmFactorial = BigInteger.valueOf(1);
        BigInteger mFactorial = BigInteger.valueOf(1);

        for(int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        for(int i = 2; i <= m; i++) {
            mFactorial = mFactorial.multiply(BigInteger.valueOf(i));
        }

        for(int i = 2; i <= n - m; i++) {
            nmFactorial = nmFactorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger p = nmFactorial.multiply(mFactorial);

        BigInteger ans = nFactorial.divide(p);
        System.out.println(ans);
    }
}