package ua.nure.ageev.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	private static final String ENCODING = "Cp1251";

	public static String readFile(String path) {
		String res = null;
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(path));
			res = new String(bytes, ENCODING);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	public static Matcher getMatcher(String input, String regEx) {
		Pattern pattern = Pattern.compile(regEx, Pattern.UNICODE_CHARACTER_CLASS);
		return pattern.matcher(input);
	}

	public static void main(String[] args) {
		System.out.println(readFile("part1.txt"));
	}
}
