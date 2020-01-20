package ua.nure.ageev.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;

public class Part1 {
	private static final String REG_EX = "(.+);(\\w+) (\\w+);((.+)@(.+))";
	private static final String REG_EX2 = "(.+);(.+);(.+)";
	private static final int GROUP_NUM_SIX = 6;
	private static final int GROUP_NUM_ONE = 1;
	private static final double X = 0.1;

	public static void main(String[] args) {
		String fileName = "part1.txt";
		System.out.println(convert1(Util.readFile(fileName)));
		System.out.println(convert2(Util.readFile(fileName)));
		System.out.println(convert3(Util.readFile(fileName)));
		System.out.println(convert4(Util.readFile(fileName)));
	}

	public static String convert1(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			sb.append(m.group(1)).append(": ").append(m.group(4)).append("\n");
		}
		return sb.toString();
	}

	public static String convert2(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			sb.append(m.group(3)).append(" ").append(m.group(2));
			sb.append(" (email: ").append(m.group(4)).append(")\n");
		}
		return sb.toString();
	}

	public static String convert3(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		String[] str = convert3Helper(input);

		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]).append(" ==> ");

			while (m.find()) {
				if (str[i].compareTo(m.group(GROUP_NUM_SIX)) == 0) {
					sb.append(m.group(GROUP_NUM_ONE)).append(", ");
				}
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append("\n");
			m.reset();
		}
		return sb.toString();
	}

	public static String[] convert3Helper(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			if (!sb.toString().contains(m.group(GROUP_NUM_SIX))) {
				sb.append(m.group(GROUP_NUM_SIX)).append(" ");
			}
		}
		return sb.toString().split(" ");
	}

	public static String convert4(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX2);
		while (m.find()) {
			sb = sb.append(m.group(0)).append(";");
			if (m.group(3).contains("@")) {
				sb = sb.append(getRandomPass(4)).append("\n");
			} else {
				sb = sb.append("Password").append("\n");
			}
		}
		return sb.toString();
	}

	public static long getRandomPass(int digitNum) {
		SecureRandom random = new SecureRandom();
		double temp = random.nextDouble();
		return Math.round(((temp > X) ? temp : (temp + X)) * Math.pow(10, digitNum));
	}
}
