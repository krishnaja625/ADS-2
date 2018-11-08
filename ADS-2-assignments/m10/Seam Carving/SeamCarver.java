
public class SeamCarver {
	Picture pictur;
	double[][] energy;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		pictur = picture;
		energy = new double[pictur.height()][pictur.width()];
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
			// energyArr[y][x] = 1000;
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
		double yrightRed = pictur.get(x, y - 1).getRed();
		double yrightGreen = pictur.get(x, y- 1).getGreen();
		double yrightBlue = pictur.get(x, y - 1).getBlue();
		double yleftRed = pictur.get(x, y + 1).getRed();
		double yleftGreen = pictur.get(x, y + 1).getGreen();
		double yleftBlue = pictur.get(x, y + 1).getBlue();
		deltaY = Math.pow(yrightRed - yleftRed , 2) + Math.pow(yrightGreen - yleftGreen, 2)
		+ Math.pow(yrightBlue - yleftBlue, 2);
		double energySum = deltaX + deltaY;
		double energy = Math.sqrt(energySum);
		// energyArr[y][x] = energy;
		return energy;
	}
private void dfsMinPath(int x, int y, double[][] sumEnergy,
   double[][] energy, int[][] steps, boolean horizontal) {
  if ((horizontal && x == pictur.width() - 1)
    || (!horizontal && y == pictur.height() - 1)) {
   sumEnergy[y][x] = energy[y][x];
   steps[y][x] = -1;
   return;
  }
  double minPath = 1000;
  int bestMv = 0;
  for (int mv = -1; mv <= 1; mv++) {
   if (horizontal) {
    int py = y + mv;
    if (py >= pictur.height() || py < 0)
     continue;
    if (steps[py][x + 1] == 0)
     dfsMinPath(x + 1, py, sumEnergy, energy, steps, horizontal);
    if (sumEnergy[py][x + 1] < minPath) {
     minPath = sumEnergy[py][x + 1];
     bestMv = py;
    }
   } else {
    int px = x + mv;
    if (px >= pictur.width() || px < 0)
     continue;
    if (steps[y + 1][px] == 0)
     dfsMinPath(px, y + 1, sumEnergy, energy, steps, horizontal);
    if (sumEnergy[y + 1][px] < minPath) {
     minPath = sumEnergy[y + 1][px];
     bestMv = px;
    }
   }
  }
  steps[y][x] = bestMv;
  sumEnergy[y][x] = energy[y][x] + minPath;
 }
  public int[] findHorizontalSeam() {
  // sequence of indices for horizontal seam
  int[][] steps = new int[pictur.height()][pictur.width()];
  double[][] sumEnergy = new double[pictur.height()][pictur.width()];
  this.calSumEnergy();
  for (int y = 0; y < pictur.height(); y++)
   this.dfsMinPath(0, y, sumEnergy, energy, steps, true);
  int[] ht = new int[pictur.width()];
  double bestEnergy = Double.MAX_VALUE;
  for (int y = 0; y < this.height(); y++) {
   if (sumEnergy[y][0] < bestEnergy) {
    bestEnergy = sumEnergy[y][0];
    ht[0] = y;
   }
  }
  for (int x = 1; x < this.width(); x++) {
   ht[x] = steps[ht[x - 1]][x - 1];
  }
  return ht;
 }
  private void calSumEnergy() {
  for (int j = 0; j < pictur.height(); j++)
   for (int i = 0; i < pictur.width(); i++) {
    energy[j][i] = this.energy(i, j);
   }
 }

 public int[] findVerticalSeam() {
  // sequence of indices for vertical seam
  int[][] steps = new int[pictur.height()][pictur.width()];
  double[][] sumEnergy = new double[pictur.height()][pictur.width()];
  this.calSumEnergy();
  for (int x = 0; x < pictur.width(); x++)
   this.dfsMinPath(x, 0, sumEnergy, energy, steps, false);
  int[] ht = new int[pictur.height()];
  double bestEnergy = Double.MAX_VALUE;
  for (int x = 0; x < this.width(); x++) {
   if (sumEnergy[0][x] < bestEnergy) {
    bestEnergy = sumEnergy[0][x];
    ht[0] = x;
   }
  }
  for (int y = 1; y < this.height(); y++)
   ht[y] = steps[y - 1][ht[y - 1]];
  return ht;
 }

 public void removeHorizontalSeam(int[] a) throws IllegalArgumentException {
  // remove horizontal seam from picture
  if (a.length != pictur.width())
   throw new IllegalArgumentException();
  Picture cPic = new Picture(pictur.width(), pictur.height() - 1);
  for (int i = 0; i < pictur.width(); i++) {
   for (int j = 0; j < pictur.height(); j++) {
    if (j == a[i])
     continue;
    int pt = j;
    if (pt > a[i])
     pt--;
    cPic.set(i, pt, this.pictur.get(i, j));
   }
  }
  this.pictur = cPic;
 }

 public void removeVerticalSeam(int[] a) throws IllegalArgumentException {
  // remove vertical seam from picture
  if (a.length != pictur.height())
   throw new IllegalArgumentException();
  Picture cPic = new Picture(pictur.width() - 1, pictur.height());
  for (int j = 0; j < pictur.height(); j++) {
   for (int i = 0; i < pictur.width(); i++) {
    if (i == a[j])
     continue;
    int pt = i;
    if (pt > a[j])
     pt--;
    cPic.set(pt, j, pictur.get(i, j));
   }
  }
  this.pictur = cPic;
 }
}

/*	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		double min = 1000;
		int[] hght = new int[pictur.height()];
		this.dfsMinPath(x, 0, sumEnergy, energy, steps, false);
		for (int row = 0; row < pictur.height(); row++) {
            for (int col = 0; col < pictur.width(); col++) {
            	if (row == 0) {
            	if (min > energyArr[row][col]) {
            	min = energyArr[row][col];
            	hght[0] = col;
            }
            hght[col] = col;
            }   
        }
        if (row == 0) {

        	continue;
        }
    }
    
        for (int y = 1; y < this.height(); y++) {
   			hght[y] = steps[y - 1][ht[y - 1]];
        }
  		return hght;
            }
              int[][] steps = new int[pic.height()][pic.width()];
  double[][] sumEnergy = new double[pic.height()][pic.width()];
  this.calSumEnergy();
  for (int x = 0; x < this.width(); x++)
   this.dfsMinPath(x, 0, sumEnergy, energy, steps, false);
  int[] ht = new int[pic.height()];
  double bestEnergy = Double.MAX_VALUE;
  for (int x = 0; x < this.width(); x++) {
   if (sumEnergy[0][x] < bestEnergy) {
    bestEnergy = sumEnergy[0][x];
    ht[0] = x;
   }
  }
  for (int y = 1; y < this.height(); y++)
   ht[y] = steps[y - 1][ht[y - 1]];
  return ht;
 }
	  // sequence of indices for vertical seam
/*  int[][] steps = new int[pic.height()][pic.width()];
  double[][] sumEnergy = new double[pic.height()][pic.width()];
  this.calSumEnergy();
  for (int x = 0; x < this.width(); x++)
   this.dfsMinPath(x, 0, sumEnergy, energy, steps, false);
  int[] ht = new int[pic.height()];
  double bestEnergy = Double.MAX_VALUE;
  for (int x = 0; x < this.width(); x++) {
   if (sumEnergy[0][x] < bestEnergy) {
    bestEnergy = sumEnergy[0][x];
    ht[0] = x;
   }
  }
  for (int y = 1; y < this.height(); y++)
   ht[y] = steps[y - 1][ht[y - 1]];
  return ht*/

/*	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}*/