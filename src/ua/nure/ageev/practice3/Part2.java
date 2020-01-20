package ua.nure.ageev.practice3;

import java.util.regex.Matcher;

public class Part2 {
	private static final String REG_EX = "\\w+";

	public static void main(String[] args) {
		String input = Util.readFile("part2.txt");
		System.out.println(convert(input));
	}

	public static String convert(String input) {
		int minWordLenghth = findMinLength(input);
		int maxWordLenghth = findMaxLength(input, REG_EX);
		return convertHelper(input, minWordLenghth, "Min") + "\n" + convertHelper(input, maxWordLenghth, "Max");
	}

	private static String convertHelper(String input, int len, String str) {
		StringBuilder sbMin = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			if (m.group().length() == len) {
				if (sbMin.length() == 0) {
					sbMin.append(str + ": ").append(m.group());
				}
				if (!sbMin.toString().contains(m.group())) {
					sbMin.append(", ").append(m.group());
				}
			}
		}
		return sbMin.toString();
	}

	private static int findMaxLength(String input, String regEx) {
		int maxLength = Integer.MIN_VALUE;
		Matcher m = Util.getMatcher(input, regEx);
		while (m.find()) {
			if (m.group().length() > maxLength) {
				maxLength = m.group().length();
			}
		}
		return maxLength;
	}

	private static int findMinLength(String input) {
		int minLength = Integer.MAX_VALUE;
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			if (m.group().length() < minLength) {
				minLength = m.group().length();
			}
		}
		return minLength;
	}

}
