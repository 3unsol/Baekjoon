import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		for (int i = 0; i < strArr.length; i++) {
			if (str.contains(strArr[i])) {
				str = str.replace(strArr[i], "!");
			}
		}
		System.out.println(str.length());
	}
}
