package main;

import java.io.*;

import syntaxtree.Program;
import visitor.PrettyPrintVisitor;
import analizer.MiniJavaParser;
import analizer.ParseException;
import analizer.TokenMgrError;

public class Main {
	public static void main(String args[]) throws ParseException {
		MiniJavaParser parser;
		try {
			parser = new MiniJavaParser(new FileInputStream(
					"E:/ArquivoFonteTeste.txt"));
			Program root = parser.parse();
			root.accept(new PrettyPrintVisitor());
			System.out.println("Successful!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + args[0]);
			return;
		} catch (TokenMgrError e) {
			System.out.println("Fail! TokenMgrError: " + e);
			return;
		} catch (Error e) {
			System.out.println("Fail! Error: " + e);
			return;
		}
	}
}
