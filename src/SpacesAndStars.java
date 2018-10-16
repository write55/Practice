
public class SpacesAndStars {

	public static void printSpacesAndStars() {
		for (int i = 1; i <= 9; i++) {
			for (int spaces = 8; spaces >= i; spaces--) {
				System.out.print(" ");
			}
			for (int stars = 1; stars <= 2 * i - 1; stars++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void printCirclesAndStars() {
		for (int row = 1; row <= 9; row++) {
			for (int circles = 1; circles <= row; circles++) {
				System.out.print("o");
			}
			for (int stars = 10; stars > row; stars--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printSpacesAndStars();
		System.out.println();
		printCirclesAndStars();
	}
}
