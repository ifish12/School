package com.cs406;

import com.cs406.util.LinkedList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> per = new LinkedList<String>();
        permutation("", "race", per);

        per.reset();
        while(per.hasNext()) {
            String p = per.next();
            if (isWord(p))
                System.out.println(p);
        }
    }

    private static void permutation(String prefix, String str, LinkedList<String> per) {
        int n = str.length();
        if (n == 0) {
            if(!per.contains(prefix))
                per.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), per);
            }
        }
    }

    private static boolean isWord(String s) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("words-sorted.txt"));

        while(scan.hasNextLine()) {
            String word = scan.nextLine();
            if (s.compareTo(word) < 0)
                return false;
            else if(s.compareTo(word) == 0)
                return true;
        }

        return false;
    }
}
