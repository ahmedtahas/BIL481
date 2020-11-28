/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package BIL481;

import java.util.ArrayList;
import BIL481.list.LinkedList;

import static BIL481.utilities.StringUtils.join;
import static BIL481.utilities.StringUtils.split;
import static BIL481.app.MessageUtils.getMessage;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        System.out.println(join(tokens));
    }
    public static boolean crypt(boolean forward, int leap, ArrayList<String> poem){
        if (leap >= 26)
            return false;
        else if (poem.size() % 4 != 0)
            return false;
        for(String line : poem){
            if(!Character.isUpperCase(line.charAt(0)))
                throw new RuntimeException();
        }
        for(String line : poem){
            for (int i = 0; i < line.length(); i++)
                if (Character.isDigit(line.charAt(i)))
                    throw new RuntimeException();
        }
        ArrayList<String> crypted_poem = new ArrayList<String>();
        ArrayList<Character> punctuation = new ArrayList<Character>();
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add(':');
        punctuation.add(';');
        punctuation.add('"');
        punctuation.add('\'');
        punctuation.add('!');
        punctuation.add('?');
        punctuation.add(' ');
        punctuation.add('(');
        punctuation.add(')');
        if (!forward)
            leap = -leap;
        for (String line : poem){
            String crypted_line = "";
            for (int i = 0; i < line.length(); i++){
                if (punctuation.contains(line.charAt(i)))
                    crypted_line += line.charAt(i);
                else
                if (line.charAt(i) + leap > 'z' || (Character.isUpperCase(line.charAt(i)) && line.charAt(i) + leap > 'Z'))
                    crypted_line += (char)(line.charAt(i) + leap - 26);
                else if (line.charAt(i) + leap < 'A' || (Character.isLowerCase(line.charAt(i)) && line.charAt(i) + leap < 'a'))
                    crypted_line += (char)(line.charAt(i) + leap + 26);
                else
                    crypted_line += (char)(line.charAt(i) + leap);
            }
            crypted_poem.add(crypted_line);
        }
        System.out.println("The poem was : ");
        for (String line : poem)
            System.out.println(line);
        System.out.println("\nAnd now its :");
        for (String line : crypted_poem)
            System.out.println(line);
        return true;
    }
}
