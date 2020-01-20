package ua.nure.ageev.practice3;

import java.util.Locale;
import java.util.regex.Matcher;

public class Part3 {
	private static final String REG_EX = "\\w+|,|\\s|\\n|\\?|'|\\.|\\—|\\-";

	public static void main(String[] args) {
		System.out.println(convert(Util.readFile("part3.txt")));
	}

	public static String convert(String input) {
		StringBuilder sb = new StringBuilder();
		Matcher m = Util.getMatcher(input, REG_EX);
		while (m.find()) {
			if (m.group().length() >= 3) {
				if (Util.getMatcher(m.group(), "^[A-Z]|[À-ß,¨].+").find()) {
					sb.append((m.group().substring(0, 1).toLowerCase(Locale.UK) + m.group().substring(1)));
				} else {
					sb.append((m.group().substring(0, 1).toUpperCase(Locale.UK) + m.group().substring(1)));
				}
			} else {
				sb.append(m.group());
			}

		}
		return sb.toString();
	}
}
