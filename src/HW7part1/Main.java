package HW7part1;

import java.util.Scanner;
import java.io.*;

import static java.lang.System.*;

public class Main {
    public static String inCode(String textIn){
        char[] arrayChar  = textIn.toCharArray();
        String textOut =new String();
        char chOccur = 0;
        int numOccur = 0; // occurences of a character inside the given string
        int i = 0;
        for (char ch : arrayChar){
            if (ch != chOccur && i != 0) {
                textOut += chOccur+"("+numOccur+")";
                numOccur = 1 ; // refreshes the number of occurences for the next iteration step
            } else {
                numOccur++; // if  a letter is repeated then numOccur increases
            }
            i++; //every iteration moves along the string (gets value 1 at first iteration)
            chOccur = ch; // first iteration becomes a first letter from a given string
        }
            textOut += chOccur+"("+numOccur+")";
        return textOut;
    }

    public static String deCode(String textIn){
        String textOut =new String();
        char[] arrayChar  = textIn.toCharArray();
        char chOccur = 0;
        int numOccur = 0; // occurences of a character inside the given string
        int i = 0;
        int step = 1;
        do {
            if ((i != 0) && ((i+1) != arrayChar.length)) {
           //     if ((Character.isDigit(arrayChar[i]))&&(arrayChar[i+1] == ')')&&(arrayChar[i-1] == '(')) {
            //        numOccur=Character.getNumericValue(arrayChar[i]);
             //       step = 2;
             if ((Character.isDigit(arrayChar[i+1]))&&(arrayChar[i] == '(')) {
                numOccur=Character.getNumericValue(arrayChar[i+1]);
                step = 3;
            }
                for (int j = 0; j < numOccur; j++) {
                    textOut += arrayChar[i-1];
                }
            }
            i += step;
            numOccur = 0;
            step = 1;
        } while (i<arrayChar.length);
        return textOut;
    }
    public static void main(String[] args) throws IOException {
    System.out.println("Введите строку для кодирования: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String strIn =br.readLine();
        System.out.println(strIn);
        String strOut;
        strOut=inCode(strIn);
        System.out.println("Закодированная строка: ");
        System.out.println(strOut);
        String strBack;
        strBack=deCode(strOut);
        System.out.println("Строка после разкодирования: ");
        System.out.println(strBack);

    }
}
