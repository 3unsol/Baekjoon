import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = sc.nextInt();

		// 뒤에 두자리 빼고 남길 거
		// 그리고 뒤에 두자리에 00부터 다 넣기
		// 그걸 다 나눠 f로
		// 젤 먼저 나오는 거
		// 한자리수면 앞에 0 붙이기

		// n 뒤를 00으로 만들어준다
		int num = (n / 100) * 100;
		// n에 00부터 99까지 넣어준다
		for (int i = 0; i <= 99; i++) {
			// 담을 그릇
			int num2 = 0;
			// 00부터 99까지 숫자 만들어준다
			num2 = num + i;
			// f로 나누어 떨어진다면? 
			if (num2 % f == 0) {
				// 근데 그게 1의자리 수라면?
				if (i < 10) {
					// 0 붙여서 출력
					System.out.println("0" + i);
					// 두자리수면 그냥 출력
				} else {
					System.out.println(i);
				}
				// 젤 작은 거 나와야 하니까 한번 출력하고 끝내기
				break;
			}
		}

	}
}