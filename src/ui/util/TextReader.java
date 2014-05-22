package ui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReader {
	
	public static String helpTextLoader(String path) throws IOException {
		String text = "";
		InputStreamReader reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(path), "UTF-8");
		BufferedReader scanner = new BufferedReader(reader);

		String line;
		while ((line = scanner.readLine()) != null) {
			text += line;

		}
		scanner.close();
		return text;
	}


}
