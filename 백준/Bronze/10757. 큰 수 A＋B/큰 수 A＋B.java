import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger bigInteger = new BigInteger(sc.next());
		BigInteger bigInteger2 = new BigInteger(sc.next());
		BigInteger sum = bigInteger.add(bigInteger2);
		System.out.println(sum);
	}
}
