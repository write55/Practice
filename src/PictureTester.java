/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {
	/**
	 * Method to test zeroBlue
	 */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/**
	 * Method to test mirrorVertical
	 */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	// A6 Q1
	public static void testMirrorVerticalRightToLeft() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.mirrorVerticalRightToLeft();
		caterpillar.explore();
	}

	// A6 Q2
	public static void testMirrorHorizontal() {
		Picture bike = new Picture("redMotorcycle.jpg");
		bike.mirrorHorizontal();
		bike.explore();
	}

	// A6 Q3
	public static void testMirrorHorizontalBotToTop() {
		Picture bike = new Picture("blueMotorcycle.jpg");
		bike.mirrorHorizontalBotToTop();
		bike.explore();
	}

	// A6 Q4
	public static void testMirrorDiagonal() {
		Picture beach = new Picture("beach.jpg");
		beach.mirrorDiagonal();
		beach.explore();
	}

	/**
	 * Method to test mirrorTemple
	 */
	// A7 Q1
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	// A7 Q2
	public static void testMirrorArms() {
		Picture snowman = new Picture("snowman.jpg");
		snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}

	// A7, Q3
	public static void testMirrorGull() {
		Picture gull = new Picture("seagull.jpg");
		gull.explore();
		gull.mirrorGull();
		gull.explore();
	}

	/**
	 * Method to test the collage method
	 */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	// A8 Q1, tests copyBounds
	public static void testCopy() {
		Picture canvas = new Picture("640x480.jpg");
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		canvas.copyBounds(flower1, 0, 0, 0, 70, 0, 70);
		canvas.copyBounds(flower2, 50, 50, 0, 75, 0, 75);
		canvas.explore();
	}

	// A8 Q2, used the beach picture for all 3
	public static void myCollage() {
		Picture canvas = new Picture("640x480.jpg");
		Picture beach = new Picture("beach.jpg");
		canvas.copyBounds(beach, 0, 10, 0, 100, 0, 100);
		canvas.copyBounds(beach, 80, 80, 100, 300, 100, 300);
		canvas.copyBounds(beach, 250, 250, 100, 300, 100, 300);
		canvas.mirrorDiagonal();
		canvas.mirrorVertical();
		canvas.explore();
	}

	/**
	 * Method to test edgeDetection
	 */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		// swan.newEdgeDetection(10);
		swan.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVerticalRightToLeft();
		// testMirrorHorizontal();
		// testMirrorHorizontalBotToTop();
		// testMirrorDiagonal();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testCollage();
		// myCollage();
		// testCopy();
		testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}

}