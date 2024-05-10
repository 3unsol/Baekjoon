import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine()); // 800자리수의 숫자라서 빅인티저 써야 함

        BigInteger start = new BigInteger("1"); // 1이라는 빅인티저 만들기
        BigInteger end = N;
        BigInteger mid;

        while(true) {

            mid = (start.add(end)).divide(new BigInteger("2")); // (start + end) / 2

            int result = (mid.multiply(mid)).compareTo(N); // mid * mid 와 N 비교 (-: 작음, 0: 같음, +: 큼)
            if(result == 0) break; // 같으면 그만
            else if (result == 1) end = mid.subtract(new BigInteger("1")); // 크면 end--
            else start = mid.add(new BigInteger("1")); // 작으면 start++
        }

        System.out.println(mid);
    }
}