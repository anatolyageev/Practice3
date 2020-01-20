package ua.nure.ageev.practice3;

import java.util.regex.Matcher;

public class Part6 {
	private static final String REG_EX = "\\w+|\\n|\\s";

	public static void main(String[] args) {
		System.out.println(convert(Util.readFile("part6.txt")));
	}

	public static String convert(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		String str = convertHelper(input);

		while (m.find()) {

			if (Util.getMatcher(str, "\\b" + m.group() + "\\b").find() && !m.group().matches("\\s")) {
				sb.append("_").append(m.group());
			} else {
				sb.append(m.group());
			}
		}
		return sb.toString();

	}

	public static String convertHelper(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			if (!m.group().matches("\\n|\\s")) {
				sb.append(m.group()).append(" ");
			}
		}
		String[] str = sb.toString().split(" ");
		StringBuilder sb1 = new StringBuilder();
		for (String string : str) {

			int i = input.split("\\b" + string + "\\b").length;
			if (i > 2) {
				sb1.append(string).append(" ");
			}
		}
		return sb1.toString();
	}

}
