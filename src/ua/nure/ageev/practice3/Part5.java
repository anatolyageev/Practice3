package ua.nure.ageev.practice3;

public class Part5 {
	private static final String[] ROMAN = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };
	private static final int[] DECIMAL = { 1, 4, 5, 9, 10, 40, 50, 90, 100 };
	private static final int NOM_OF_CICLES = 101;

	public static void main(String[] args) {

		for (int i = 1; i < NOM_OF_CICLES; i++) {
			String deciman2Roman = decimal2Roman(i);
			System.out.print(i + " ===> ");
			System.out.print(deciman2Roman + " ===> ");
			System.out.println(roman2Decimal(deciman2Roman));
		}

	}

	public static String decimal2Roman(int number) {

		int i = ROMAN.length - 1;

		StringBuilder sb = new StringBuilder();

		while ((number > 0)) {
			String currentSymbol = ROMAN[i];
			if (DECIMAL[i] <= number) {
				sb.append(currentSymbol);
				number -= DECIMAL[i];
			} else {
				i--;
			}
		}

		return sb.toString();
	}

	public static int roman2Decimal(String s) {
		int result = 0;
		String tmp = s;

		int i = ROMAN.length - 1;

		while ((tmp.length() > 0)) {
			String symbol = ROMAN[i];
			if (tmp.startsWith(symbol)) {
				result += DECIMAL[i];
				tmp = tmp.substring(symbol.length());
			} else {
				i--;
			}
		}

		return result;
	}
}
