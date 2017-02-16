/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundreded;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Laten
 */
public class Hundreded {
    static String word;
    static char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static ArrayList<String> hundred = new ArrayList<>();
    static Set<String> set = new HashSet<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
      Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("di.txt")));

            while (s.hasNext()) {
                word = s.next();
                int c = numerise(word);
                if(c == 100) {
                    hundred.add(word);
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        set.addAll(hundred);
        hundred.clear();
        hundred.addAll(set);
        Collections.sort(hundred, String.CASE_INSENSITIVE_ORDER);
        for(String item : hundred){
            System.out.println(item);
        }
        
    }
    
    private static int numerise(String input) {
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            sum = sum + num(input.charAt(i));
        }
        return sum;
    }
    
    private static int num(char x) {
        int index = 0;
        for(int i = 0; i < alph.length; i++){
           if (alph[i] == x) {
            index = i + 1;
           }
        }
        return index;
    }
}
