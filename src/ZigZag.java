
public class ZigZag {

	public static void zig() {
		for (int row = 1; row <= 8; row++) {
			for (int spaces = 1; spaces < row; spaces++) {
				System.out.print(" ");
			}
			System.out.print("@");
			System.out.println();
		}
	}

	public static void zag() {
		int rowNumbers = 8;
		for (int row = 1; row <= rowNumbers; row++) {
			for (int spaces = 8; spaces > row; spaces--) {

			}
		}
	}

	public static void main(String[] args) {

	}
}
