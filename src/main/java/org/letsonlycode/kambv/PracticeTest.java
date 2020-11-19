package org.letsonlycode.kambv;


import com.sun.jna.platform.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class PracticeTest {



	public static void main(String[] args) throws IOException {

		final File initialFile = new File("src/test/resources/sample.txt");
		final File anotherFile = new File("src/test/resources/anothersample.txt");
		final InputStream targetStream = new FileInputStream(initialFile);
		final InputStream anotherTargetStream = new FileInputStream(anotherFile);

	}
}