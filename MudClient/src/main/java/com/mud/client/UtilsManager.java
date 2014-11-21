package com.mud.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilsManager {
	File file;
	BufferedWriter bw;
	BufferedReader input;
	List<String> strings;

	public UtilsManager() throws IOException {
		file = new File(System.getProperty("user.dir") + "/servers");
		if (!file.exists()) {
			file.createNewFile();
			write("localhost");
		}
	}

	public boolean write(String server) {
		if (!isContaining(server)) {
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
				if (strings != null) {
					strings.add(server);
					for (String el : strings)
						bw.write(el + "\n");
					bw.close();
					return true;
				} else {
					bw.write(server + "\n");
					bw.close();
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public String[] read() throws IOException {
		input = new BufferedReader(new FileReader(file.getAbsoluteFile()));
		strings = new ArrayList<String>();
		try {
			String line = null;
			while ((line = input.readLine()) != null) {
				strings.add(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error, file " + file.getAbsoluteFile()
					+ " didn't exist.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
		String[] lineArray = strings.toArray(new String[] {});

		return lineArray;
	}

	public boolean isContaining(String server) {
		if (strings != null && strings.contains(server))
			return true;
		return false;
	}

}
