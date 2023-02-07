import java.util.Scanner;

public class Main {

	static int money;

	static void input() {
		Scanner sc = new Scanner(System.in);
		money = sc.nextInt();
	}

	// 1000 - money를 빼고
	// 남은 돈을... 음.. 500으로 나누기
	// 나눈 만큼 또 빼..?
	// 남은 돈..을 100으로 나누고 계속계쏙..
	// 총 매수

	static void getChange() {
		int change = 1000 - money;
		int sum = change / 500;
		change %= 500;
		sum += change / 100;
		change %= 100;
		sum += change / 50;
		change %= 50;
		sum += change / 10;
		change %= 10;
		sum += change / 5;
		change %= 5;
		sum += change / 1;
		System.out.println(sum);
	}

	public static void main(String[] args) {
		input();
		getChange();
	}
}