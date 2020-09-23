public class Square {
	private int[][] square;
	private int size;

	public Square(int size) {
		super();
		this.size = size;
		int i, j, k = 0;
		this.square = new int[size][size];
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				this.square[i][j] = k;
				k++;
			}
		}
	}

	public Square(int[][] pattern) {
		super();
		this.square = pattern;
		this.size = pattern.length;
	}

	public void draw() {
		int i, j;
		int length = this.square.length;

		for (i = 0; i < length; i++) {
			for (j = 0; j < length; j++) {
				System.out.printf("%-4s",this.square[i][j]);
			}
			System.out.println("\n");
		}
	}

	public Square rotateSquare() {
		int i, j;
		int[][] currentSquare = this.getSquare();
		int[][] newSquare = new int[currentSquare.length][currentSquare.length];
		int lengthCustom = newSquare.length - 1;
		for (i = 0; i <= lengthCustom / 2; i++) {
			for (j = i; j < lengthCustom - i; j++) {
				newSquare[i][j] = currentSquare[lengthCustom - j][i];
				newSquare[lengthCustom - j][i] = currentSquare[lengthCustom - i][lengthCustom - j];
				newSquare[lengthCustom - i][lengthCustom - j] = currentSquare[j][lengthCustom - i];
				newSquare[j][lengthCustom - i] = currentSquare[i][j];
			}
		}
		return new Square(newSquare);
	}

	public void rotateSquare(int xStart, int yStart, int length) {
		int i, j;
		int[][] square = this.getSquare();
		int editX = xStart - 1;
		int editY = yStart - 1;
		int lengthX = length + editX;
		int lengthY = length + editY;
		
		for (i = editX; i <= length / 2 + editX; i++) {			
			for (j = (i - editX) + editY; j < lengthX - i + editY; j++) {
				int firstX = i;
				int firstY = j;
				int secondX = (firstY - editY) + editX;
				int secondY = lengthY - (firstX - editX);
				int thirdX = lengthX - firstX + editX;
				int thirdY = lengthY - firstY + editY;
				int forthX = lengthY - firstY + editX;
				int forthY = (firstX - editX) + editY;
				
				int temp = square[firstX][firstY];
				square[firstX][firstY] = square[forthX][forthY];
				square[forthX][forthY] = square[thirdX][thirdY];
				square[thirdX][thirdY] = square[secondX][secondY];
				square[secondX][secondY] = temp;
			}
		}
	}
	
	public int[] getIndexOfValue(int value) {
		int[][] square = this.getSquare();
		int[] result = new int[2];
		int i,j;
		
		for(i = 0; i < square.length; i++) {
			for(j = 0; j < square.length; j++) {
				if(square[i][j] == value) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		
		return result;	
	}

	public Square generateInnerSquare(int xStart, int yStart, int length) {
		int[][] innerSquare = new int[length + 1][length + 1];
		int aTemp = xStart - 1;
		int bTemp = yStart - 1;
		int[][] square = this.getSquare();
		int size = square.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i >= aTemp && i <= aTemp + length && j >= bTemp && j <= bTemp + length) {
					innerSquare[i - aTemp][j - bTemp] = square[i][j];
				}
			}
		}

		return new Square(innerSquare);
	}

	public int[][] getSquare() {
		return square;
	}

	public void setSquare(int[][] square) {
		this.square = square;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
