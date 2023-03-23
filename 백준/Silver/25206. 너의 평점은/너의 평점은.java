import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float creditSum = 0;
		float scoreSum = 0;
		float ans = 0;
		for (int i = 0; i < 20; i++) {
			sc.next();
			float credit = sc.nextFloat();
			String grade = sc.next();
			float score = 0;
			switch (grade) {
			case ("A+"):
				score = (float) 4.5;
				break;
			case ("A0"):
				score = (float) 4.0;
				break;
			case ("B+"):
				score = (float) 3.5;
				break;
			case ("B0"):
				score = (float) 3.0;
				break;
			case ("C+"):
				score = (float) 2.5;
				break;
			case ("C0"):
				score = (float) 2.0;
				break;
			case ("D+"):
				score = (float) 1.5;
				break;
			case ("D0"):
				score = (float) 1.0;
				break;
			case ("F"):
				score = 0;
				break;
			case ("P"):
				score = 0;
				credit = 0;
				break;
			}
			creditSum += credit;
			scoreSum += (credit * score);
		}
		ans = scoreSum / creditSum;
		System.out.println(ans);
	}
}
