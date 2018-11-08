
public class SeamCarver {
	Picture pictur;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		pictur = picture;
	}
	// current picture
	public Picture picture() {
		return pictur;
	}
	// width of current picture
	public int width() {
		return pictur.width();
	}

	// height of current picture
	public int height() {
		return pictur.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || y == 0 || x == pictur.width()|| y == pictur.height()) {
		return 1000;
		}
		return pictur.get(x, y).getRGB();
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}