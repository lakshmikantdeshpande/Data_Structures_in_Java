package com.sbs.communicationcontrol.services.document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class TestClass {
  private static final Set<Integer> numbers = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    String str = br.readLine().trim();

    String output = countNumbersAndCharacters(str);
    wr.println(output);

    wr.close();
    br.close();
  }

  private static String countNumbersAndCharacters(String str) {
    int numCount = 0;
    int charCount = 0;
    for (char c : str.toCharArray()) {
      if (c >= '0' && c <= '9') {
        ++numCount;
      } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
        ++charCount;
      }
    }
    return numCount + "\n" + charCount;
  }

}