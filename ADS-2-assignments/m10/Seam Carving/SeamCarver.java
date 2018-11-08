
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
		if (x == 0 || y == 0 || x == pictur.width() - 1|| y == pictur.height() - 1) {
		return 1000;
		}
		double deltaX = 0;
		double xTopRed = pictur.get(x - 1, y).getRed();
		double xTopGreen = pictur.get(x - 1, y).getGreen();
		double xTopBlue = pictur.get(x - 1, y).getBlue();
		double xbottomRed = pictur.get(x + 1, y).getRed();
		double xbottomGreen = pictur.get(x + 1, y).getGreen();
		double xbottomBlue = pictur.get(x + 1, y).getBlue();
		deltaX = Math.pow(xTopRed - xbottomRed , 2) + Math.pow(xTopGreen - xbottomGreen, 2)
		+ Math.pow(xTopBlue - xbottomBlue, 2);
		double deltaY = 0;
		double xrightRed = pictur.get(x, y - 1).getRed();
		double xrightGreen = pictur.get(x, y- 1).getGreen();
		double xrightBlue = pictur.get(x, y - 1).getBlue();
		double xleftRed = pictur.get(x, y + 1).getRed();
		double xleftGreen = pictur.get(x, y + 1).getGreen();
		double xleftBlue = pictur.get(x, y + 1).getBlue();
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