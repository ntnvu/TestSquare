import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numberN, numberS, numberL;
		List<InputSquare> S = new ArrayList<InputSquare>();
		List<Integer> L = new ArrayList<Integer>();
		
		System.out.print("Enter N: ");
		numberN = Integer.parseInt(reader.readLine());
		Square square = new Square(numberN);

		System.out.print("Enter S: ");
		numberS = Integer.parseInt(reader.readLine());

		int count = 0;
		while (count < numberS) {
			String tempString = reader.readLine();
			String[] tempList = tempString.split(" ");
			if (tempList.length != 3) {
				continue;
			}

			List<Integer> temp = new ArrayList<Integer>();
			for (String a : tempList) {
				try {
					int i = Integer.parseInt(a);
					temp.add(i);
				} catch (NumberFormatException nfe) {
					continue;
				}
			}

			S.add(new InputSquare(temp.get(0), temp.get(1), temp.get(2)));
			count++;
		}

		System.out.print("Enter L: ");
		numberL = Integer.parseInt(reader.readLine());
		int countL = 0;
		while (countL < numberL) {
			try {
				int value = Integer.parseInt(reader.readLine());
				L.add(value);
				countL++;
			} catch (NumberFormatException nfe) {
				System.out.println("Fail");
				break;
			}
		}

		for (int i = 0; i < S.size(); i++) {
			InputSquare inputSquare = S.get(i);
			int xStart = inputSquare.getA();
			int yStart = inputSquare.getB();
			int size = inputSquare.getD();
			square.rotateSquare(xStart, yStart, size);
		}
		System.out.println("Final square: ");
		square.draw();
		System.out.println("Find index: ");
		for (int i = 0; i < L.size(); i++) {
			int[] result = square.getIndexOfValue(L.get(i));
			System.out.format("index of %d: %d, %d", L.get(i), result[0], result[1]);
			System.out.println();
		}
	}

	public void handleInput() {

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
}
