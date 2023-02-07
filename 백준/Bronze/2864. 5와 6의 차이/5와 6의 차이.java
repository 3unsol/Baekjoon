
import java.util.Scanner;

public class Main {

	// 모든 메서드에 쓰기위해 static으로 선언을 해줍니다.
	static String a;
	static String b;

	// 입력값을 받는 메서드를 생성해줍니다.
	static void input() {
		Scanner sc = new Scanner(System.in);
		a = sc.next();
		b = sc.next();
	}

	// 최솟값을 구하는 메서드를 생성해줄건데
	static void makeMinNum() {
		// replace 메서드를 써서 6을 5로 바꿔줍니다.
		String newA = a.replace("6", "5");
		String newB = b.replace("6", "5");

		// 계산을 위해 string을 int로 바꿔줍니다.
		int intA = Integer.parseInt(newA);
		int intB = Integer.parseInt(newB);

		// 출력
		System.out.print(intA + intB + " ");
	}

	// 최댓값을 구하는 메서드를 생성합니다. 이하 동일.
	static void makeMaxNum() {
		String newA = a.replace("5", "6");
		String newB = b.replace("5", "6");

		int intA = Integer.parseInt(newA);
		int intB = Integer.parseInt(newB);

		System.out.print(intA + intB);
	}

	// 메인에서 만든 메서드 모두 실행합니다. 끝
	public static void main(String[] args) {
		input();
		makeMinNum();
		makeMaxNum();
	}
}