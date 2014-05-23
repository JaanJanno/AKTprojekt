package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class AsmReader {

	public List<String> readAsmTest(String path) throws IOException {
		InputStreamReader reader = new InputStreamReader(this.getClass()
				.getResourceAsStream(path),  "UTF-8");
		BufferedReader scanner = new BufferedReader(reader);

		List<String> asmList = new ArrayList<>();
		String line;
		while ((line = scanner.readLine()) != null) {
			asmList.add(line);

		}
		scanner.close();

		return asmList;
	}
	
	public List<String> readAsm(String path) throws IOException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(path),  "UTF-8");
		BufferedReader scanner = new BufferedReader(reader);

		List<String> asmList = new ArrayList<>();
		String line;
		while ((line = scanner.readLine()) != null) {
			asmList.add(line);

		}
		scanner.close();

		return asmList;
	}

}
