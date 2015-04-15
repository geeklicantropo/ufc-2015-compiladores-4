package main;

import syntaxtree.*;
import visitor.*;
import analizer.MiniJavaParser;
import analizer.ParseException;

public class Main {
   public static void main(String [] args) throws ParseException {
      MiniJavaParser parser = new MiniJavaParser(System.in);
      Program root = parser.parse();
      root.accept(new PrettyPrintVisitor());
   }
}