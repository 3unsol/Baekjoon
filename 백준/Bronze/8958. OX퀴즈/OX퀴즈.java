import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			// 문자열로 받아서
			String str = sc.next();
			// char로 나눠준다.
			char[] arr = str.toCharArray();
			// 총합
			int sum = 0;
			// 현재까지 합
			int tmpSum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				// O면 현재까지 합을 늘려준다.
				if (arr[i] == 'O') {
					tmpSum++;
				// X면 0으로 초기화
				} else {
					tmpSum = 0;
				}
				// 총합에 현재까지 합을 더해준다.
				sum += tmpSum;
			}
			System.out.println(sum);
		}
	}
}
