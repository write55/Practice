import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 *
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 *
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 *
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 *
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 *
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/**
	 * Method to set the blue to 0
	 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	// A6 Q1, mirrors right to left
	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	// A6 Q2, mirrors top to bottom
	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - row - 1][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	// A6 Q3, same as previous but backwards
	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - row - 1][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	// A6 Q4, mirrors diagonal square area
	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topRightPixel = null;
		Pixel bottomLeftPixel = null;
		int side = pixels.length;
		for (int row = 0; row < side; row++) {
			for (int col = 0; col < row; col++) {
				bottomLeftPixel = pixels[row][col];
				topRightPixel = pixels[col][row];
				topRightPixel.setColor(bottomLeftPixel.getColor());
			}
		}
	}

	/**
	 * Mirror just part of a picture of a temple
	 */
	// A7 Q1, added count variable
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();
		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				count++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		System.out.println("Should be 18410, is " + count);
	}

	// A7 Q2, mirrors arms of snowman
	public void mirrorArms() {
		int mirrorPoint = 196;
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 157; row < 196; row++) {
			for (int col = 104; col < 294; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	// A7 Q3, mirrors seagull on beach
	public void mirrorGull() {
		// 231 233 to 328 348
		int mirrorPoint = 348;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 231; row < 328; row++) {
			for (int col = 233; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 *
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	// A8, Q1, Second Copy method with bounds as arguments
	public void copyBounds(Picture fromPic, int startRow, int startCol, int startRowCopy, int endRowCopy,
			int startColCopy, int endColCopy) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = startRowCopy, toRow = startRow; fromRow < endRowCopy
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = startColCopy, toCol = startCol; fromCol < endColCopy
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/**
	 * Method to create a collage of several pictures
	 */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 *
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	// A9 Q1, changed to check pixel above as well
	public void newEdgeDetection(int edgeDist) {
		Pixel currentPixel = null;
		Pixel rightPixel = null;
		Pixel botPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				currentPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				botPixel = pixels[row + 1][col];
				// Can change this || to && to make it react to fewer cases
				if (currentPixel.colorDistance(rightPixel.getColor()) > edgeDist
						|| currentPixel.colorDistance(botPixel.getColor()) > edgeDist)
					currentPixel.setColor(Color.BLACK);
				else
					currentPixel.setColor(Color.WHITE);
			}
		}
	}
	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	// public static void main(String[] args) {
	// Picture beach = new Picture("beach.jpg");
	// beach.explore();
	// beach.zeroBlue();
	// beach.explore();
	// }

} // this } is the end of class Picture, put all new methods before this